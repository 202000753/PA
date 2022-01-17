package pt.pa.patterns.model;

/**
 *
 * @author brunomnsilva
 */
public interface LojaInformaticaFactory {

    public Produto obterProduto(String referencia) throws ProdutoInexistente;
}
