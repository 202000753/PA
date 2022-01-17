package pt.pa.patterns.model;

public class LojaInformaticaContinente extends LojaInformatica {
    public LojaInformaticaContinente() {
        super(23);
    }

    @Override
    public Produto obterProduto(String referencia) throws ProdutoInexistente {
        switch(referencia) {
            case "100":
                return new Produto("Processador Intel", 250, this.getIva());
            case "101":
                return new Produto("Processador AMD", 180, this.getIva());
            case "102":
                return new Produto("Placa gráfica nVidia", 500, this.getIva());
            case "103":
                return new Produto("Placa gráfica ATI", 450, this.getIva());
            default:
                throw new ProdutoInexistente(referencia);
        }
    }
}
