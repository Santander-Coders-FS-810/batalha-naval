package src;

public class Jogador {

    int vitorias;
    int derrotas;

    enum Modo {
        RANDOM, MANUAL
    }

    public Jogador(int vitorias, int derrotas) {
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    private int getVitorias() {
        return this.vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    private int getDerrotas() {
        return this.derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void informaPlacar() {
        System.out.println("Placar");
        System.out.println("Vitórias: " + getVitorias());
        System.out.println("Derrotas: " + getDerrotas());
    }


        

    
}
