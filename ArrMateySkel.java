/**
 * Read in an array of numbers and displays information about the numbers 
 * @author      James Connan <j.connan@ru.ac.za>
 * @version     1.0
*/
public class ArrMateySkel
{
    public static int[] makeIntArray(String[] sArray)
    //  Convert an array of trings into an array if integers
    {
        return new int[] {};
    }
    
    public static int[] minMaxSum(int[] nums)
    // finds the smallest and largest elements of an array as well as the sum of the elements
    {
        return new int[] {};
        
    }
 
    public static int[] makeSquares(int[] nums)
    // returns an array containing the squares of the values in the original array
    {
        return new int[] {};
        
    }

    public static int[] diffN(int[] nums)
    // returns the diffrences between consecutive values in the array    
    {
        return new int []{};   
    }

    public static int[] diffSq(int[] nums)
    // returns the absolute differences between the squares of the values in the array
    {
        return new int[]{};   
    }

    public static void displayArray(String s, int[] nums)
    // displays an array of numbers
    {
    }


    public static void main (String[] args)
    {
        int[] numbers;
        int[] mms;
        int[] squares;
        int[] diffO;
        int[] diffSq;

        String output0 = "The original array was: ";
        String output1 = "The squares of each element is: ";
        String output2 = "The diffrences are: ";
        String output3 = "The abs differences of the squares are: ";
        
        numbers = makeIntArray(args);
        mms = minMaxSum(numbers);
        squares = makeSquares(numbers);
        diffO = diffN(numbers);
        diffSq = diffSq(squares);
        
        displayArray(output0, numbers);
        System.out.println("The min value is: " + mms[0]);
        System.out.println("The max value is: " + mms[1]);
        System.out.println("The sum of the values is: " + mms[2]);
        displayArray(output1, squares);
        displayArray(output2, diffO);
        displayArray(output3, diffSq);

    }
}