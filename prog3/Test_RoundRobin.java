/* Blake Impecoven - CSCD300 - prog3 - 4/14/2015

*/

import java.util.*;
import java.io.*;

public class Test_RoundRobin
{
   public static void main(String[]args)throws FileNotFoundException
   {
      File inputFile = new File(args[0]);
      int serviceLength = Integer.parseInt(args[1]);
      CircularlyLinkedList roundRobin = new CircularlyLinkedList();
      fillList(inputFile, roundRobin);
      
      runService(roundRobin, serviceLength);

   }//end main
   
   public static void fillList(final File inputFile, final CircularlyLinkedList myList) throws FileNotFoundException
   {
      Scanner fileInput = new Scanner(inputFile);
      int id, time;
      String temp;
      while(fileInput.hasNext())
      {  
         temp = fileInput.nextLine();
         String[]values = temp.split(",");
         id = Integer.parseInt(values[0]);
         time = Integer.parseInt(values[1]);
         myList.addOrdered(id, time);
      }//end while
   }//end fillList
   
   /*
   public static void runService(final CircularlyLinkedList myList, final int serviceLength)
   {
      for(int x = 1; x < myList.size(); x++)
      {
         myList.setValues(x, serviceLength);
         
      }//end for
   }//end runService
   */
   public static void runService(final CircularlyLinkedList myList, final int serviceLength)
   {
      myList.service(serviceLength);
   }
   
}//end class