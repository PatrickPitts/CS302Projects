/*
 * Author: John Patrick Pitts
 * SID: 24435084
 *
 * Honor Code: "I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components here."
 *
 * */
package org.nerdcore.BaseConvert;

import java.util.Scanner;

//A utility class that prompts the user to input a base 10 number,
//which is then converted to base 2, 8, 16.
//The provided number is repeatedly divided by the new number base, extracting the remainder each
//time. That remainder becomes the next digit in the converted number, repeated until the division
//results in 0. This process is repeated for base 2, 8, and 16
public class DecimalToBase {
    static Scanner key = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {

            System.out.println("Enter a base 10 number, or 0 to exit:");
            //Attempts to get an integer value from the user. If any input
            //is not an integer, this try/catch will catch the inevitable
            //NumberFormatException
            try {
                int num = Integer.parseInt(key.next());
                //Allows the user to manually end the driving while loop early
                if (num <= 0) {
                    System.out.println("Goodbye.");
                } else {
                    //The bases that the input will be converted to
                    int[] bases = {2, 8, 16};
                    //Stores the strings representing the base conversions
                    String[] convertedNumberStrings = new String[bases.length];
                    //Reference string whose characters represent the new digit in the converted number
                    String hex = "0123456789ABCDEF";
                    //Iterates through all bases
                    for (int i = 0; i < bases.length; i++) {
                        convertedNumberStrings[i] = "";
                        int base = bases[i];
                        //Stores a new version of the original number to be converted
                        int N = num;
                        //Repeatedly takes the modulus of the original number, extracting the remainder, and
                        //dividing down to the next conversion base digit
                        while (N > 0) {
                            convertedNumberStrings[i] = hex.charAt(N % base) + convertedNumberStrings[i];
                            N /= base;
                        }
                        //Prints the current converted number
                        System.out.printf("You number in base %d: %s%n", base, convertedNumberStrings[i]);
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Not a number");
            }
        }
    }
}
