
import java.util.*;
/**
 * Heap collection for card objects
 * @author Zohar Le
 * @version 1 
 */
public class CardHeap 
{
   private int size;
   private Card element[];
   /**
    * Default Constructor
    */
   public CardHeap()
   {
      element = new Card[10];
      size = 0;
   }
   /** 
    * add method
    * @param value Card to be added
    */
   public void add(Card value) 
   { 
      // expand if the array is full
      if (size == element.length - 1)
      {
         expand();
      }
      element[size + 1] = value;  // add as rightmost leaf
      // "bubble up" as necessary to fix ordering
      int index = size + 1;   // 
      boolean found = false;
      while (!found && hasParent(index)) // while not found the right position and still not being the root
      {
         int parent = parent(index);
         if (element[index].compareTo(element[parent]) < 0) // compare to its parent
         {
            swap(element, index, parent(index));// swap
            index = parent(index);               // 
         } else {
            found = true;  // found proper location; stop
         }
      }
      size++;
   }
   /**
    * remove method to remove the first element
    */
   public Card remove()
   {
      Card result = element[1];
      element[1] = element[size];
      size--;
      int index = 1;
      boolean found = false;
      // bubble down
      while (!found && hasLeftChild(index)) // while not found the right position and have left child
      {
         int left = leftChild(index);  // left = index of the left child 
         int right = rightChild(index);
         int child = left; 
         if (hasRightChild (index) && element[right].compareTo(element[left]) < 0)// if there is a right child and the right is smaller than the left child
         {
            child = right;    // then change the intended swapped child to be the right to compare latter
         }
         if (element[index].compareTo( element[child]) > 0)// if index is bigger than right or left child then swap
         {
            swap(element,index,child);
            index = child;                   // now check the new swapped object by setting it as the index
         } else {
            found = true;
         }
      }
      return result;
   }
   /**
    * clear the list*/
   public void clear(){
      element = new Card[10];
      size = 0;
   }
   private void expand()
   {
      Card temp[] = new Card[element.length*2];
      for(int i=0; i<element.length;i++)
      {
         temp[i] = element[i];
      }
      element = temp;
   }
   @Override
   public String toString()
   {
      if( size == 0)
      {
         return "[]";
      }
      String result = "";
      for (int i = 1; i <= size; i++)
      {
         if(element[i] != null)
         {
            result += "," + element[i];
         }
      }
      return "[" + result.substring(1) + "]";   
   }
   /**
    * return the size
    * @return size */
   public int size(){
      return size;
   }
   private int parent(int index)        { return index/2; }// return index of the parent
   private int leftChild(int index)     { return index*2; }// return index of the left child
   private int rightChild(int index)    { return index*2 + 1; }
   private boolean hasParent(int index) { return index > 1; }
   private boolean hasLeftChild(int index) 
   {
      return leftChild(index) <= size;
   }
   private boolean hasRightChild(int index) 
   {
      return rightChild(index) <= size;
   }
   private void swap(Card[] a, int index1, int index2) 
   {
      Card temp = a[index1];
      a[index1] = a[index2];
      a[index2] = temp;
   }
}