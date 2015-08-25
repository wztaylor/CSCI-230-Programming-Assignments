/**
 * LinkedStack can contain any type of data, but all data must be of the same type.
 * 
 * Data stored in a singly-linked list with top (head) pointer that references the 
 * top of the list)
 * 
 * @ R McCauley built shell - completed in/with class on July 22
 */
public class LinkedStack<AnyType> {
    
    /******** an inner class  **********************
     * The node type for a linked list OrderedCollection
     */
    private static class Node<AnyType> {
        
        public Node(AnyType x) {
            data = x; next = null;           
        }
        
        public AnyType data;
        public LinkedStack.Node<AnyType> next;
    }
    /**********************************************************/
    
    // The OrderedCollection data - its instance variables
    
    private LinkedStack.Node<AnyType> top; // front marker

    /**
     * Constructor allocates initializes front reference
     * @param size the number of elements stored
     */
    public LinkedStack () {
         
        top = null;  // When list is empty, front is null
    }
    
    /**
     * Traverse the stack and build string of contents
     *  -- this is for verification purposes - is stack working
     *     properly?
     * @return a String representation of the list
     */
    public String toString(){
        LinkedStack.Node walker = top;
        String returnString = "";
        while (walker != null){
            returnString += walker.data + "\n";
            walker = walker.next;
        }  
        return returnString;
    }

    /**
     * isEmpty determines if collection has no elements
     * @return true if collection empty, false otherwise
     */
    public boolean isEmpty(){
        return top == null; // will have to be completed
    }
    
    /**
     * makeEmpty resets the collection to be empty, and sets size to 0
     */ 
    public void makeEmpty(){
        top = null;
    }
    
    /**
      * push new element onto top of stack
      * precondtion: NONE
      */
    public void push(AnyType x){
        Node newNode = new Node<>(x);
        newNode.next = top;
        top = newNode;
        
    }
    
    /**
      * remove top element from stack and return value
      *
      * @return value on top of stack
      * precondition: NONE, stack might be empty
      */
    public AnyType pop(){
        if (top != null){
           AnyType temp = peek();
           top = top.next;
           return temp;
        }
       return null; /// to be corrected later
    }
    
    /**
     * see what's on top of stack without removing it
     *
     * @return value on top of stack
     * precondition: NONE, stack might be empty
     */
    // precondition: NONE
    public AnyType peek(){
        if (top != null)
           return top.data;
        else 
            return null;
    }
       
     
    public static void main(String[] args){
   
        LinkedStack<String> o = new LinkedStack<>();
        System.out.println("The data on top is "+ o.peek());
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        o.push("apple");
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        o.push("cranberry");
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        o.push("truck");
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        System.out.println("The data on top is "+ o.peek());
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        System.out.println("The top el was " + o.pop());
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        System.out.println("The top el was " + o.pop());
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        System.out.println("The top el was " + o.pop());
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
        System.out.println("The top el was " + o.pop());
        System.out.println("The stack contains:");
        System.out.println(o);
        System.out.println("---");
     } 
}// end class LinkedStack
