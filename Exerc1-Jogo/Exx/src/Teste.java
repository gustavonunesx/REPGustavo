public class Teste {
        public static void main(String[] args) {

            Personagem personagem = new Personagem(1, "Harry", 1000, 10, 200);
            Inimigo inimigo = new Inimigo(1, "Dragão", 3000, 300);
            Ataque ataqueFisico = new Ataque(1, "fisico", 20);  // Ataque físico com 20 de dano
            Ataque ataqueMagico = new Ataque(2, "magico", 50);  // Ataque mágico com 50 de dano

            System.out.println("Simulando a batalha...\n");

            personagem.atacar(inimigo, ataqueFisico);
            personagem.atacar(inimigo, ataqueMagico);


            Ataque ataqueFisicoInimigo = new Ataque(3, "fisico", 40);  // Ataque físico do inimigo
            inimigo.atacar(personagem, ataqueFisicoInimigo);


            personagem.atacar(inimigo, ataqueFisico);


            System.out.println("\nResultado Final da Batalha:");
            System.out.println(personagem.getNome() + " tem " + personagem.getHp() + " de vida restante.");
            System.out.println(inimigo.getNome() + " tem " + inimigo.getHp() + " de vida restante.");
        }
    }


