package org.nerdcore.BaseConvert;

public class Driver {
    public static void main(String[] args) {
        System.out.println(average(2,4));
        System.out.println(average(2,4,6));
        System.out.println(average(2.0, 4, ""));
    }

    public static int average(int a, int b){
        System.out.println("Two ints");
        return (a + b)/ 2;
    }

    public static int average(int a, int b, int c){
        System.out.println("Three ints");

        return(a + b + c)/3;
    }

    public static double average(double a, double b, String flag){
        System.out.println("Two doubles");
        return (a + b) / 2.;
    }

}
