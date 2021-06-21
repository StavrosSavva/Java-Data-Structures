
public class Node <E>{

    //generic type of item so that the class can be used for multiple 
    // type items
    E key;
    Node<E> left, right;
 
    public Node(E item)
    {
        key = item;
        left = right = null;
    }
    
}