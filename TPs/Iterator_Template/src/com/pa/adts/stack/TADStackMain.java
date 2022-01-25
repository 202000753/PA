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
        Stack<Integer> stack1 = new StackArray<Integer>();
        for(int i=0; i<10;i++)
            stack1.push(i);

        for (Integer integer:stack1)
            System.out.println(integer);

        //Linked
        Stack<Integer> stack2 = new StackLinked<Integer>();
        for(int i=0; i<10;i++)
            stack2.push(i);

        for (Integer integer:stack2)
            System.out.println(integer);
    }
}
