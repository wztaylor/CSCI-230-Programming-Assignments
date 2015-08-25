/* 
@author Zac Taylor
@date 7/22/15
Array processing recursive algorithms (Homework 2)
References: Used stackOverflow to help me get started (used with Sum method). 
After seeing the pattern the rest of the methods came fairly easily.
*/


public class ArrayProcessing {


	/*
	 * This method compares integers from the array in order and takes the largest one from the comparison, 
	 * repeating the process until it reaches the end of the array
	 @param Array A and the length of the array, n
	 @return MaxEle (Maximum element in array)
	 */
	static int MaxEle(int[] A, int n){
		if (n > 0)
			return Math.max(A[n], MaxEle(A,n-1));
		else
		return A[0]; //base case
	}
	
	/*
	 * This method compares integers from the array in order and takes the smallest one from the comparison, 
	 * repeating the process until it reaches the end of the array
	 @param Array A and the length of the array, n
	 @return MinEle  (minimum element in array)
	 */
	static int MinEle(int[] A, int n){
		if (n > 0)
			return Math.min(A[n], MinEle(A, n - 1));
		else 
			return A[0]; //base case
	}
	
	
	/*
	 * This method adds each consecutive integer from the array in order and totals them up, 
	 * repeating the process until it reaches the end of the array
	 @param Array A and the length of the array, n
	 @return Sum (total of all elements in array)
	 */
	static int Sum(int[] A, int n){
		if (n == 0)
			return A[n]; //base case
		else
			return A[n] + Sum( A, n-1);
	}
	

	/*
	 * This method multiplies integers from the array in order and totals them up, 
	 * repeating the process until it reaches the end of the array
	 @param Array A and the length of the array, n
	 @return Prod (total product of all elements in array)
	 */
	static int Prod(int[] A, int n){
		if (n == 0)
			return A[n];   //base case
		else 
			return  A[n] * Prod(A, n-1);
	}
	
	/*
	 * This method adds each consecutive integer from the array in order and totals them up, 
	 * repeating the process until it reaches the end of the array. 
	 * After that it divides the Sum by the total number of elements to give the average
	 @param Array A and the length of the array, n
	 @return Sum (total of all elements in array)
	 */
	static double Avg(int[] A, int n){
		if (n == 0)
			return ((double)(A[n])) / (n+1) ;     //base case
		else
			return ((double)(A[n] + Sum( A, n-1))) / (n+1) ;
	}
	
	
	
	/*
	 * Main method that checks to make sure all the methods run properly. Then produces output for user.
	 */
	public static void main(String[] args){
	int MaxEle = 0;
	int MinEle = 0;
	int Sum = 0;
	int Prod = 0;
	double Avg = 0;
	int SIZE = 10;
	int A[] = new int[SIZE];
	int n = A.length;
	
	System.out.println("The contents of the array are: ");
	System.out.println();
    for (int i =0; i < SIZE; i++)
    	{
        A[i] = i+1; //For testing non zero values
        //A[i] = i; //For testing 0 values
        System.out.println(A[i]);
    	}
	
    
    
	Sum = Sum(A, n-1);
	Prod = Prod(A, n-1);
	Avg = Avg(A, n-1);
	MaxEle = MaxEle(A, n-1);
	MinEle = MinEle(A, n-1);
	
	
	System.out.println();
	System.out.println("The maximum element in the array is: " + MaxEle);
	System.out.println("The minimum element in the array is: " + MinEle);
	System.out.println("The sum of the array is: " + Sum);
	System.out.println("The product of the array is: " + Prod);
	System.out.println("The average of the array is: " + Avg);


	}
}
