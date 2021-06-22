
public class Node <E>{

    //generic type of item so that the class can be used for multiple 
    // type items
    E key;
    int height;
    Node<E> left, right;
 
    public Node(E item)
    {   
        height = 1;
        key = item;
        left = right = null;
    }
    
}