/* Blake Impecoven - CSCD300 - prog7

*/

import java.io.*;
import java.util.*;

public class Test_HashChain
{
   public static void main(String[]args) throws FileNotFoundException
   {
      File inputFile = new File(args[0]);
      Scanner fileReader = new Scanner(inputFile);
      Scanner kb = new Scanner(System.in);
      int lineNumbers = countRecords(fileReader);
      HashChain database = new HashChain(lineNumbers);
      fillRecords(database, fileReader);
      
      int num = 0;
      String name = null;
      
      int choice = menu(kb);
      while(choice != 5)
      {  
         switch(choice)
         {
            case 1:     System.out.println("Enter student ID: ");
                        num = kb.nextInt();
                        System.out.println("Enter students name: "); 
                        name = kb.nextLine(); 
                        Node student = new Node(num, name);
            
            case 2:     System.out.println("Enter student ID: ");
                        num = kb.nextInt();
            
            case 3:     System.out.println("Enter student ID: ");
                        num = kb.nextInt();
                        System.out.println("Enter students name: "); 
                        name = kb.nextLine(); 
            
            case 4:     System.out.print(database);
            
            case 5:     System.out.println("Goodbye.");
                        break;
         }//end switch
      }//end while
   }//end main
   
   public static int countRecords(final Scanner fileReader)
   {
      int num = 0;
      while(fileReader.hasNextLine())
      {
         fileReader.nextLine();
         num++;
      }//end while
      return num;
   }//end countRecords
   
   public static void fillRecords(final HashChain database, final Scanner fileReader)
   {
      while(fileReader.hasNextLine())
      {
         int tempID = fileReader.nextInt();
         String tempName = fileReader.nextLine();
         Node newStudent = new Node(tempID, tempName);
         database.put(newStudent);
      }//end while file not empty
   }//end fillRecords
   
   public static int menu(final Scanner kb)
   {
      int choice = -1;
      
      System.out.println("Choose one of the following options.");
      System.out.println("====================================");
      System.out.println("1) insert/update a new student record");
      System.out.println("2) delete a student record");
      System.out.println("3) search for a student record");
      System.out.println("4) print all the student records");
      System.out.println("5) quit");
      
      while(choice < 1 || choice > 5)
      {
         System.out.println("Your choice: ");
         choice = kb.nextInt();
      }//end while
      return choice;
   }//end menu
   
   public static void display(final HashChain database)
   {
   
   }//end display

}//end class