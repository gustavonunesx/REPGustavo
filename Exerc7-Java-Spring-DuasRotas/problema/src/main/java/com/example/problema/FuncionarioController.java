package com.example.problema;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getFuncionarios(){
        return funcionarios;
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable int id) {
        return funcionarios.stream()
                .filter(func -> func.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
    }

    @PostMapping
    public Funcionario createFuncionario (@RequestBody Funcionario newFuncionario){
        funcionarios.add(newFuncionario);
        return newFuncionario;
    }
    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable int id, @RequestBody Funcionario newFuncionario){
        Funcionario funcionario = funcionarios.stream()
                .filter(func -> func.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));

        funcionario.setNome(newFuncionario.getNome());
        funcionario.setDepartamento(newFuncionario.getDepartamento());
        return funcionario;
    }

}
