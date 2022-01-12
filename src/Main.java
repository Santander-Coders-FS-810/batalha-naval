import src.Posicao;
import src.Tabuleiro;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        iniciaJogo();
        int numNaviosPc = 10;
        int numNaviosJogador = 10;
        imprimeLegenda();

        Tabuleiro tabuleiro = new Tabuleiro();

        
        // TODO: Fazer lógica de JOGAR

        while(true){
            // jogada player

            Scanner input = new Scanner(System.in);
            while(true){
                System.out.printf("Faça sua jogada: (linha e coluna) ex: %n");
                System.out.printf("1 (enter) %n");
                System.out.printf("7 (enter) %n");

                Random random = new Random();
                var jogadaLinha = random.nextInt(9) + 1;
                var jogadaColuna = random.nextInt(9) + 1; // TODO: fazer player escrever;

                if (jogadaLinha < 1 || jogadaLinha > 10){
                    System.out.println("Jogada inválida, tente novamente.");
                } else {
                    break;
                }
                // TODO: checar se acertou, se acertou subtrair 1 de numNaviosPc.
            }

            // jogada pc

            Random random = new Random();
            int jogadaLinhaPc = random.nextInt(9) + 1;
            int jogadaColunaPc = random.nextInt(9) + 1;

            // imprime tabuleiro

            Tabuleiro.imprimeTabuleiro(tabuleiro); // TODO: corrigir bug: quando entra no getPosicaoNavio dentro dessa funcao ele da erro.

            // check win
            // break se vencer
            break;
        }
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