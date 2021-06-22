

class AVLTree<E extends Comparable<E>>{
 
    Node<E> root;
 
    // A utility function to get the height of the tree
    int height(Node<E> N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b) {
        if(a > b){
            return a;
        }else{
            return b;
        }
       
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node<E> rightRotate(Node<E> y) {
        Node<E> x = y.left;
        Node<E> T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node<E> leftRotate(Node<E> x) {
        Node<E> y = x.right;
        Node<E> T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node<E> N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    Node<E> insert(Node<E> node, E key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node<E>(key));
 
        if (key.compareTo(node.key)<0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key)>0)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key.compareTo(node.left.key)<0)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key)>0)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key)>0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key)<0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
 
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
      
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}
