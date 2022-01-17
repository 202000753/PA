package pt.pa.patterns.model;

import java.util.List;

public class LojaInformatica implements LojaInformaticaFactory{
    private double iva;
    public Strategy strategy;

    public LojaInformatica(double iva) {
        this.iva = iva;
        this.strategy = new PrecoMedioSemIvaStrategy();
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Produto obterProduto(String referencia) throws ProdutoInexistente {
        return null;
    }

    public double determinarPreco (List<Produto> produtosList) {
        return strategy.compute(produtosList);
    }
}
