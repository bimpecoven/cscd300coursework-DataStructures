/* Blake Impecoven - CSCD300 - 5/2/2015

*/

public class ListQueue implements Queue
{
   protected Node head;
   protected Node tail;
   protected int size;
   
   private class Node
   {
      public int item;
      public Node next;
      
      public Node()
      {
         this.item = 0;
         this.next = null;
      }//end Node 0
      
      public Node(final int item)
      {
         this.item = item;
         this.next = null;
      }//end Node 1
      
      public Node(final int item, final Node next)
      {
         this.item = item;
         this.next = next;
      }//end Node
      
   }//end class Node

   public ListQueue()
   {
      head = null;
      tail = null;
      size = 0;
   }//end
   
   public int size(){ return size; }
   
   public int front()
   {
      if(size == 0)
         return -1;
      return head.item;   
   }//end front
   
   public void enqueue(final int item)
   {  
      Node newNode = new Node(item, null);
      
      if(size == 0)
      {
         head = newNode;
         tail = newNode;
      }//end if      
      else
      {
         tail.next = newNode;
         tail = newNode;
      }//end else
      size++;//incriment size    
   }//end enqueue
   
   public int dequeue()
   {
      if(size == 0)
         return -1;
         
      int ret = head.item;
      
      if(size == 1)
      {
         head = null;
         tail = null;
      }//end if   
      else
      {
         Node oldHead = head;
         head = head.next;
         oldHead.next = null;
      }//end else
      size--;//increment size
      
      return ret;
   }//end dequeue
   
   public String toString()
   {
      String str = "";
      Node cur = head;
      while(cur != null)//traverse ListQueue
      {  
         str += cur.item;
         if(cur.next.next != null)
            str += ", ";      
      }//end while
      return str;
   }//end toString
   
   public boolean isEmpty()
   {
      if(size() == 0)
         return true;
      return false;   
   }//end isEmpty 
}//end class
