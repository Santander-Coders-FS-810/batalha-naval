package src;

import java.util.Scanner;

public class Tabuleiro {

    public int tamanhoTabuleiro;
    public int quantidadeNavios;
    public String modo;
    
    public int getQuantidadeNavios() {
        return quantidadeNavios;
    }

    public void setQuantidadeNavios(int quantidadeNavios) {
        this.quantidadeNavios = quantidadeNavios;
    }

    public static String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;
    }

    public void setTamanhoTabuleiro(int tamanhoTabuleiro) {
        this.tamanhoTabuleiro = tamanhoTabuleiro;
    }

    public void configTamanhoTabuleiro(int tamanhoTabuleiro) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Defina o tamanho do tabuleiro (4-10): ");
            setTamanhoTabuleiro(sc.nextInt());
            if (this.tamanhoTabuleiro >= 4 && this.tamanhoTabuleiro <= 10) {
                break;
            } else {
                System.out.println("Tamanho do tabuleiro inválido. Tente novamente.");
            }
        }
        sc.close();
    }

    public static void informaPlacar() {
        System.out.println("Placar");
        System.out.println("Vitórias: " + Jogador.getVitorias());
        System.out.println("Derrotas: " + Jogador.getDerrotas());
    }

    public static void configTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.configTamanhoTabuleiro(tabuleiro.getTamanhoTabuleiro());
        System.out.println("Defina o modo de posicionamento dos navios (1-Modo Randômico, 2-Modo Manual): ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            tabuleiro.setModo(sc.next());
            if (getModo().equals("1") || getModo().equals("2")) {
                break;
            } else {
                System.out.println("Modo de jogo inválido. Tente novamente.");
            }
        }
        sc.close();
    }

    public static void limpaTabuleiro() {
    }

    public static void posicionaNaviosRandomicamente() {
    }

    public static void posicionaNaviosManualmente() {
    }

    
    
}
