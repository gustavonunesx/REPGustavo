package com.example.problema;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {



//1 PASSO CRIANDO "BANCO"
    private List<Departamento> deps = new ArrayList<>();


//ROTA PRA RETORNAR OS FUNCIONARIOS
    @GetMapping
    public List<Departamento> getUser() {
        return deps;
    }

    @GetMapping("/{id}")
    public Departamento getUserById(@PathVariable int id) {
        return deps.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

    }

    @PostMapping
    public Departamento createUser(@RequestBody Departamento newDepart) {
        deps.add(newDepart);
        return newDepart;
    }


    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable int id, @RequestBody Departamento newDepart) {
        Departamento departamento = deps.stream()
                .filter(dep -> dep.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        departamento.setNome(newDepart.getNome());
        return departamento;


    }

}
