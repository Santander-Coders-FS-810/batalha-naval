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
        imprimirTabuleiro(humano);


        pc.preencherTabuleiro();
        imprimirPosicoes(pc);


        while (true) {

            darTiro(pc,humano,sc);
            darTiroPC(humano, pc, sc);

            System.out.println("Humano");
            imprimirTabuleiro(humano);
            System.out.println("PC");
            imprimirTabuleiro(pc);

            //imprimirTabuleiro2(pc);
            System.out.println("Voce tem:"+humano.getAcertos()+" pontos");
            System.out.println("Seu inimigo tem:"+pc.getAcertos()+" pontos");
            if (pc.acertos > 10){
                break;
            }
            if (humano.acertos > 10){
                break;
            }


        }

        if (humano.getAcertos() > pc.getAcertos()) {
            System.out.println("Voce Ganhou! Deseja Continuar? 'S' para sim ou 'N' para não ");
            encerrarJogo(sc);
        } else {
            System.out.println("Você Perdeu! Deseja Continuar? 'S' para sim ou 'N' para não ");
            encerrarJogo(sc);
        }


    }

    public static void imprimirTabuleiro(Tabuleiro tabuleiro) {
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
                } else if (tabuleiro.tabuleiro[i][j] == 5) {
                    System.out.printf("| %s ", "x");
                }

            }
            System.out.println("|\n");
        }
        System.out.println("|");
        System.out.println("-----------------------------------------------------------------");
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
        boolean navioJogador = false;
        boolean navioInimigo = false;

        System.out.println("Digite a letra da linha em que deseja atirar 'exemplo A ':");
        linha = inimigo.letraNumero(sc.next());
        System.out.println("Digite o numero da coluna em que deseja atirar 'exemplo 2 ':");
        coluna = sc.nextInt();

        switch (inimigo.tabuleiro[linha][coluna]){
            case 0:
                navioInimigo = false;
                break;
            case 1:
                navioInimigo = true;
                break;
            case 2:
                navioInimigo = false;
                break;
            case 3:
                navioInimigo = false;
                break;
            case 4:
                navioInimigo = true;
                break;
            case 5:
                navioInimigo = true;
                break;
        }
        System.out.println("switch"+ inimigo.tabuleiro[linha][coluna]+navioInimigo );
        switch (jogador.tabuleiro[linha][coluna]){
            case 0:
                navioJogador = false;
                break;
            case 1:
                navioJogador = true;
                break;
            case 2:
                navioJogador = false;
                break;
            case 3:
                navioJogador = false;
                break;
            case 4:
                navioJogador = true;
                break;
            case 5:
                navioJogador = true;
                break;
        }


        if(navioInimigo == false && navioJogador == false){
            jogador.tabuleiro[linha][coluna] = 3;

        }
        if(navioInimigo == false && navioJogador == true){
            jogador.tabuleiro[linha][coluna] = 5;

        }
        if(navioInimigo == true && navioJogador == true){
            jogador.tabuleiro[linha][coluna] = 4;
            jogador.acertos += 1;

        }
        if(navioInimigo == true && navioJogador == false){
            jogador.tabuleiro[linha][coluna] = 2;
            jogador.acertos += 1;

        }




        /*if((inimigo.tabuleiro[linha][coluna]) == (0|2|3)){
            if(jogador.tabuleiro[linha][coluna] == 1){
                jogador.tabuleiro[linha][coluna] = 5;
            }
            if(jogador.tabuleiro[linha][coluna] == 0){
                jogador.tabuleiro[linha][coluna] = 3;
            }
        }

        if((inimigo.tabuleiro[linha][coluna]) == (1|4|5)){
            if(jogador.tabuleiro[linha][coluna] == 1){
                jogador.tabuleiro[linha][coluna] = 4;
            }
            if(jogador.tabuleiro[linha][coluna] == 0){
                jogador.tabuleiro[linha][coluna] = 2;
            }
            jogador.acertos += 1;
        }*/

        /*
        Agua é 0   n
        Navio posicionado N (ene maiúsculo) 1  s
                . Tiro certeiro * (asterisco) 2  n
                . Tiro na água – (traço) 3  n
                . Tiro certeiro com navio posicionado X (xis maiúsculo) 4 s
                . Tiro na água com navio posicionado n (ene minúsculo) 5  s*/

/*

        //Tiro certeiro * (asterisco) 2
        if (inimigo.tabuleiro[linha][coluna] != 0 && jogador.tabuleiro[linha][coluna] == 0) {
            jogador.tabuleiro[linha][coluna] = 2;
            //jogador.acertos += 1;

        }
        //Tiro na água – (traço) 3
        if (inimigo.tabuleiro[linha][coluna] == 0 && jogador.tabuleiro[linha][coluna] == 0) {
            jogador.tabuleiro[linha][coluna] = 3;

        }

        //. Tiro certeiro com navio posicionado X (xis maiúsculo) 4
        if (inimigo.tabuleiro[linha][coluna] != 0 && jogador.tabuleiro[linha][coluna] != 0) {
            jogador.tabuleiro[linha][coluna] = 4;
            //jogador.acertos += 1;

        }

        //. Tiro na água com navio posicionado n (ene minúsculo) 5
        if (inimigo.tabuleiro[linha][coluna] == 0 && jogador.tabuleiro[linha][coluna] != 0) {
            jogador.tabuleiro[linha][coluna] = 5;


        }
*/
    }

    public static void darTiroPC(Tabuleiro inimigo, Tabuleiro jogador, Scanner sc) {
        int linha;
        int coluna;
        boolean navioJogador = true;
        boolean navioInimigo = true;

        Random sorteio = new Random();

        linha = sorteio.nextInt(10);
        coluna = sorteio.nextInt(10);




        while (true) {
            linha = sorteio.nextInt(10);
            coluna = sorteio.nextInt(10);
            if (jogador.tabuleiro[linha][coluna] == 0 || jogador.tabuleiro[linha][coluna] == 1) {

                break;
            }


        }

        switch (inimigo.tabuleiro[linha][coluna]){
            case 0:
                navioInimigo = false;
                break;
            case 1:
                navioInimigo = true;
                break;
            case 2:
                navioInimigo = false;
                break;
            case 3:
                navioInimigo = false;
                break;
            case 4:
                navioInimigo = true;
                break;
            case 5:
                navioInimigo = true;
                break;
        }
        System.out.println("switch"+ inimigo.tabuleiro[linha][coluna]+navioInimigo );
        switch (jogador.tabuleiro[linha][coluna]){
            case 0:
                navioJogador = false;
                break;
            case 1:
                navioJogador = true;
                break;
            case 2:
                navioJogador = false;
                break;
            case 3:
                navioJogador = false;
                break;
            case 4:
                navioJogador = true;
                break;
            case 5:
                navioJogador = true;
                break;
        }


        if(navioInimigo == false && navioJogador == false){
            jogador.tabuleiro[linha][coluna] = 3;

        }
        if(navioInimigo == false && navioJogador == true){
            jogador.tabuleiro[linha][coluna] = 5;

        }
        if(navioInimigo == true && navioJogador == true){
            jogador.tabuleiro[linha][coluna] = 4;
            jogador.acertos += 1;

        }
        if(navioInimigo == true && navioJogador == false){
            jogador.tabuleiro[linha][coluna] = 2;
            jogador.acertos += 1;

        }



    }


    //Imprimir Posições selecionadas
    public static void imprimirPosicoes(Tabuleiro tabuleiro) {

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s%s\n", tabuleiro.letraLinha(tabuleiro.navios[i][0]), tabuleiro.navios[i][1]);

        }
    }
}
