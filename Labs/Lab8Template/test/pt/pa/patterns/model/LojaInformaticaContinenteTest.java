package pt.pa.patterns.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LojaInformaticaContinenteTest {
    @Test
    @DisplayName("ProdutoInexistente")
    void ProdutoInexistente() {
        LojaInformatica lojaInformatica = new LojaInformaticaContinente();
        assertThrows(ProdutoInexistente.class, ()->
                lojaInformatica.obterProduto("123"));
    }
}