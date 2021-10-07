package org.nerdcore.project1.package1;
import java.io.FileOutputStream;
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

    public static void main(String[] args) {
        int N = 15;
        Integer[] nums;
        if(args.length > 0) {
            nums = new Integer[args.length];
            for (int i = 0; i < args.length; i++) {
                if(args[i].equals("null")){
                    nums[i] = null;
                } else {
                    nums[i] = Integer.parseInt(args[i]);
                }
            }
        } else {
            nums = new Integer[N];
            for(int i = 0; i < N; i++){
                nums[i] = i;
            }
        }
        BinaryTree<Integer> BT = new BinaryTree<>(nums);

        try (FileOutputStream fileOut = new FileOutputStream("/savedTrees/foobar.ser")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
        } catch(Exception ignored){

        }
        BT.preOrder();
        BT.inOrder();
        BT.postOrder();

        

    }
}

