package pt.pa.patterns;

import pt.pa.patterns.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amfs
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) throws ProdutoInexistente {
        //Nivel1/2
        System.out.println("Nivel1/2");
        LojaInformatica lojaInformaticaC = new LojaInformaticaContinente();
        Produto produto = lojaInformaticaC.obterProduto("100");
        System.out.println(produto);

        LojaInformatica lojaInformaticaA = new LojaInformaticaAcores();
        produto = lojaInformaticaA.obterProduto("100");
        System.out.println(produto);
        produto = lojaInformaticaA.obterProduto("201");
        System.out.println(produto);

        //Nivel3
        System.out.println("\nNivel3");
        List lista1 =new ArrayList();
        List lista2 =new ArrayList();

        lista1.add(new Produto("Processador Intel", 250, 23));
        lista1.add(new Produto("Processador AMD", 180, 23));
        lista1.add(new Produto("Placa gráfica nVidia", 500, 23));
        lista1.add(new Produto("Placa gráfica ATI", 450, 23));

        lista2.add(new Produto("Monitor 24 polegadas", 200, 18));
        lista2.add(new Produto("Webcam", 30, 18));
        lista2.add(new Produto("Auscultadores", 50, 18));

        Strategy strategy = new PrecoMedioSemIvaStrategy();
        System.out.println("Media lista1 semIVA: " + strategy.compute(lista1));
        System.out.println("Media lista2 semIVA: " + strategy.compute(lista2));

        strategy = new PrecoMedioComIvaStrategy();
        System.out.println("Media lista1 comIVA: " + strategy.compute(lista1));
        System.out.println("Media lista2 comIVA: " + strategy.compute(lista2));

        //Nivel4
        System.out.println("\nNivel4");
        System.out.println("Media lista1 semIVA: " + lojaInformaticaC.determinarPreco(lista1));
        System.out.println("Media lista2 semIVA: " + lojaInformaticaA.determinarPreco(lista2));

        lojaInformaticaC.setStrategy(new PrecoMedioComIvaStrategy());
        lojaInformaticaA.setStrategy(new PrecoMedioComIvaStrategy());
        System.out.println("Media lista1 comIVA: " + lojaInformaticaC.determinarPreco(lista1));
        System.out.println("Media lista2 comIVA: " + lojaInformaticaA.determinarPreco(lista2));

        //Nivel5
        System.out.println("\nNivel5");
        Promocoes promocoes = new BlackFriday(lojaInformaticaC);
        System.out.println(promocoes.obterProduto("100"));
    }
}
