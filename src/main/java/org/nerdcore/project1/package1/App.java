package org.nerdcore.project1.package1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/*
 * Project: Project 1
 * Completion Time: 2 Hours
 *
 * Honor Code: "I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components here."
 *
 * */
public class App {

    /**
     * Takes in a variable length array of Strings to represent the nodes of a BinaryTree. Accepts either integer values
     * or "null". If no paramters are given, a default array of pre-parsed integers and "null"s is used for this
     * exercise instead.
     * @param args - list of nodes to be included in the creation of a BinaryTree.
     */
    public static void main(String[] args) {
        Integer[] nums;
        if (args.length > 0) {
            nums = new Integer[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("null")) {
                    nums[i] = null;
                } else {
                    try{

                        nums[i] = Integer.parseInt(args[i]);
                    } catch(NumberFormatException n){
                        System.out.println(args[i] + " is not a valid input type. Must be either an Integer or \"null\".");
                        return;
                    }
                }
            }
        } else {
            nums = new Integer[]{1, 2, 3, null, null, 4, 5, null, null, null, null, 6, 7, null, 8};
        }

        System.out.printf("Input array: %s%n", Arrays.toString(nums));
        System.out.printf("Creating BinaryTree<Integer> from input array:%n");
        BinaryTree<Integer> newTree = null, BT = new BinaryTree<>(nums);

        System.out.println("Attempting to serialize BinaryTree to file \"foobar.ser\"");
        try (FileOutputStream fileOut = new FileOutputStream("foobar.ser")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(BT);
            out.close();
            System.out.println("Success: BinaryTree written to file \"foobar.ser\"");
        } catch (Exception ignored) {
            System.out.println("Couldn't find desired file destination.");
        }
        System.out.println("Attempting to read BinaryTree from file \"foobar.ser\"");
        try (FileInputStream fileIn = new FileInputStream("foobar.ser")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileIn);
            newTree = (BinaryTree<Integer>) objectInputStream.readObject();
            System.out.println("Success: BinaryTree read from \"foobar.ser\"");
            System.out.println("Printing BinaryTree traversals");
            newTree.preOrder();
            newTree.inOrder();
            newTree.postOrder();
        } catch (Exception ignored) {
            System.out.println("Couldn't find desired file destination.");
        }
    }
}

