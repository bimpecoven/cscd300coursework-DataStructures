/* Blake Impecoven - CSCD300 - prog2
Trade class - similar to pair but contains 3 elements.
the first being the lower boundary(index), the second
being the upper boundary(index), and the third being the
difference between the two(value).
*/

public class Trade
{
   public int in;
   public int out;
   public int profit;
   
   public Trade(final int in, final int out, final int profit)
   {
      this.in = in;
      this.out = out;
      this.profit = profit;
   }//end EVC
   
   public String toString()
   {
      return "[" + in + ", " + out + ", " + profit +"]";
   }//end toString
   
}//end Trade