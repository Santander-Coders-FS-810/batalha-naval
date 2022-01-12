package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partida {

    private List<Posicao> listaNavios = new ArrayList();
    private Posicao navio;
    private int navioLinha;
    private int navioColuna;
    private int navioNumber = 10;
    private Random random = new Random();

    public void setNavioLinha(int navioLinha) {
        this.navioLinha = navioLinha;
    }

    public void setNavioColuna(int navioColuna) {
        this.navioColuna = navioColuna;
    }

    public void adicionarNavio(Posicao navio) {
        listaNavios.add(navio);
    }

    public List<Posicao> posicionarNaviosRandomicamente() {
        while (navioNumber != 0) {
            setNavioLinha(random.nextInt(9));
            setNavioColuna(random.nextInt(9));

            for (int i = 0; i < listaNavios.size(); i++) {
                while (navioLinha == listaNavios.get(i).getLinha() && navioColuna == listaNavios.get(i).getColuna()) {
                    setNavioLinha(random.nextInt(9));
                    setNavioColuna(random.nextInt(9));
                }
            }

            navio = new Posicao(navioLinha, navioColuna, Posicao.PosicaoStatus.NAVIO_DESCONHECIDO);
            adicionarNavio(navio);
            navioNumber--;
        }
        //
        return listaNavios;
    }
}