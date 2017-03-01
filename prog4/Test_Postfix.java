/* Blake Impecoven - CSCD300 - 4/27/2015

*/

import java.util.*;
import java.io.*;

public class Test_Postfix
{
   public static void main(String[] args) throws FileNotFoundException
   {
      File inputFile = new File(args[0]);
      LinkedList stack = new LinkedList();
      System.out.println("Postfix Expression value: " + runStack(inputFile, stack));
   }//end main
   
   public static int runStack(final File inputFile, final LinkedList stack) throws FileNotFoundException
   {
      try{   
         Scanner fileReader = new Scanner(inputFile);
         int num1, num2, sum = 0;
         String operator = null;
         
         while(fileReader.hasNext())
         {
            if(fileReader.hasNextInt())//is the next line an int?
            {
               stack.push(fileReader.nextInt());
            }//end if
            else//operator
            {
               num1 = stack.pop();
               num2 = stack.pop();
               fileReader.nextLine();
               operator = fileReader.next();
               
               if(operator.equals("+"))
               {
                  sum = num2 + num1;
                  stack.push(sum);
               }
               
               else if(operator.equals("-"))
               {
                  sum = num2 - num1;
                  stack.push(sum);
               }
               
               else if(operator.equals("*"))
               {
                  sum = num2 * num1;
                  stack.push(sum);
               }
               
               else if(operator.equals("/"))
               {
                  sum = num2 / num1;
                  stack.push(sum);
               }
            }//end else
         }//end while
         return sum;
      }//end try   
      catch(FileNotFoundException e)
      {
         System.out.println("Cannot find file.");
         return -1;
      }//end catch   
   }//end readFile
}//end class