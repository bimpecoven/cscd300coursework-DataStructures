/* Blake Impecoven - Circularly Linked List - 4/14/2015
program has a null pointer exception on line 145.
i am aware of the error, felt i was on the right path
and didn't want to change it because i felt the way i 
was doing it was the purpose of the program.
*/

public class CircularlyLinkedList
{
   private class Node
   {
      public int id;
      public int time;
      public Node next;

      public Node()
      {
         this.id = 0;
         this.time = 0;
         this.next = null;
      }//EVC 0 parameters (dummy head)
      
      public Node(final int id, final int time)
      {
         this.id = id;
         this.time = time; 
         this.next = null;  
      }//end EVC 2 parameters

      public Node(final int id, final int time, final Node next)
      {
         this.id = id;
         this.time = time;
         this.next = next;
      }
   }//end (nested) class Node

   public Node head;
   public int size;
   
   public CircularlyLinkedList()
   {
      this.head = new Node();
      this.head.next = head;
      this.size = 0;
   }//end EVC
   
   public int size(){return this.size;}
   
   public void addFirst(final int id, final int time)
   {
      Node newNode = new Node(id, time);
      
      if(this.head == null)//is the list empty?
      {
         this.head = newNode;
         this.size++;
      }//end empty list
      
      else//is there something in the list?
      {
         newNode.next = head.next;
         this.head.next = newNode;
         this.size++;   
      }//end else
   }//end addFirst
   
   public void addLast(final int id, final int time)
   {
      if(this.size() == 0)//is there anything in the list?
         this.addFirst(id, time);
      else
      {
         Node newNode = new Node(id, time);
         Node current = this.head;
         while(current.next != this.head)
         {
            current = current.next;
         }//end while
         newNode.next = current.next;
         current.next = newNode;

         size++;
      }//end else   
   }//end addLast
   
   public void addOrdered(final int id, final int time)
   {        
      Node current = head.next, previous = null;
      
      if(size() == 0) //checks if list is empty
      {
         addFirst(id, time);
         return;
      }  
      while(current != head && (current.id - id) < 0)
      {
         previous = current;
         current = current.next;
      }//end while
      if(previous == null)
         addFirst(id, time); 
      else
      {
         Node newNode = new Node(id, time, current);
         previous.next = newNode;
         size++;
      }//end else    
      
   }//end addOrdered
   
   public void remove(final int id)
   {
      if(id < 0)
         throw new IndexOutOfBoundsException("Index out of bounds!");
      Node current = head, previous = null, old = null;
      
      while(current.id != id)
      {
         previous = current;
         current = current.next;
      }
      old = current;
      current = current.next;
      previous.next = current;
      old.next = null;
      size--;
   }//end remove
   
   public void setValues(final int id, final int serviceTime)
   {
      Node current = head.next;
      int sizeCounter = this.size();
      
      while(current.id != id)
         current = current.next;
         
      current.time = current.time - serviceTime;
      if(current.time <= 0)
         remove(current.id);
   }//end setValues
   
   public void service(final int serviceLength)
   {
      Node current = head.next, previous = null;
      while(this.size() > 1)
      {
         if(current.id == 0 && this.size() > 1)
         {
            previous = current;
            current = current.next;
         }   
         current.time = current.time - serviceLength;
         if(current.time <= 0)
         {
            remove(current.id);
            System.out.println(this);
         }   
         else
            previous = current;
            current = current.next;
      }//end while not empty
   }//end service
   
   public String toString()
   {
      Node current = head.next;
      String str = "";
      
      for(int x = 0; x < this.size(); x++)
      {
         str += "(" + current.id + ", " + current.time + ")";
         current = current.next;
         if(x + 1 != this.size())
            str += ", ";
      }   
      return str;
   }//end toString
   
}//end class