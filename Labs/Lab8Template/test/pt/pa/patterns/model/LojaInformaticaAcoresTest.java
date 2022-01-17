package pt.pa.patterns.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LojaInformaticaAcoresTest {
    @Test
    @DisplayName("ProdutoInexistente continente")
    void ProdutoInexistente() throws ProdutoInexistente {
        LojaInformatica lojaInformaticaA = new LojaInformaticaContinente();
        LojaInformatica lojaInformaticaC = new LojaInformaticaAcores();
        assertEquals(lojaInformaticaA.obterProduto("100").getNome(), lojaInformaticaC.obterProduto("100").getNome());
        assertEquals(lojaInformaticaA.obterProduto("100").getCustoSemIva(), lojaInformaticaC.obterProduto("100").getCustoSemIva());
    }
}