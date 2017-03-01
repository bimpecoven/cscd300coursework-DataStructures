/* Blake Impecoven - CSCD300 - 4/27/2015

*/

public class LinkedList implements Stack
{  
   private Node head;
   private int size;
   
   public LinkedList()
   {
      this.head = new Node();
      this.size = 0;
   }//end LinkedList
   
   public int size(){return this.size;}
   
   public void addLast(final int id, final String name)
   {
      Node newNode = new Node(id, name);
      Node cur = head;
      
      if(this.size == 0)
      {
         cur.next = newNode;
         size++;
      }
      else
      {
         while(cur.next != null)
            cur = cur.next;
            
         cur.next = newNode;
         size++;   
      }//end else
   }//end addLast
      
   public Node search(final int key)
   {
      Node cur = head;
      for(int x = 0; x < key; x++)
         cur = cur.next;
         
      return cur;   
   }//end search
}//end class LinkedList