/* Blake Impecoven - CSCD300 - 5/2/2015

*/

public class ArrayQueue implements Queue
{
   protected int capacity;
   protected static final int CAPACITY = 1000;
   
   protected int[]Q;
   protected int head;
   protected int tail;
   
   protected int size;
   
   public ArrayQueue()
   {
      capacity = CAPACITY;
      Q = new int[capacity];
      head = -1;
      tail = -1;
      size = 0;
   }//
   
   public ArrayQueue(final int capacity)
   {
      if(capacity <= 0)
         return;
      this.capacity = capacity;
      Q = new int[capacity];
      head = -1;
      tail = -1;
      size = 0;   
   }//
   
   public int size(){return size;}
   
   public int front()
   {
      if(size == 0)
         return -1;
      return Q[head];   
   }//end front
   
   public void enqueue(final int item)
   {
      if(size == capacity)
         return;
      if(size == 0)
      {
         Q[0] = item;
         head = 0;
         tail = 0;
      }//end if   
      else
      {
         tail = (tail + 1) % capacity;
         Q[tail] = item;
      }//end else
      size++;
   }//end enqueue
   
   public int dequeue()
   {
      if(size == 0)
         return -1;
      
      int ret = Q[head];
      
      if(size == 1)
      {
         head = -1;
         tail = -1;
      }//end if   
      else
         head = (head + 1) % capacity;
      
      size--;
      return ret;
   }//end dequeue
   
   public boolean isEmpty()
   {
      if(size() == 0)
         return true;
      return false;   
   }//end isEmpty 
}//end class
