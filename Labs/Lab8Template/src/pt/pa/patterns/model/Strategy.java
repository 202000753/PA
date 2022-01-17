package pt.pa.patterns.model;

import java.util.List;

public interface Strategy {
    public double compute(List<Produto> produtosList);
}
