package pt.pa.patterns.model;

public class LojaInformaticaAcores extends LojaInformaticaContinente{
    public LojaInformaticaAcores() {
        super();
        this.setIva(18);
    }

    @Override
    public Produto obterProduto(String referencia) throws ProdutoInexistente {
        switch(referencia) {

            case "201":
                return new Produto("Monitor 24 polegadas", 200, this.getIva());
            case "202":
                return new Produto("Webcam", 30, this.getIva());
            case "203":
                return new Produto("Auscultadores", 50, this.getIva());
            default:
                return super.obterProduto(referencia);
        }
    }
}
