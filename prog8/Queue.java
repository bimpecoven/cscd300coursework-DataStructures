/* Blake Impecoven - CSCD300 - prog8
Queue data structure interface - used with ListQueue(specifically for BST implementation)
*/

public interface Queue
{
   public int size();
   public Node front();
   
   public void enqueue(final Node item);
   public Node dequeue();
}//end interface