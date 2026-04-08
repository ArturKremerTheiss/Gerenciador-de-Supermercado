package model;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens = new ArrayList<>();

    public void adicionar(Produto p) {
        itens.add(p);
    }

    public void remover(Produto p) {
        itens.remove(p);
    }

    public double total() {
        double t = 0;
        for (Produto p : itens) {
            t += p.getPreco();
        }
        return t;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }
}