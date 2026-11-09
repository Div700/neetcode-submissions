class Solution {
    public int maxProfit(int[] prices) 
    {
        int maxProfit = 0;
        int lowestPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,prices[i]-lowestPrice);
            if(prices[i]<lowestPrice) lowestPrice = prices[i];
        }   
        return maxProfit;
    }
}
