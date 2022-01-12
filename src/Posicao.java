package src;

import java.util.Objects;

public class Posicao {

    private int linha;
    private int coluna;
    private PosicaoStatus posicaoStatus;

    public enum PosicaoStatus {
        AGUA_DESCONHECIDO,
        AGUA_AGUA,
        AGUA_NAVIO,
        NAVIO_DESCONHECIDO,
        NAVIO_AGUA,
        NAVIO_NAVIO
    }

    public Posicao(int linha, int coluna, PosicaoStatus posicaoStatus) {
        this.linha = linha;
        this.coluna = coluna;
        this.posicaoStatus = posicaoStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicao Posicao = (Posicao) o;
        return linha == Posicao.linha && coluna == Posicao.coluna && posicaoStatus == Posicao.posicaoStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linha, coluna, posicaoStatus);
    }

    public PosicaoStatus getPosicaoStatus() {
        return posicaoStatus;
    }

    public void setposicaoStatus(PosicaoStatus posicaoStatus) {
        this.posicaoStatus = posicaoStatus;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String getPosicaoStatusString() {
        String posicaoStatusString = "";

        switch (posicaoStatus) {
            case AGUA_DESCONHECIDO:
                posicaoStatusString = "   ";
                break;
            case AGUA_AGUA:
                posicaoStatusString = " ~ ";
                break;
            case AGUA_NAVIO:
                posicaoStatusString = " * ";
                break;
            case NAVIO_DESCONHECIDO:
                posicaoStatusString = " N ";
                break;
            case NAVIO_AGUA:
                posicaoStatusString = " n ";
                break;
            case NAVIO_NAVIO:
                posicaoStatusString = " X ";
                break;
            default:
                System.err.println("posicaoStatus não existe!!!");
        }
        return posicaoStatusString;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "linha=" + linha +
                ", coluna=" + coluna +
                ", posicaoStatus=" + posicaoStatus +
                '}';
    }
}
