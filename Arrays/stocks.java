package localrepo.Arrays;

public class stocks {
    // Best time to buy and sell stock
    // You are given an array prices where prices[i] is the price of a given stock
    // on the ith day.
    // You want to maximize your profit by choosing a single day to buy one stock
    // and choosing a different day in the future to sell that stock.
    // Return the maximum profit you can achieve from this transaction. If you
    // cannot achieve any profit, return 0.
    public int maxProfit(int[] prices) {
        // We have to return the max profit which is difference between
        // prices of day of sell and bought
        // We are using Kadane's algorithm:It is the algorithm to find the max sum of a
        // continous sub arrays
        int maxProfit = 0;
        int minSoFar = prices[0];
        // for loop to find profit
        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

}
