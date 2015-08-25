/**
 * @author Zac Taylor
 * @version 1.0 
 * @date 7/24/15
 * Homework 3 Solving problems with Stacks
 */
public class Balancer 
{
	
/**
 * 
 * @param String equation
 * @return true if equation is balanced
 * @return false if equation isn't balanced
 */
	public static boolean isItBalanced(String equation)
	{
		
    LinkedStack<String> equationCheck = new LinkedStack<>();

    
    //loop through entire String "equation" by character and determine if it is "(" or ")"
    for (int i = 0; i < equation.length(); i++)
    {
    	char symbol = equation.charAt(i);
    	String element = Character.toString(symbol); 

		if (element.equals("(") )
    		//push to stack
			equationCheck.push(element);    	
		
	
		else if (element.equals(")"))
		{		
			//if the stack is empty, return false
			if (equationCheck.isEmpty())
				return false;
			
			//if the popped element is not a corresponding "("  then return false
			String popChar = equationCheck.pop();
			if(!popChar.equals( "("))
				return false;
			
		}    	
    } //end of for loop
    
    
    //after the loop has completed if the stack is empty return true 
    if (equationCheck.isEmpty())
		return true;
    else 
    	return false;
    
    }
    	
	/**
	 * Main method for testing purposes
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		boolean x;
	
		x = isItBalanced("4+8");
		System.out.println(x);
		
		x = isItBalanced("(4+8");
		System.out.println(x);
		
		x = isItBalanced("(4+8)");
		System.out.println(x);
		
		x = isItBalanced("(((4+8)");
		System.out.println(x);
		
		x = isItBalanced("(4+8)))))");
		System.out.println(x);
		
	}//end of main 

} //end of class Balancer
