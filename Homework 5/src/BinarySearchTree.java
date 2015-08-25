
/**
 * Homework 5 Binary Tree Traversals
 * @author Weiss modified by Zac Taylor (added printTreePre, printTreePost, printTreeLevel and mainDisplay methods)
 * @date 7/31/15
 * 
 * Found a great resource explaining BST's and how to traverse the trees with diagrams,
 * really helped me visualize what was going on and how to know where I was in the tree.
 * http://www.javabeat.net/binary-search-tree-traversal-java/
 * 
 */
// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    
       // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }

    /** The tree root. */
    private  BinaryNode<AnyType> root;


    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     * @throws UnderflowException 
     */
    public AnyType findMin( ) throws UnderflowException
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     * @throws UnderflowException 
     */
    public AnyType findMax( ) throws UnderflowException 
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order. (In order traversal)
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }
    
    
    
    /**
     * Internal method to use preorder traversal on a tree and display output.
     * In this method the value at the node is printed first then the value at the 
     * left subtree is visited, then the right. This is applied recursively until left and right subtrees are null
     * (Works from top of tree down leftmost branch then works its way back up)
     * @param t
     */
    private void printTreePre( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            System.out.println( t.element );
            printTreePre( t.left );
            printTreePre( t.right );
        }
    }
    
    
    /**
     * Internal method to print a tree in post order an display output.
     * Here you traverse the left subtree and then the right then print the value at the node. 
     * (Work from bottom of the tree to the top) 
     * @param t
     */
    private void printTreePost(BinaryNode<AnyType> t)
    {
    	if (t != null)
    	{	
    		printTreePost(t.left);
    		printTreePost(t.right);
    		System.out.println(t.element);
    	}  	
    }
    
    
    /**
     * Internal method to print a tree in level order 
     * (Print first level values, then second level values etc)
     * @param t
     */
    private void printTreeLevel(BinaryNode<AnyType> t)
    {    		
    	//create queue
    	DoublyLinkedQueue<BinaryNode> theQueue = new DoublyLinkedQueue();
    	if(t != null)
    	{
    		//enqueue root node
    		theQueue.enqueue(root);    		
    		//while queue not empty
    		while(!theQueue.isEmpty()){
    			//dequeue a node and set current to the value returned
    			BinaryNode current = theQueue.dequeue();
    			//output current node's value
    			System.out.println(current.element);
    			// if nodes left child is not empty -> enqueue node that is left child
    			if(current.left != null)
    				theQueue.enqueue(current.left);
    			// if nodes right child is not empty -> enqueue node that is right child
    			if(current.right != null)
    				theQueue.enqueue(current.right);
    		}
    	}
    }
 

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
   
    
    
    /*********************************For Test 2 Practice**************************************/
    

    private int leafNodeCount(BinaryNode<AnyType> t){
    	
    	if(t == null)
    		return 0;
    	else if(t.left ==null && t.right == null)
    		return 1;
    	else
    		return leafNodeCount(t.left) + leafNodeCount(t.right);
    }
      
    
   private int nodeCount(BinaryNode<AnyType> t){
	   if (t == null)
		   return 0;
	   else
		   return 1 + nodeCount(t.left) + nodeCount(t.right);
   } 
    

    private int twoChildNodeCount(BinaryNode<AnyType> t){
    	
    	if(t == null)
    		return 0;
    	else if (t.left != null && t.right != null)
    		return 1;
    	else 
    		return twoChildNodeCount(t.left) + twoChildNodeCount(t.right);
    }
    
    private int leftChildCount(BinaryNode<AnyType> t){
    	if(t == null)
    		return 0;
    	else if(t.left != null)
    		return 1;
    	return leftChildCount(t.left) + leftChildCount(t.right);
    }
        
    /************************* End of test 2 Code*****************************************
    
    
    
    /**
     * Display method for trees and main method to cut down on repeated code.
     * @param t
     */
    public static void display(BinarySearchTree<Integer> t)
    {
        System.out.println("The tree printed IN order: ");
        t.printTree(t.root);
        System.out.println();
        System.out.println("The tree printed in PRE order: " );
        t.printTreePre(t.root);
        System.out.println();
        System.out.println("The tree printed in POST order: ");
        t.printTreePost(t.root);
        System.out.println();
        System.out.println("The tree printed in Level order: ");
        t.printTreeLevel(t.root);
        System.out.println();
    }
    
    
    /**
     * Main method used for testing purposes. Chose three trees to use, one zero, one large and one small tree
     * @param args
     */
    public static void main( String [ ] args )
    {        
        //Tree Creation
        BinarySearchTree<Integer> zeroTree = new BinarySearchTree<>();
        
        BinarySearchTree<Integer> largeTree = new BinarySearchTree<>();
        largeTree.insert(500);
        largeTree.insert(700);
        largeTree.insert(800);
        largeTree.insert(200);
        largeTree.insert(300);
        largeTree.insert(505);
        largeTree.insert(280);
        largeTree.insert(920);
        largeTree.insert(570);
        largeTree.insert(330);
        largeTree.insert(970);
        largeTree.insert(520);
        largeTree.insert(120);
        
        BinarySearchTree<Integer> smallTree = new BinarySearchTree<>();
        smallTree.insert(8);
        smallTree.insert(4);
        smallTree.insert(1);
        smallTree.insert(6);
        smallTree.insert(12);
        smallTree.insert(15);
        smallTree.insert(14);
        
        //Display
    
/*        System.out.println("Display for the large tree: " + "\n");
        display(largeTree);
        System.out.println();*/
        
        System.out.println("Display for the small tree: " + "\n");
        display(smallTree);
        System.out.println();
        
        
        
        
        //test code for node counts

       int w = smallTree.nodeCount(smallTree.root);
       System.out.println(w); 
       
       int y = smallTree.leafNodeCount(smallTree.root);
       System.out.println(y); 
         
       int z = smallTree.twoChildNodeCount(smallTree.root);
       System.out.println(z); 
                
       int t = smallTree.leftChildCount(smallTree.root);
       System.out.println(t); 

 
       
/*        System.out.println("Display for the zero tree: " + "\n");
        display(zeroTree);
        System.out.println();*/
           
    }
           
}
