/* Blake Impecoven - CSCD300 - prog8
 * 
 * Binary Search Tree class - implementing the binary search tree
 * data structure using two child nodes per parent node, all 
 * extending from one root node.
**/

public class BinarySearchTree
{
   protected Node root;
   
   public BinarySearchTree()
   {
      this.root = null;
   }//end constructor
   
   /* The min method is going to
    * return to us the smallest key
    * value of any given sub tree 
    * that we pass into the method.
   **/
   public Node min(final Node subTreeRoot)
   {
      Node temp = subTreeRoot;
      while(temp.left != null)
         temp = temp.left;
      return temp;   
   }//end min
   
   /* The max method is going to
    * return to us the largest key
    * value of any given sub tree 
    * that we pass into the method.
   **/
   public Node max(final Node subTreeRoot)
   {
      Node temp = subTreeRoot;
      while(temp.right != null)
         temp = temp.right;
      return temp;   
   }//end max
   
   /* The search method is pretty self
    * explanatory. We will just traverse
    * the tree until we find a node with
    * a key matching the int passed in
   **/
   public Node search(final int key)
   {
      Node cur = root;
      
      while(cur != null && key != cur.key)
      {
         if(key < cur.key)
            cur = cur.left;
         else
            cur = cur.right;      
      }//end while
      
      return cur;
   }//end search
   
   /* The insert method is going to insert
    * a node into our BST and maintain the
    * ordered binary integrity of the tree
   **/
   public Node insert(final int key)
   {
      Node newNode = new Node(key);
      
      Node y = null;
      Node x = root;
      
      while(x != null)
      {
         y = x;
         if(key == x.key)
            return null;
         if(key < x.key)
            x = x.left;
         else
            x = x.right;       
      }//end while
      
      newNode.parent = y;
      
      if(y == null)
         root = newNode;
      else if(key < y.key)
         y.left = newNode;
      else
         y.right = newNode;
      return newNode;         
   }//end insert
   
   /* The delete method uses a helper method,
    * which is also named delete. The method
    * will call search before calling its helper.
    * If search comes back null we just return 
    * a null node
   **/ 
   public Node delete(final int key)
   {
      Node z = search(key);
      if(z != null)
         delete(z);
      return z;   
   }//end delete
   
   /* The delete helper method is going to do the
    * bulk of the work here. It is based off of 3 
    * major cases.
    * Case #1 - The node we want to delete is a 
    * leaf node. We just cut it off.
    * Case #2 - The node we want to delete has either,
    * but only one subtree.
    * Case #3 - The node we want to delete has a 
    * subtree on both sides of the node.
   **/
   private void delete(final Node z)
   {
   	  /*Case #1*/
      if(z.left == null && z.right == null)
         transplant(z, null);
      /*Case #2*/
      else if(z.left == null)
         transplant(z, z.right);
      else if(z.right == null)
         transplant(z, z.left);
      /*Case #3*/
      else
      {
         Node y = min(z.right);
         if(y.parent != z)
         {
            transplant(y, y.right); 
            y.right = z.right;
            y.right.parent = y;
         }//end if             
         
         transplant(z, y);
         y.left = z.left;
         y.left.parent = y; 
      }//end else   
   }//end helper
   
   /* The transplant method acts as a helper for
    * the delete function.
   **/
   public void transplant(final Node oldSubtree, final Node newSubtree)
   {
      if(oldSubtree.parent == null)
         root = newSubtree;
      else if(oldSubtree == oldSubtree.parent.left)
         oldSubtree.parent.left = newSubtree;
      else
         oldSubtree.parent.right = newSubtree;
         
      if(newSubtree != null)
         newSubtree.parent = oldSubtree.parent;      
   }//end transplant
   
   public Node successor(Node x)
   {
      if(x.right != null)
         return min(x.right);
       
      Node y = x.parent;
      while(y != null && x == y.right)
      {
         x = y;
         y = y.parent;
      }//end while  
      
      return y; 
   }//end successor
   
   public Node predecessor(Node x)
   {
      if(x.right != null)
         return max(x.left);
         
      Node y = x.parent;
      while(y != null && x == y.left)
      {
         x = y;
         y = y.parent;
      }//end while
      return y;
   }//end predecessor
   
   public void inOrderTraversal(final Node subtreeRoot)
   {
      if(subtreeRoot != null)
      {
         inOrderTraversal(subtreeRoot.left);      
         System.out.println(subtreeRoot.key);
         inOrderTraversal(subtreeRoot.right);
      }//end if   
   }//end inOrderTraversal
   
   public void preOrderTraversal(final Node subtreeRoot)
   {
      if(subtreeRoot != null)
      {
         System.out.println(subtreeRoot.key);
         preOrderTraversal(subtreeRoot.left);
         preOrderTraversal(subtreeRoot.right);
      }//end if   
   }//end preOrderTraversal
   
   public void postOrderTraversal(final Node subtreeRoot)
   {
      if(subtreeRoot != null)
      {
         postOrderTraversal(subtreeRoot.left);
         postOrderTraversal(subtreeRoot.right);
         System.out.println(subtreeRoot.key);
      }//end if
   }//end postOrderTraversal
   
   public void levelOrderTraversal(final Node subtreeRoot)
   {
      ListQueue Q = new ListQueue();
      
      Q.enqueue(subtreeRoot);
      
      while(Q.size > 0)
      {
         Node newNode = Q.dequeue();
         System.out.println(newNode.key);
         if(newNode.left != null)
            Q.enqueue(newNode.left);
         if(newNode.right != null)
            Q.enqueue(newNode.right);   
      }//end while   
      
   }//end levelOrderTraversal
   
}//end class