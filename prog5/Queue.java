/* Blake Impecoven - CSCD300 - 5/2/2015
Queue data structure interface - used with arrayQueue and LinkedListQueue
*/

public interface Queue
{
   public int size();
   public int front();
   
   public void enqueue(final int item);
   public int dequeue();
}//end interface