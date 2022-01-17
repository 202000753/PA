package pt.pa.patterns.model;

/**
 *
 * @author brunomnsilva
 */
public class ProdutoInexistente extends Exception {

    public ProdutoInexistente(String referencia) {
        super("O produto com a referência (" + referencia + ") não existe.");
    }
}
