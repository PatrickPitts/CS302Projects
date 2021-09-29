package org.nerdcore;
import org.nerdcore.project1.package1.BinaryTree;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    public BinarySearchTree(T data) {
        super(data);
    }

    public BinarySearchTree(T[] data) {
        this(data[0]);

    }

    public void append(T datum){
        if(datum == this.getData()){
            System.out.println("Duplicate element found");
        } else {
            if(datum.compareTo(this.getData())>0){
                return;
            }
        }

    }
}