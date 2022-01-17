package pt.pa.patterns.model;

/**
 *
 * @author brunomnsilva
 */
public class Produto {
    private String nome;
    private double custoSemIva;
    private double iva;

    public Produto(String nome, double custoSemIva, double iva) {
        this.nome = nome;
        this.custoSemIva = custoSemIva;
        this.iva = iva;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoSemIva() {
        return custoSemIva;
    }

    public double getIva() {
        return iva;
    }

    public double getCustoComIva() {
        return getCustoSemIva() * (1 + getIva()/100);
    }

    public void aplicarDesconto(double percentagem) {
        this.custoSemIva *= (1 - percentagem/100);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", custoSemIva=" + custoSemIva +
                ", iva=" + iva +
                '}';
    }
}
