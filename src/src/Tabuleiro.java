package src;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {




   public int acertos;

    Scanner sc;

    public Tabuleiro(Scanner scanner) {
        sc = scanner;

    }

    

   public int[][] tabuleiro = new int[10][10];
   public int[][] navios = new int[10][2];

    public void sortearPosicaoDoNavio(){
        Random sorteio = new Random();
        for(int navio=0; navio < 10 ; navio++){
            navios[navio][0] = sorteio.nextInt(10);
            navios[navio][1] = sorteio.nextInt(10);

            for(int anterior=0 ; anterior < navio ; anterior++){
                if( (navios[navio][0] == navios[anterior][0])&&(navios[navio][1] == navios[anterior][1]) )
                    do{
                        navios[navio][0]=sorteio.nextInt(10);
                        navios[navio][1]=sorteio.nextInt(10);
                    }while( (navios[navio][0] == navios[anterior][0])&&(navios[navio][1] == navios[anterior][1]) );
            }

        }

    }

    public void escolherPosicaoDoNavio() {

        String linha;
        int coluna = 0;


        for (int i = 0; i <= 9; i++) {
            System.out.printf("Escolha a Posição %sº do Navio \n", i + 1);
            System.out.println("Linha A B C D E F G H I J");
            linha = sc.next();
            if (linha.length() > 1) {
                error();
                escolherPosicaoDoNavio();
            }

            navios[i][0] = letraNumero(linha);
            System.out.println("Coluna 0 1 2 3 4 5 6 7 8 9");

            try {
                coluna = sc.nextInt();
                navios[i][1] = coluna;
            } catch (Exception ex) {
                error();

            }


            System.out.printf("Você posicionou seu %s navio na posição %s%s \n", i + 1, linha.toUpperCase(Locale.ROOT), coluna);

        }


    }

    public String letraLinha(int i) {
        return switch (i) {
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            case 4 -> "E";
            case 5 -> "F";
            case 6 -> "G";
            case 7 -> "H";
            case 8 -> "I";
            case 9 -> "J";
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }

    public void error() {
        System.out.println("digitou errado, comece novamente!");
        escolherPosicaoDoNavio();
    }

    public int letraNumero(String i) {
        return switch (i.toLowerCase(Locale.ROOT)) {
            case "a" -> 0;
            case "b" -> 1;
            case "c" -> 2;
            case "d" -> 3;
            case "e" -> 4;
            case "f" -> 5;
            case "g" -> 6;
            case "h" -> 7;
            case "i" -> 8;
            case "j" -> 9;
            default -> -1;
        };

    }

    public int getAcertos() {
        return acertos;
    }

    public void preencherTabuleiro(){
        int linha;
        int coluna;

        for(int i = 0 ; i< 10 ; i++){
            linha = navios[i][0];
            coluna = navios[i][1];
            tabuleiro[linha][coluna] = 1;
        }
    }


}
