import java.util.*;
public class Tree<E> {

    // Root of Binary Tree
    Node<E> root;
 
    // Constructors
    Tree(E key)
    {
        root = new Node<E>(key);
    }
 
    Tree()
    {
        root = null;
    }
 
    public static void main(String[] args)
    {
        Tree<Integer> tree = new Tree<Integer>();
 
        /*create root*/
        tree.root = new Node<Integer>(1);
        tree.root.left = new Node<Integer>(2);
        tree.root.right = new Node<Integer>(3);
        tree.root.left.left = new Node<Integer>(4);

        //prints the root of the tree
        System.out.println(tree.root);
        
    }


}

