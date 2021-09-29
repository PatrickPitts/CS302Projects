package org.nerdcore.BaseConvert;

import java.util.Scanner;

public class DecimalToBase {
    static Scanner key = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("Enter a base 10 number, or 0 to exit:");
            try{
                int num = Integer.parseInt(key.next());
                if(num <= 0){
                    System.out.println("Goodbye.");
                    break;
                } else {
                    int[] bases = {2,8,16};
                    String[] convertedNumberStrings = new String[bases.length];
                    String hex = "0123456789ABCDEF";
                    for(int i = 0; i < bases.length; i++){
                        convertedNumberStrings[i] = "";
                        int base = bases[i];
                        int N = num;
                        while(N > 0){
                            convertedNumberStrings[i] = hex.charAt(N % base) + convertedNumberStrings[i];
                            N /= base;
                        }
                        System.out.printf("You number in base %d: %s%n",base, convertedNumberStrings[i]);
                    }
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input: Not a number");
            }
        }
    }
}
