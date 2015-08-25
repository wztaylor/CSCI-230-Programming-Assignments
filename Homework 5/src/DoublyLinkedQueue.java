


/**  
 * Using queue from Homework 4 for Binary Search Tree
 * @author Renee McCauley with updates from Zac Taylor
 * @date 7/31/15
 * @param <AnyType>
 * 
 * Implementation of a queue ADT using a doubly-linked 
 * list physical data structure.
 * 
 * Queue methods supported include:
 *   doClear - empties the queue reseting all values (size, front and end pointers)
 *   makeEmpty - resets queue to empty
 *   enqueue - insert/add an element to the end (back) of the queue
 *   dequeue - remove an element from the front of the queue
 * 

 */
public class DoublyLinkedQueue<AnyType> 
{
    /**
     * This is the doubly-linked list node.
     */
    private static class Node<AnyType>
    {
        public Node( AnyType d, Node<AnyType> p, Node<AnyType> n )
        {
            data = d; prev = p; next = n;
        }
        
        public AnyType data;
        public Node<AnyType>   prev;
        public Node<AnyType>   next;
                
        /**
         * Displays node (had issues with getting toString to work)
         */
        public void displayNode(){
            System.out.print(data + " ");
        }

        }
    
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> front;
    private Node<AnyType> end;

    /**
     * Construct an empty LinkedList.
     */
    public DoublyLinkedQueue( )
    {
        makeEmpty( );
    }

    /**
     * Change the size of this collection to zero, 
     * (re)set list pointers to be null.
     */
    public void makeEmpty( )
    {
        front = null;
        end = null;
    }

    /**
     * if front is null, end should be as well
     * @return 
     */
    public boolean isEmpty( )
    {
        return front == null;
    }
    
    /**
     * enqueue element - add to back of list
     * Special case to handle, the queue is empty, so both
     * front and end must be updated. Otherwise,only the end
     * changes.
     */ 
    public void enqueue(AnyType x)
    {       
    	// make a new node containing x
    	Node<AnyType> newNode = new Node<AnyType>(x, front, end) ;
    	
    	// check if queue empty, if so reset front and end
    	if (isEmpty())
    	{	
    		front = newNode;
    		end = newNode;
    	}
    	
    	// if queue not empty, put new node at back
    	else 
    	{
    		end.next = newNode;	
      	}
    	
    	//End node is now the newNode being queued and end.next is reset to null because end is now the last item in queue
    	end = newNode;
    	end.next = null;
    }

    /**
     * Removes the node at the front of the list and returns
     * its data value.
     * Special case, the node is the last element in the list, so 
     * both front and end will change as a result.
     * @return the item was removed from the collection.
     * @precondition queue not empty - caller must check this
     */
    public AnyType dequeue()
    {
    	//create a new node referencing the front of the queue
    	Node<AnyType> current = front;
    	
    	//if front is null there is nothing to dequeue (precondition)
    	if (front == null)
    		return null;
    	
    	//if this is the last node in the list, the next front node will be null as will the end node
    	if(front.next == null)
    		end = null;
    	
    	//if neither of the two previous conditions are met, the front node is cycled
    	//to the next node in the list and the current value of front is returned
    	front = front.next;
        return current.data;
    }
    

    /**
     * Displays a String representation of this node collection.
     * Tried to get toString to work for display but had issues. Found below about display that helped out
     * by creating a displayNode method which I modified to fit criteria.
     *  http://codereview.stackexchange.com/questions/63171/implementation-of-a-doubly-linked-list-in-java
     */
    public void display( )
    {
        System.out.println("Queue contains:");
        
        //if node isn't empty and while there are nodes in the list, display the nodes in order
        if (!isEmpty())
        {
        	Node<AnyType> current = front;
        	while(current != null)
        	{
        		current.displayNode();
        		current = current.next;
        	}
        	System.out.println("");
        }	
        	
        else
            System.out.println("Queue Empty!");
       
    }
    

/**
 * Main method used for testing DoublyLinkedQueue
 * @param args
 */
    public static void main(String [] args){

    	// add code to instantiate and queue and test
    	// it by enqueing and dequeuing values and
        // displaying contents
    	
    	DoublyLinkedQueue theQueue = new DoublyLinkedQueue();
    	theQueue.enqueue("Zac");
    	theQueue.enqueue('Z');
    	theQueue.enqueue("Ashley");
    	theQueue.enqueue("Dylan");
    	theQueue.enqueue("122");
    	theQueue.enqueue(5);
    	
    	theQueue.dequeue();
    	theQueue.dequeue();
    	theQueue.dequeue();
    	
    	
    	//testing to make sure queue says its empty 
/*    	theQueue.dequeue();
    	theQueue.dequeue();
    	theQueue.dequeue();*/
    	
    	theQueue.display();
    	
        
        
    }
}
