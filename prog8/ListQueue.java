/* Blake Impecoven - CSCD300 - prog8
for use with BST, Nodes are of type BST Node
*/

public class ListQueue implements Queue
{
   protected QNode head;
   protected QNode tail;
   protected int size;
   
   private class QNode
   {
      public Node item;
      public QNode next;
      
      public QNode()
      {
         this.item = null;
         this.next = null;
      }//end Node 0
      
      public QNode(final Node item)
      {
         this.item = item;
         this.next = null;
      }//end Node 1
      
      public QNode(final Node item, final QNode next)
      {
         this.item = item;
         this.next = next;
      }//end QNode
      
   }//end class QNode

   public ListQueue()
   {
      head = null;
      tail = null;
      size = 0;
   }//end
   
   public int size(){ return size; }
   
   public Node front()
   {      
      if(size == 0)
         return null;
      return head.item;   
   }//end front
   
   public void enqueue(final Node item)
   {  
      QNode newNode = new QNode(item, null);
      
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
   
   public Node dequeue()
   {
      if(size == 0)
         return null;
         
      Node ret = head.item;
      
      if(size == 1)
      {
         head = null;
         tail = null;
      }//end if   
      else
      {
         QNode oldHead = head;
         head = head.next;
         oldHead.next = null;
      }//end else
      size--;//increment size
      
      return ret;
   }//end dequeue
   
   public String toString()
   {
      String str = "";
      QNode cur = head;
      while(cur != null)//traverse ListQueue
      {  
         str += cur.item.key;
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
