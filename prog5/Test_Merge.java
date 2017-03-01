/* Blake Impecoven - CSCD300 - 5/2/2015

*/

import java.io.*;
import java.util.*;

public class Test_Merge
{
   public static void main(String[]args) throws FileNotFoundException
   {
      File[]files = new File[args.length]; //initialize file array
      Scanner[]fileReaders = new Scanner[args.length]; //initialize scanner array
      ListQueue sorted = new ListQueue(); //initialize ListQueue
      ArrayQueue[] queues = new ArrayQueue[args.length]; //initialize ArrayQueue
      boolean isEmpty = true;
      
      for(int i = 0; i < args.length; i++) //open files and assign to scanner
      {
         files[i] = new File(args[i]); //assign the file to array
         fileReaders[i] = new Scanner(files[i]); //assign the file to same location in scanner array
      }//end for i
      
      //create array queues
      for(int j = 0; j < queues.length; j++)
      {
         queues[j] = new ArrayQueue(10); //set queue capacity at 10
      }//end for j
      
      //fill array queues
      for(int rows = 0; rows < queues.length; rows++)
      {
         while(fileReaders[rows].hasNextInt())
            queues[rows].enqueue(fileReaders[rows].nextInt());
      }
      
      do{
         for(int num = 0; num < queues.length; num++)
         {
            isEmpty = queues[num].isEmpty();
            if(isEmpty == false)
               operation(queues, sorted);   
         }   
      }while(isEmpty == false);
      
      while(!(sorted.isEmpty()))
      {
         System.out.println(sorted.dequeue());
      }   
   }//end main
   
   public static void operation(final ArrayQueue[] queues, final ListQueue sorted)
   {
      int low = 1000000; // had to hardcode a large value to avoid getting a bad return case
      int lowIndex = 0;
      for(int rows = 0; rows < queues.length; rows++)
      {  
         if(queues[rows].isEmpty() == false)
         {
            if(queues[rows].front() <= low)
            {
               low = queues[rows].front();
               lowIndex = rows;
            }
         }   
      }//end for rows
      sorted.enqueue(queues[lowIndex].dequeue()); //dequeue smalled of the files and enqueues to sorted
   }//end operation
}//end class