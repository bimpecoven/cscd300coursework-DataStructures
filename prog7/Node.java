/* Blake Impecoven - CSCD300 - prog7

*/

public class Node
{
   public int item;
   public String name;
   public Node next;
      
   public Node()
   {
      this.item = 0;
      this.name = null;
      this.next = null;
   }//end Node 0
      
   public Node(final int item, final String name)
   {
      this.item = item;
      this.name = name;
      this.next = null;
   }//end Node 1
      
}//end class