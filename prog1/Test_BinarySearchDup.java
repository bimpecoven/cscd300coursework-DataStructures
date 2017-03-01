/* Blake Impecoven - CSCD300 - prog1

*/

import java.util.*;
import java.io.*;

public class Test_BinarySearchDup
{
   public static void main(String[]args) throws FileNotFoundException
   {
      File inputFile = new File("data.txt");
      Scanner kb = new Scanner(System.in);
      //Scanner fileInput = new Scanner(inputFile);
      int search = Test_BinarySearchDup.readInt(kb);
      int[]A = Test_BinarySearchDup.readArray(inputFile);
      System.out.println(BinarySearchDup(A, search));
      
   }//end main
   
   public static int readInt(final Scanner kb)
   {
      System.out.print("Enter an integer: ");
      int num = kb.nextInt();
      return num;
   }//end readInt
   
   public static int[] readArray(final File inputFile) throws FileNotFoundException
   {
      Scanner fileInput = new Scanner(inputFile);
      int size = Test_BinarySearchDup.countRecords(inputFile);
      int[]array = new int[size];
      for(int x = 0; x < array.length; x++)
      {
         array[x] = fileInput.nextInt();
      }
      return array;
   }//end readArray
   
   public static int countRecords(final File inputFile)throws FileNotFoundException
   {
      int count = 0;
      Scanner fileInput = new Scanner(inputFile);
      while(fileInput.hasNext())
      {
         fileInput.nextLine();
         count++;
      }//end while
      return count;
   }//end countRecords
   
   public static Pair BinarySearchDup(int[] A, int x)
   {
      int lowIndex = binarySearchLow(A, x, 0, A.length - 1);//initial binary search, always goes low
      int highIndex = binarySearchHigh(A, x, lowIndex, A.length - 1);//set low boundary at found index
      Pair boundary = new Pair(lowIndex, highIndex);
      return boundary;
   }//end BinarySearchDup
   
   private static int binarySearchLow(int[]A, int x, int low, int high)
   {
      while(low <= high)
      {
         int mid = low + ((high - low) / 2);
         if(x < A[mid]) 
            high = mid - 1;  
         else if(x > A[mid]) 
            low = mid + 1;
         else if(x == A[mid] && mid > 0 && A[mid - 1] == x)
            high = mid;   
         else 
            return mid;
      }//end while
      return -1;
   }//end binarySearchLow
   
   private static int binarySearchHigh(int[]A, int x, int low, int high)
   {
      while(low <= high)
      {
         int mid = low + ((high - low) / 2);
         if(x < A[mid]) 
            high = mid - 1; 
         else if(x > A[mid]) 
            low = mid + 1;
         else if(x == A[mid] && mid < A.length - 1 && A[mid] + 1 == x)
            low = mid;   
         else 
            return mid;
      }//end while
      return -1;
   }//end binarySearchHigh
   
}//end class
   