import java.util.Arrays;

public class Arrays_StockBuySell_Only1Transaction {
	
	public static int findMaxProfit(int[] prices){
		
		int result=0;
		int minSoFar = prices[0];
		
		for(int i=1;i<prices.length;i++) {
			minSoFar = Math.min(minSoFar, prices[i]);
			
			result = Math.max(result, prices[i] - minSoFar);
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		int[] prices = {7,1,2,3,4,5,6,7,8,3,6};
		System.out.println(Arrays.toString(prices));
		
		int maxProfit=findMaxProfit(prices);
		
		System.out.println("Maximum profit: " + maxProfit);

	}

}
