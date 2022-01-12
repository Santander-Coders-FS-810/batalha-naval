package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        iniciaJogo();
        imprimeLegenda();

        Tabuleiro tabuleiro = new Tabuleiro();

        
        // TODO: Fazer lógica de JOGAR







    }
    
    private static void encerrarJogo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Você deseja sair do jogo ? (S) ");
        String resposta = (sc.next());
        if (resposta.equals("S")) {
            System.out.println("Obrigado por jogar!");
            System.exit(0);
        }
        sc.close();
    }


    

    public static void iniciaJogo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo da batalha naval.");
        System.out.println("Prepare-se para iniciar a batalha do século.");
        System.out.println("Você é o comandante da marinha e precisa");
        System.out.println("descobrir a localização dos navios inimigos.");
        System.out.println("Mas cuidado pois os navios inimigos estão");
        System.out.println("prontos para atacá-lo.");
        System.out.println("Você está pronto ? (S) ");
        while (true) {
        String resposta = (sc.next());
            if (resposta.toLowerCase().charAt(0) == 's') {
                break;
            }
        }
        sc.close();
    }
    
    public static void imprimeLegenda() {
        System.out.println("---------------LEGENDA-------------------");
        System.out.println("|   | --> JOGADOR   --> COMPUTADOR");      
        System.out.println("|   | --> Água      --> Desconhecido");
        System.out.println("| ~ | --> Água      --> Tiro na água");
        System.out.println("| * | --> Água      --> Navio abatido");
        System.out.println("| N | --> Navio     --> Desconhecido");
        System.out.println("| n | --> Navio     --> Tiro na água");
        System.out.println("| X | --> Navio     --> Navio abatido");
        System.out.println("-----------------------------------------");

    }

    


}