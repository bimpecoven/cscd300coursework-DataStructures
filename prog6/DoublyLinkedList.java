/* Blake Impecoven - CSCD300 - 5/12/2015
Doubly LinkedList
*/

public class DoublyLinkedList
{
   private class Node
   {
      public int item;
      public Node next;
      public Node prev;
      
      public Node()
      {
         this.item = 0;
         this.next = null;
         this.prev = null;
      }//end Node 0
      
      public Node(final int item)
      {
         this.item = item;
         this.next = null;
         this.prev = null;
      }//end Node 1
      
      public Node(final int item, final Node next)
      {
         this.item = item;
         this.next = next;
         this.prev = null;
      }//end Node
      
      public Node(final Node prev, final int item)
      {
         this.item = item;
         this.next = null;
         this.prev = prev;
      }//end Node 
      
      public Node(final int item, final Node next, final Node prev)
      {
         this.item = item;
         this.next = next;
         this.prev = prev;
      }//end Node
      
   }//end class Node
   
   private Node head;
   private int size;
   private Node tail;
   
   public DoublyLinkedList()
   {
      this.head = new Node();
      this.size = 0;
      this.tail = new Node();
      this.head.next = tail;
      this.tail.prev = head;
   }//end DoublyLinkedList
   
   public int size(){ return this.size; }
   
   public void addAfter(final int item) 
   {             
      Node newNode = new Node(item); 
      Node cur = head;                      
      if(this.size == 0)
      {      
         tail.prev = newNode;
         newNode.next = tail;
         cur.next = newNode;
         newNode.prev = cur;
         size++;
      }   
      else
      {
         while(cur.next != tail)
            cur = cur.next;
         
         tail.prev = newNode;
         newNode.next = tail;
         cur.next = newNode;
         newNode.prev = cur;
         size++;         
      }//end else   
   }//end addAfter
   
   public int getItem(int index)
   {
      Node cur = head.next;
      int num = 0;
      if(index == this.size)
         for(int x = 0; x < index - 1; x++)
            cur = cur.next;
      else
         for(int i = 0; i < index; i++)
            cur = cur.next;      
      return cur.item;
   }//end getPivotValue
   
   public void setItem(final int index, final int item)
   {
      Node cur = head.next;
      int num = 0;
      if(index == this.size)
         for(int x = 0; x < index - 1; x++)
            cur = cur.next;
      else
         for(int i = 0; i < index; i++)
            cur = cur.next; 
         
      cur.item = item;   
   }//end setItem
   
   public String toString()
   {
      Node cur = head.next;
      String str = "" + cur.item;
      while(cur.next != tail)
      {
         cur = cur.next;
         str += ", " + cur.item;
      }//end while
      return str;
   }//end toString
}//end class