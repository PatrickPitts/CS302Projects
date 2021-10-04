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

//Utility class that converts a base 2-9 number to base 10
//Gets a base and a number to convert from that base,
//Starting with the left-most digit, the algorithm takes the resulting base-10 value and
//shifts it up one place in the provided base by multiplying by the provided base number, then
//appends the current digit to the converted value.
public class BaseToDecimal {
    static Scanner key = new Scanner(System.in);
    public static void main(String[] args){
        //Driver loop
        while(true){
            System.out.println("Input a base from 2 to 9, or 0 to exit:");
            String in = key.next();
            //Attempts to get integer values from the user. If any input
            //is not an integer, this try/catch will catch the inevitable
            //NumberFormatException
            try{
                int base = Integer.parseInt(in);
                if(base == 0){
                    System.out.println("Goodbye");
                    break;
                }
                //verifies the provided base is valid
                else if(base>9||base<2){
                    System.out.println("Invalid input: bad base value");
                } else {
                    System.out.printf("Enter a base %d number:%n", base);
                    String num = key.next();
                    //instantiates the
                    int ret = 0;
                    //extracts the digits from the provided number as characters, starting with the
                    //largest digit and working down to lower values
                    for(char n : num.toCharArray()){
                        //gets the integer value of the character digit
                        int digit = n - '0';
                        //updates the return base-10 value by multiplying by the given base then
                        //adding the new digit
                        ret = ret * base + digit;
                    }
                    //reports the converted number
                    System.out.printf("The equivalent number in base 10 is %d", ret);
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input: Not a number");
            }
        }
    }
}
