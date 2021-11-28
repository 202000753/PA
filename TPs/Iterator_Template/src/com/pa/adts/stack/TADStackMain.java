/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.adts.stack;

/**
 *
 * @author patricia.macedo
 */
public class TADStackMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Stack<Integer> stack1 = new StackArray();
        for(int i=0; i<10;i++)
            stack1.push(i);

        // TODO foreach



    }

}
