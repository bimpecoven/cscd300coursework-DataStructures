/* Blake Impecoven - CSCD300 - prog7

*/

public class HashChain implements Map
{
   protected int size;
   protected LinkedList[] hashTable;
   
   public HashChain(final int tableSize)
   {
      this.size = 5;
      this.hashTable = new LinkedList[tableSize];
      for(int x = 0; x < tableSize; x++)
         hashTable[x] = new LinkedList();
   }// constructor
   
   public int hash(final int key)
   {
      return (((7 * key) + 29) % 5);  
   }
   
   public int size(){ return size; }
   
   public String get(final int key)
   {
      Node temp = hashTable[hash(key)].search(key);
      
      if(temp == null)
         return null;
      else
         return temp.name;   
   }//end get
   
   public void put(final Node element)
   {
      Node temp = hashTable[hash(element.item)].search(element.item);
      
      if(temp == null)
      {
         hashTable[hash(element.item)].insert(element);
         System.out.println("The new student has been added successfully.");
         size++;
      }
      else
      {
         temp.item = element.item;
         temp.name = element.name;
         System.out.println("The student was exiting and the record has been updated.");
      }//end else
   }//end put
   
}//end class