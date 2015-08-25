
package hw8;
/**
 * @ Zac Taylor
 * @ date 8/10/15
 * @author McCauley developed shell and test driver, left findMinAndMax method to be completed
 * 
 * Implementation of Weiss 7.40, shell provided to students
 * 
 * Collaboration - you may speak to Courtney or Dr. McCauley only
 *     You may use no resources other than the text and Java documentation
 *     It is not OK to find and use or base your solution on any that might be found online.
 *  How I completed this assignment: (mention all people you spoke to or resources you used)
 *     FILL IN INFORMATION HERE
 *
 *  What works and what doesn't:
 *   Got everything working properly
 */
public class HW8 {

   
    /**
     * findMinAndMax returns an object containing both values
     * This is the public method - it calls a private recursive method
     * @param a an array of Comparable values
     */   
    public static <AnyType extends Comparable<? super AnyType>>
        MinMax<AnyType> findMinAndMax(AnyType [] a)
        {
            return findMinAndMax(a, 0, a.length-1);
        }
    
    /**
     * findMinAndMax algorithm to find both the minimum and maximum of an 
     *   array, using "divide-and-conquer" algorithm described in Weiss problem 7.40. 
     * This is a private recursive algorithm
     * @param <AnyType> works on any Comparable type
     * @param a array of values from which minimum and maximum are to be found
     * @param left  index of left-most value in current "array" being processed
     * @param right index of right-most value in current "array" being processed
     * @return a MinMax object containing the minimum and maximum values in a
     */  
    private static <AnyType extends Comparable<? super AnyType>>
        MinMax<AnyType> findMinAndMax(AnyType [] a, int left, int right)   {
       
    	AnyType[] array = a;
        int midpoint = 0;    
        
       	 //if no items are returned results are null
        	   if(right - left  < 0)
        		   return null; 

        //if one item is returned, that item is both min and max
        	   if(right - left  == 0){        		   
        		   return new MinMax<AnyType>(array[0], array[0]);
        	   }  
        	   
       //if two items are returned, compare, one is min and one is max
        	   if(right - left == 1){
	   
        		   int x = array[left].compareTo(array[right]); 
        		   if(x <= 0)						// if the left number is less than the right
        		   	   return new MinMax<AnyType>(array[left] , array[right]);
        		    
        		   else						// if the right number is less than the left 
        			   return new MinMax<AnyType>(array[right] , array[left]);	   
        	   }          	   
        // else split array into two halves and recursively find min/max of each half
    		            	           	   
    			   midpoint = (left + right) / 2;		   
    			   MinMax<AnyType> leftSide = findMinAndMax(array, left , midpoint); 			
    			   MinMax<AnyType> rightSide = findMinAndMax(array, midpoint + 1, right);
		    			   
    	// then with additional comparisons produce min/max of whole array   
    			   MinMax<AnyType> minMax = new MinMax<AnyType>();
    			   
    			   if (leftSide.getMin().compareTo( rightSide.getMin() ) <= 0  ) 	//if left sided min < right side
    				   minMax.setMin(leftSide.getMin() );							// set minimum to left side min
    			   else
    				   minMax.setMin(rightSide.getMin() );
    			   
    			   if (leftSide.getMax().compareTo( rightSide.getMax() ) >= 0  )	// if left sided max > right side
    				   minMax.setMax(leftSide.getMax() );							// set max to left side Max
    			   else
    				   minMax.setMax(rightSide.getMax() );
    			   return minMax; 	      	
    } 			
        	   	  
           
    /**
     * Test program provided for you 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] sizesToTry = {0, 1, 2, 7, 16, 32}; 		//original sizes 0, 1,2,7,16,32
        for (int i = 0; i < sizesToTry.length; i++){
            Integer[] arrayToTest = new Integer[sizesToTry[i]];
            System.out.println("Testing array of size: "+ sizesToTry[i]); // added sizesToTry[i] instead of just i to get proper output
            for (int index = 0; index < arrayToTest.length; index++){
                // put some random numbers in the array and print out
                arrayToTest[index] = (int)(Math.random()*100+1);
                System.out.println("element ["+index+"]="+arrayToTest[index]);
            }
            System.out.println("Results: "+ findMinAndMax(arrayToTest));   
            System.out.println("--------------\n");
        }

    }
    
}
