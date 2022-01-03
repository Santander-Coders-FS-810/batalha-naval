package src;

import java.util.Scanner;

public class Jogador {

    String nome;
    static int vitorias;
    int derrotas;

    public Jogador(String nome, int vitorias, int derrotas) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        this.nome = nome;
    }

    public static int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        Jogador.vitorias = vitorias;
    }

    public static int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
    
    static void configNomeJogador() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Qual o seu nome comandante: ");
            setNome(sc.next());
        }
    }

    static void informaPlacar() {
        System.out.println("Placar");
        System.out.println("Vitórias: " + getVitorias());
        System.out.println("Derrotas: " + getDerrotas());
    }
        
    
}
