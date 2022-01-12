package src;

import java.util.List;

public class Tabuleiro {

    int maxLinha = 10;
    int maxColuna = 10;
    Posicao[][] tabuleiro;
    public String modo;

    enum colunas {
        A, B, C, D, E, F, G, H, I, J
    }

    public String getModo() {
        return this.modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Posicao getPosicaoNavio(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public void setPosicaoNavio(List<Posicao> listaNavio, int index) {
        tabuleiro[listaNavio.get(index).getLinha()][listaNavio.get(index).getColuna()] = listaNavio.get(index);
    }

    public Posicao[][] preencheTabuleiro() {
        tabuleiro = new Posicao[maxLinha][maxColuna];
        for (int linha = 0; linha < maxLinha; linha++) {
            for (int coluna = 0; coluna < maxColuna; coluna++) {
                tabuleiro[linha][coluna] = new Posicao(linha, coluna, Posicao.PosicaoStatus.AGUA_AGUA);
            }
        }
        return tabuleiro;
    }
    
    public void imprimeTabuleiro(Tabuleiro tabuleiro) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|   |  A  |  B  |  C  |  D  |  E  |  F  |  G  |  H  |  I  |  J  |");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < tabuleiro.maxLinha; i++) {
            System.out.printf("| %s ", i);
            for (int j = 0; j < tabuleiro.maxColuna; j++) {
                System.out.printf("| %s ", tabuleiro.getPosicaoNavio(i, j).getPosicaoStatusString());
            }
            System.out.println("|");
            System.out.println("-----------------------------------------------------------------");
        }

    }
    
}
