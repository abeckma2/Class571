import java.util.*;

/**
 * Allan Beckman
 * E01238245
 * COSC 311
 * Fall 2018
 * Program 2
 * sort method
 */
public class Insertion
{
    // instance variables - replace the example below with your own
    private int n;
    int array[];

    public int[] Insert(int array[])
    {
        int placeHolder;
        for(int i=1;i<n;i++)
        {
            placeHolder=array[i];
            int k = i;
            while(k>0 && array[k-1]>=placeHolder)
            {
                array[k] = array[k-1];
                --k;
            }
            array[k] = placeHolder;
        }
        return array;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int input;
        Insertion insertion = new Insertion();
        System.out.println("Insert n: the size of the array");//determine size of array
        input = keyboard.nextInt();
        insertion.array = new int[input];
        insertion.n=input;
        for(int i=0;i<insertion.n;i++)//fill up array
        {
            System.out.println("insert #");
            input = keyboard.nextInt();
            insertion.array[i] = input;
        }
        insertion.Insert(insertion.array);
        for(int i=0;i<insertion.n;i++)//print out array to ensure insertionsort works
        {
            System.out.print(insertion.array[i] + " ");
        }
    }
}
