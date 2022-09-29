import java.util.*;

/**
 * Card class create a card with 3 traits r, p, and s and perform its methods
 * @author Zohar Le
 * @version 1
 */
public class Card implements Comparable<Card>
{
   private int r, p ,s;
   /**
    * Constructor to construct a random r, p, and s values
    */
   public Card()
   {
      Random rand = new Random();
      r = rand.nextInt(1000) + 1;
      p = rand.nextInt(1000) + 1;
      s = rand.nextInt(1000) + 1;
   }
   /**
    * Construct a constructor with r, p, and s all equal to the user value
    * @param x user integer value
    * @throws IndexOutOfBoundsException if x is out of bound
    */
   public Card (int x ) 
   {
      if (x <= 1000 && x >=1)
      {
         r = x;
         p = x;
         s = x;
      }
      else throw new IndexOutOfBoundsException();
   }
   /**
    * Construct a constructor with given r, p, s values
    * @param r value of r
    * @param p value of p
    * @param s value of s
    * @throws @throws IndexOutOfBoundsException if r or p or s is out of bound
    */
   public Card (int r, int p, int s)
   {
      if ((r > 1000 || r < 1) || (p >  1000 || p < 1) || (s > 1000 || s < 1))
      {
         throw new IndexOutOfBoundsException();
      } else
      {
         this.r = r;
         this.p = p;
         this.s = s;
      }
   }
   /**
    * Gets value of r
    * @return value of r
    */
   public int getR() {return r;}
   /**
    * Gets value of p
    * @return value of p
    */
   public int getP() {return p;}
   /**
    * Gets value of s
    * @return value of s
    */
   public int getS() {return s;}
   /**
    * Calculate cost and return it
    * @return value cost
    */
   public int getCost()
   {
      int x = r + p + s;
      // Cost formula
      return (int) Math.ceil(12/(10*((Math.pow((r*1.0/x), 5) + Math.pow((p*1.0/x), 5) + Math.pow((s*1.0/x), 5)))));
   }
   /**
    * this method check the corresponding value of r, p, s
    * @param x given Card element
    * @return true if their r, p, s are all the same otherwise false
    */
   public boolean equals (Card x)
   {
      if (this.r == x.r && this.p == x.p && this.s == x.s)
         return true;
      else return false;
   }
   @Override
   public String toString()
   {
      return "[" + r + "," + p + "," + s + "::" + this.getCost() + "]";
   }
   /**
    * this method find the smallest value betweek r, p, s then subtract by 5 then return it
    * @return the smallest value after got weakened
    */   
   public void weaken() 
   {
      if (r <p && r <s)
         r -= 5;
      else if (p <s && p <s)
         p -= 5;
      else if (s < p && s < r) 
         s -= 5;
      if (( r <=1) || ( p <=1) || ( s <=1))
         {boost();
         System.out.println("Causing out of boundary, cannot be weakened"); }          
   }
   /**
    * this method find the smallest value betweek r, p, s then add by 5 then return it
    * @return the smallest value after got boosted
    */  
   public void boost()
   {
      if (r <p && r <s)
         r += 5;
      else if (p <s && p <s)
         p += 5;
      else if (s < p && s < r) 
         s += 5;
      // check boundary, if out of bound, then weaken it back to do nothing
      if ((r >= 1000 ) || (p >= 1000 ) || (s >= 1000))
         {weaken();
         System.out.println("Causing out of boundary, cannot be boosted");}      
   }
   @Override
   public int compareTo(Card other)
   {
      // if they have different cost then return its subtraction
      if (this.getCost() != other.getCost()) return this.getCost()-other.getCost();
      // else same cost, return its sum subtraction
      else {
         int x = this.r + this.p + this.s;
         int y = other.r + other.p + other.s;
         return x - y;
      } 
   }
   
}  