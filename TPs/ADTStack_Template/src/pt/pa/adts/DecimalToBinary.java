package pt.pa.adts;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.printf("Insert a number: ");
        int num = new Scanner(System.in).nextInt();
        System.out.println("The decimal number " + num + " is equal " + decimal2Binary(num) + " in binary");
    }

    public static String decimal2Binary(int decimal) {
        int res = 0;
        Stack<Integer> stack = new StackArrayList<>();

        while (decimal > 0){
            res = decimal % 2;
            decimal /= 2;
            stack.push(res);
        }

        StringBuilder converted = new StringBuilder();
        while (!stack.isEmpty()) {
            converted.append(stack.pop());
        }
        return converted.toString();
    }
}
