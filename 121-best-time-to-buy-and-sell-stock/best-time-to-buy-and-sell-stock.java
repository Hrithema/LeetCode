class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i< prices.length; i++){
            if(prices[i]>buyPrice){
                int current = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, current);
            }
            else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}