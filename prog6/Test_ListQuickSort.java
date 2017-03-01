/* Blake Impecoven - CSCD300 - 5/12/2015

*/

import java.util.*;
import java.io.*;

public class Test_ListQuickSort
{
   public static void main(String[]args) throws FileNotFoundException
   {
      File data = new File(args[0]);
      Scanner fileReader = new Scanner(data);
      DoublyLinkedList myList = new DoublyLinkedList();
      
      fillList(myList, fileReader);
      System.out.println("Unsorted List: " + myList);
      quickSort(myList, 0, myList.size());
      System.out.println("Sorted List: " + myList);
   }//end main
   
   public static void fillList(final DoublyLinkedList myList, final Scanner fileReader)
   {
      if(fileReader == null)
         throw new RuntimeException("Precondition not met.");
      int temp = -1;
      while(fileReader.hasNextInt())
      {
         temp = fileReader.nextInt(); //store next int in file into temp variable
         myList.addAfter(temp); //put the temp int into the list
      }//end while   
   }//end fillList
   
   public static void quickSort(final DoublyLinkedList myList, final int left, final int right)
   {
      if(left >= right)
         return;
         
      int pivotIndex = partition(myList, left, right);
      quickSort(myList, left, pivotIndex - 1);
      quickSort(myList, pivotIndex + 1, right);      
   }//end quickSort
   
   public static int partition(final DoublyLinkedList myList, final int left, final int right)
   {
      int index = left;//index value
      int pivot = myList.getItem(right);//data value
      
      for(int x = left; x < right; x++)
      {
         if(x + 1 == right)
            swap(myList, index, right);
         else if(myList.getItem(x) <= pivot)
         {
            swap(myList, index, x);
            index++;
         }//end if   
      }//end for
      //swap(myList, index, right);
      return index;
   }//end partition //for use with quicksort method
   
   public static void swap(final DoublyLinkedList myList, final int pos1, final int pos2)
   {
      int item1 = myList.getItem(pos1), item2 = myList.getItem(pos2);
      myList.setItem(pos1, item2);
      myList.setItem(pos2, item1);
   }//end swap //for use with partition method
}//end class