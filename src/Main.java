import src.Tabuleiro;
import src.Textos;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Tabuleiro humano = new Tabuleiro(sc);
        Tabuleiro pc = new Tabuleiro(sc);


        Textos.iniciaJogo(sc);
        Textos.imprimeLegenda();

        System.out.println("Você deseja escolher a posição dos navios? 'S para sim' 'N para não' ");
        if (sc.next().toUpperCase(Locale.ROOT).equals("S")) {
            humano.escolherPosicaoDoNavio();
        } else {
            humano.sortearPosicaoDoNavio();
        }


        pc.sortearPosicaoDoNavio();


        humano.preencherTabuleiro();
        // imprimirPosicoes(humano);
        imprimirTabuleiro2(humano);


        pc.preencherTabuleiro();
        imprimirPosicoes(pc);
        //imprimirTabuleiro2(pc);

        while (pc.getAcertos() != 10 || humano.getAcertos() != 10) {

            darTiro(pc, humano, sc);
            darTiroPC(humano, pc, sc);

            imprimirTabuleiro2(humano);

            imprimirTabuleiro2(pc);
            System.out.println(humano.getAcertos());
           System.out.println(pc.getAcertos());



        }

        if (humano.getAcertos() > pc.getAcertos()) {
            System.out.println("Voce Ganhou! Deseja Continuar? 'S' para sim ou 'N' para não ");
            encerrarJogo(sc);
        } else {
            System.out.println("Você Perdeu! Deseja Continuar? 'S' para sim ou 'N' para não ");
            encerrarJogo(sc);
        }


    }

    public static void imprimirTabuleiro2(Tabuleiro tabuleiro) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("| %s ", tabuleiro.letraLinha(i));

            for (int j = 0; j < 10; j++) {
                if (tabuleiro.tabuleiro[i][j] == 1) {
                    System.out.printf("| %s ", "N");
                } else if (tabuleiro.tabuleiro[i][j] == 0) {
                    System.out.printf("| %s ", " ");
                } else if (tabuleiro.tabuleiro[i][j] == 2) {
                    System.out.printf("| %s ", "*");
                } else if (tabuleiro.tabuleiro[i][j] == 3) {
                    System.out.printf("| %s ", "-");
                } else if (tabuleiro.tabuleiro[i][j] == 4) {
                    System.out.printf("| %s ", "X");
                } else if (tabuleiro.tabuleiro[i][j] == 6) {
                    System.out.printf("| %s ", "x");
                }

            }
            System.out.println("|\n");
        }
        System.out.println("|");
        System.out.println("-----------------------------------------------------------------");
    }


    public static void imprimeTabuleiro(Tabuleiro tabuleiro) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("| %s ", tabuleiro.letraLinha(i));

            for (int j = 0; j < 10; j++) {
                if (tabuleiro.navios[i][0] == i && tabuleiro.navios[j][1] == j) {
                    System.out.printf("| %s ", "N");
                } else {
                    System.out.printf("| %s ", " ");
                }

            }
            System.out.println("|");
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public static void encerrarJogo(Scanner sc) {
        if (sc.next().toUpperCase(Locale.ROOT).equals("S")) {
            //reiniciar Jogo
        } else {
            System.out.println("Obrigado por jogar!");
            System.exit(0);
        }

    }

    public static void darTiro(Tabuleiro inimigo, Tabuleiro jogador, Scanner sc) {
        int linha;
        int coluna;
        System.out.println("Digite a letra da linha em que deseja atirar 'exemplo A ':");
        linha = inimigo.letraNumero(sc.next());
        System.out.println("Digite o numero da coluna em que deseja atirar 'exemplo 2 ':");
        coluna = sc.nextInt();
        /*
        Agua é 0
        Navio posicionado N (ene maiúsculo) 1
                . Tiro certeiro * (asterisco) 2
                . Tiro na água – (traço) 3
                . Tiro certeiro com navio posicionado X (xis maiúsculo) 4
                . Tiro na água com navio posicionado n (ene minúsculo) 5 */


        //Tiro certeiro * (asterisco) 2
        if (inimigo.tabuleiro[linha][coluna] != 0 && jogador.tabuleiro[linha][coluna] == 0) {
            jogador.tabuleiro[linha][coluna] = 2;
            jogador.acertos += 1;

        }
        //Tiro na água – (traço) 3
        if (inimigo.tabuleiro[linha][coluna] == 0 && jogador.tabuleiro[linha][coluna] == 0) {
            jogador.tabuleiro[linha][coluna] = 3;

        }

        //. Tiro certeiro com navio posicionado X (xis maiúsculo) 4
        if (inimigo.tabuleiro[linha][coluna] != 0 && jogador.tabuleiro[linha][coluna] != 0) {
            jogador.tabuleiro[linha][coluna] = 4;
            jogador.acertos += 1;

        }

        //. Tiro na água com navio posicionado n (ene minúsculo) 5
        if (inimigo.tabuleiro[linha][coluna] == 0 && jogador.tabuleiro[linha][coluna] != 0) {
            jogador.tabuleiro[linha][coluna] = 5;


        }


        System.out.println("tiro dado");
    }

    public static void darTiroPC(Tabuleiro inimigo, Tabuleiro jogador, Scanner sc) {
        int linha;
        int coluna;

        Random sorteio = new Random();

        linha = sorteio.nextInt(10);
        coluna = sorteio.nextInt(10);

        System.out.println(linha);
        System.out.println(coluna);



        while (true) {
            linha = sorteio.nextInt(10);
            coluna = sorteio.nextInt(10);
            if(jogador.tabuleiro[linha][coluna] == 0 || jogador.tabuleiro[linha][coluna] == 1){
                System.out.println(linha);
                System.out.println(coluna);
                break;
            }


        }




        /*System.out.println("Digite a letra da linha em que deseja atirar 'exemplo A ':");
        linha = inimigo.letraNumero(sc.next());
        System.out.println("Digite o numero da coluna em que deseja atirar 'exemplo 2 ':");
        coluna = sc.nextInt();*/
        /*
        Agua é 0
        Navio posicionado N (ene maiúsculo) 1
                . Tiro certeiro * (asterisco) 2
                . Tiro na água – (traço) 3
                . Tiro certeiro com navio posicionado X (xis maiúsculo)4
                . Tiro na água com navio posicionado n (ene minúsculo) 5 */


        //Tiro certeiro * (asterisco) 2
        if (inimigo.tabuleiro[linha][coluna] != 0 && jogador.tabuleiro[linha][coluna] == 0) {
            jogador.tabuleiro[linha][coluna] = 2;
            jogador.acertos += 1;

        }
        //Tiro na água – (traço) 3
        if (inimigo.tabuleiro[linha][coluna] == 0 && jogador.tabuleiro[linha][coluna] == 0) {
            jogador.tabuleiro[linha][coluna] = 3;

        }

        //. Tiro certeiro com navio posicionado X (xis maiúsculo) 4
        if (inimigo.tabuleiro[linha][coluna] != 0 && jogador.tabuleiro[linha][coluna] != 0) {
            jogador.tabuleiro[linha][coluna] = 4;
            jogador.acertos += 1;

        }

        //. Tiro na água com navio posicionado n (ene minúsculo) 5
        if (inimigo.tabuleiro[linha][coluna] == 0 && jogador.tabuleiro[linha][coluna] != 0) {
            jogador.tabuleiro[linha][coluna] = 5;


        }


        System.out.println("tiro dado");
    }


    //Imprimir Posições selecionadas
    public static void imprimirPosicoes(Tabuleiro tabuleiro) {

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s%s\n", tabuleiro.letraLinha(tabuleiro.navios[i][0]), tabuleiro.navios[i][1]);

        }
    }
}
