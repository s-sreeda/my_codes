public class Arrays_StockBuySell_NoLimits {
	
	//Multiple transactions allowed
	
	//Stock - buy at a lower price and sell at a higher price.
	
	/* Optimum approach: Instead of selling at local maxima, we keep selling while the prices are going up.
	 * This way we accumulate the same profit and avoid some condition checks
	required for computing local maxima and minima.
	
	Algorithm:
	1.Traverse price[] from i=1 to price.size()-1
	2.res = 0
	if price[i]>price[i-1]
		res = res + price[i]-price[i-1]
	*/
	
	static int maximumProfit(int[] arr) {
		
		int result = 0;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				result = result + arr[i] - arr[i-1];
			}
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		 
		int[] prices = {100,120,130,140,40};
		System.out.println("Prices: " + Arrays.toString(prices));
		
		int maxProfit = maximumProfit(prices);
		
		System.out.println("Maximum profit that can be achieved is: " + maxProfit);

	}

}
