/* Blake Impecoven - CSCD300 - prog 8

*/

import java.io.*;
import java.util.*;

public class Test_BST
{
   public static void main(String[]args) throws FileNotFoundException
   {
      File inputFile = new File(args[0]);
      Scanner fileReader = new Scanner(inputFile);
      Scanner kb = new Scanner(System.in);
      BinarySearchTree BST = new BinarySearchTree();
      fillTree(fileReader, BST);
      boolean keepGoing = true;
      Node ret = null;
      Node temp = null;
      int num = 0;
      
      do{
         String choice = menu(kb).toLowerCase();
         
         switch(choice)
         {
            case "1":   System.out.println("Input the key: ");
                        ret = BST.search(kb.nextInt());
                        if(ret == null)
                           System.out.println("The given key does not exist.");
                        else
                           System.out.println("The given key exists.");   
                        break;   
                     
            case "2":   System.out.println("Input the key: ");
                        num = kb.nextInt();
                        ret = BST.search(num);
                        if(ret != null)
                        {   
                           BST.insert(num);
                           System.out.println("The given key has been inserted successfully");
                        }
                        else
                           System.out.println("The given key already exists.");   
                        break;
            
            case "3":   System.out.println("Input the key: ");
                        ret = BST.delete(kb.nextInt());
                        if(ret == null)
                           System.out.println("No such key.");
                        else
                           System.out.println("The given key has been successfully deleted.");
                        break;      
            
            case "4":   BST.inOrderTraversal(BST.root);
                        break;   
            
            case "5":   BST.preOrderTraversal(BST.root);
                        break;      
            
            case "6":   BST.postOrderTraversal(BST.root);
                        break;
                        
            case "7":   BST.levelOrderTraversal(BST.root);
                        break;
            
            case "8":   ret = BST.min(BST.root);
                        if(ret == null)
                           System.out.println("The tree is empty");
                        else
                           System.out.println(ret.key);  
                        break;          
            
            case "9":   ret = BST.max(BST.root);
                        if(ret == null)
                           System.out.println("The tree is empty");
                         else
                           System.out.println(ret.key);  
                        break;    
            
            case "a":   System.out.println("Input the key: ");
                        ret = BST.search(kb.nextInt());
                        if(ret == null)
                           System.out.println("No such key.");
                        else
                        {
                           ret = BST.successor(ret);
                           if(ret != null)
                              System.out.println(ret.key); 
                           else
                              System.out.println("The given key exists but does not have a successor."); 
                        }//end else    
                        break;       
            
            case "b":   System.out.println("Input the key: ");   
                        ret = BST.search(kb.nextInt());
                        if(ret == null)
                           System.out.println("No such key.");
                        else
                        {
                           ret = BST.predecessor(ret);
                           if(ret != null)
                              System.out.println(ret.key); 
                           else
                              System.out.println("The given key exists but does not have a predecessor.");    
                        }//end else   
                        break;   
            
            case "x":   System.out.println("Goodbye.");
            
            default:    keepGoing = false;
                        
         }//end switch
      }while(keepGoing == true);   
   }//end main
   
   public static void fillTree(final Scanner fileReader, final BinarySearchTree BST)
   {
      if(fileReader == null)
         throw new RuntimeException("Precondition not met.");
         
      while(fileReader.hasNextInt())
         BST.insert(fileReader.nextInt());
         
   }//end fillTree
   
   public static String menu(final Scanner kb)
   {
      if(kb == null)
         throw new RuntimeException("Precondition not met!");
      
      System.out.println("Choose one of the following options.");
      System.out.println("====================================");
      System.out.println("1) Search for a key");
      System.out.println("2) Insert a new key");
      System.out.println("3) Delete an existing key");
      System.out.println("4) Inorder traversal of the BST");
      System.out.println("5) Preorder traversal of the BST");
      System.out.println("6) Postorder traversal of the BST");
      System.out.println("7) Level-order traversal of the BST");
      System.out.println("8) Find the smallest key");
      System.out.println("9) Find the largest key");
      System.out.println("a) Find the successor of a given key");
      System.out.println("b) Find the predecessor of a given key");
      System.out.println("x) Quit");
      System.out.println("Press enter.");
      kb.nextLine();   //flush buffer
      System.out.println("Please make a choice: ");
      String ret = kb.nextLine().toLowerCase();
      Boolean isValid = check(ret);
      while(isValid == false)
      {  
         System.out.println("Invlaid choice, please make a valid selection: ");
         ret = kb.nextLine();
         isValid = check(ret);
      }//end while
      
      return ret;         
   }//end menu
     
   public static boolean check(final String ret)
   {      
      if(ret.equals("1") || ret.equals("2") || ret.equals("3") || ret.equals("4") || ret.equals("5") ||
         ret.equals("6") || ret.equals("7") || ret.equals("8") || ret.equals("9") || ret.equals("a") ||
         ret.equals("b") || ret.equals("x"))
         return true;
      else
         return false;
                  
   }//end check
}//end class