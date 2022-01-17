package pt.pa.patterns.model;

import java.util.List;

public class PrecoMedioSemIvaStrategy implements Strategy{
    @Override
    public double compute(List<Produto> produtosList) {
        double average = 0, sum = 0;

        for (Produto produto:produtosList) {
            sum += produto.getCustoSemIva();
        }

        average = sum / produtosList.size();

        return average;
    }
}
