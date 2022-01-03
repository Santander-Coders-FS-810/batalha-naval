package src;

import src.Jogador;
import src.Tabuleiro;
import src.CasaTabuleiro;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        iniciaJogo();
        Jogador.configNomeJogador(); // TODO: Definir classe com as configurações do jogador (nome, placar, etc)
        Tabuleiro.configTabuleiro(); // TODO: Definir classe com as configurações do tabuleiro (tamanho, quantidade de navios, posicionamento randomico ou manual, etc)
        while (true) { // TODO: Enquanto o jogo não acabar, o jogador deve escolher uma casa para atacar
            Tabuleiro.informaPlacar();
            iniciaNovaPartida(); // TODO: Inicia uma nova partida

            // imprimeTabuleiro();
            // defineJogada();
            // if (verificaVencedor()) {
            //     System.out.println("O vencedor foi " + jogadorAtual);
            //     break;
            // }
            // trocaJogador();
            encerrarJogo();
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
        while (true) {
            System.out.println("Bem vindo ao jogo da batalha naval.");
            System.out.println("Prepare-se para iniciar a batalha do século.");
            System.out.println("Você é o comandante da marinha e precisa");
            System.out.println("descobrir a localização dos navios inimigos.");
            System.out.println("Mas cuidado pois os navios inimigos estão");
            System.out.println("prontos para atacá-lo.");
            System.out.println("Você está pronto ? (S) ");
            String resposta = (sc.next());
            if (resposta.toLowerCase().charAt(0) == 's') {
                break;
            }
        }
        sc.close();
    }

    static void iniciaNovaPartida(){
        Tabuleiro.limpaTabuleiro();
        Tabuleiro.getModo();

    }
    

    


}