/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.memento.model;

import java.util.*;

public class Caretaker {
    Stack<Memento> mementos;
    Originator originator;

    public Caretaker(Originator originator) {
        this.mementos = new Stack<>();
        this.originator = originator;
    }

    //deve obter e guardar o Memento atual
    public void saveState() {
        this.mementos.push(originator.createMemento());
    }

    /*deve reestabelecer o estado do originator com base
    no Memento guardado. Se não existir Memento guardado deve lançar a exceção NoMementoException*/
    public void restoreState() throws NoMementoException {
        if(this.mementos.peek() == null)
            throw new NoMementoException();

        originator.setMemento(this.mementos.pop());
    }
}
