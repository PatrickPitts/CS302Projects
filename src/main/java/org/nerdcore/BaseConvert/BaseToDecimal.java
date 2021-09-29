package org.nerdcore.BaseConvert;

import java.util.Scanner;

public class BaseToDecimal {
    static Scanner key = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("Input a base from 2 to 9, or 0 to exit:");
            String in = key.next();
            try{
                int base = Integer.parseInt(in);
                if(base == 0){
                    System.out.println("Goodbye");
                    break;
                }
                else if(base>9||base<2){
                    System.out.println("Invalid input: bad base value");
                } else {
                    System.out.printf("Enter a base %d number:%n", base);
                    String num = key.next();
                    int ret = 0;
                    for(char n : num.toCharArray()){
                        int digit = n - '0';
                        ret *= base;
                        ret += digit;
                    }
                    System.out.printf("The equivalent number in base 10 is %d", ret);
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input: Not a number");
            }
        }
    }
}
