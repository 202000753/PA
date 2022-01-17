package pt.pa.patterns.model;

public class BlackFriday extends Promocoes{
    public BlackFriday(LojaInformatica lojaInformatica) {
        super(lojaInformatica);
    }

    public Produto obterProduto(String referencia) throws ProdutoInexistente {
        Produto produto = this.getLojaInformatica().obterProduto(referencia);
        produto.aplicarDesconto(40);
        return produto;
    }
}
