/* Blake Impecoven - CSCD300 - prog8
Node class for BST
*/

public class Node
{
   protected int key;
   protected Node parent;
   protected Node left;
   protected Node right;
      
   public Node()
   {
      this.key = 0;
      this.parent = null;
      this.left = null;
      this.right = null;
   }
   public Node(final int key)
   {
      this.key = key;
      this.parent = null;
      this.left = null;
      this.right = null;
   }
   
}//end class