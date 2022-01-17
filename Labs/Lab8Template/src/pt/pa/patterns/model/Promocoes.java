package pt.pa.patterns.model;

public class Promocoes implements LojaInformaticaFactory {
    private LojaInformatica lojaInformatica;

    public Promocoes(LojaInformatica lojaInformatica) {
        this.lojaInformatica = lojaInformatica;
    }

    public LojaInformatica getLojaInformatica() {
        return lojaInformatica;
    }

    @Override
    public Produto obterProduto(String referencia) throws ProdutoInexistente {
        return null;
    }

    public void aplicarDesconto(Produto p) {
    }
}
