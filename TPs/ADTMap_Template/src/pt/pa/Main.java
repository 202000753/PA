package pt.pa;

import javafx.print.Collation;
import pt.pa.adts.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] numbers = {5,1,4,3,7,4,8,9,1,4,6,4,7,6,9,5,3,6,8,4,6,9};

        //Map<Integer, Integer> uniqueCount = new MapList<>();
        Map<Integer, Integer> uniqueCount = new MapBST<>();

        for(int num : numbers) {
            if(uniqueCount.containsKey(num)) {
                int curCount = uniqueCount.get(num);
                uniqueCount.put(num, curCount + 1);
            } else {
                uniqueCount.put(num, 1);
            }
        }

        System.out.println(uniqueCount);

        //TODO: 1. show only unique numbers
        System.out.println("Unique Numbers: " + uniqueCount.keys());
        /*for(int num : )
        {
            if(uniqueCount.get(num) == 1)
                System.out.println(num);
        }*/
        //TODO: 2. show only (sorted) unique numbers and how many times they occur
        List<Integer> list = new ArrayList<>(uniqueCount.keys());
        Collections.sort(list);

        System.out.println("Unique Numbers and Times they occur");
        for(int num : list)
        {
            System.out.println(num + ": " + uniqueCount.get(num));
        }

        //Remoção de mapeamentos
        System.out.println(uniqueCount);
        uniqueCount.remove(7);
        System.out.println(uniqueCount);
        uniqueCount.remove(5);
        System.out.println(uniqueCount);
     }
}
