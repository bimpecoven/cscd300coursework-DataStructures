/* Blake Impecoven - CSCD300 - prog2

*/

import java.util.*;
import java.io.*;

public class Test_BestTrading
{
   public static void main(String[]args) throws FileNotFoundException
   {
      Scanner kb = new Scanner(System.in);
      //File stockRecords = new File("data.txt");
      File stockRecords = new File(Test_BestTrading.readFileName(kb));
      int[]stockPrices = Test_BestTrading.fillArray(stockRecords);
      System.out.println("Best Trade: " + Test_BestTrading.BestTrade(stockPrices));
   }//end main
   
   public static String readFileName(final Scanner kb)
   {
      String fileName = "";
      while(fileName == "" || fileName.isEmpty())
      {
         System.out.print("What file would you like to open? ");
         fileName = kb.nextLine();
      }//end while
      return fileName;
   }//end readFileName
   
   public static int countRecords(final File stockRecords)throws FileNotFoundException
   {
      int count = 0;
      Scanner stockReader = new Scanner(stockRecords);
      while(stockReader.hasNext())
      {
         stockReader.nextLine();
         count++;
      }//end while
      return count;
   }//end countRecords
   
   public static int[] fillArray(final File stockRecords) throws FileNotFoundException
   {
      Scanner stockReader = new Scanner(stockRecords);
      int[]stockPrices = new int[Test_BestTrading.countRecords(stockRecords)];
      for(int x = 0; x < stockPrices.length; x++)
      {
         stockPrices[x] = stockReader.nextInt();
      }
      return stockPrices;
   }//end readArray
   
   public static Trade BestTrade(final int[] p)
   {
      int[] profit = bestProfit(p, 0, p.length - 1);
      Trade bestTrade = new Trade(profit[0], profit[1], getProfit(p, profit));

      return bestTrade;
   }//end BestTrade

    public static int[] bestProfit(final int[] stockValue, final int left, final int right) 
    {
        if (left == right)
            return new int[]{left, right};

        int mid = (left + right) / 2;

        int[] leftGains = bestProfit(stockValue, left, mid);
        int[] rightGains = bestProfit(stockValue, mid + 1, right);

        //left of midpoint profit
        int leftHalf = left;
        for (int x = left; x <= mid; x++) 
        {
            if(stockValue[x] < stockValue[leftHalf])
                leftHalf = x;
        }//end for

        //right of midpoint profit
        int rightHalf = right;
        for(int x = mid; x < right; x++)
        {
            if(stockValue[x] > stockValue[rightHalf])
                rightHalf = x;
        }//end for

        int[] maxIndices = leftGains;
        int[][] profitIndicies = {rightGains, new int[] {leftHalf, rightHalf}};
        for(int[] indicies: profitIndicies)
        {
            if(getProfit(stockValue, maxIndices) < getProfit(stockValue, indicies))
                maxIndices = indicies;
        }
        return maxIndices;
    }

    private static int getProfit(final int[] stock, final int[] indices){
        return stock[indices[1]] - stock[indices[0]];
    }
 
}//end class