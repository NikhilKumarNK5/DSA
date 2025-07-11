package scalar.day6;

/*
Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.

Problem Constraints
0 <= A.size() <= 700000
1 <= A[i] <= 107

Input Format
The first and the only argument is an array of integers, A.

Output Format
Return an integer, representing the maximum possible profit.

Input 1:
A = [1, 2]
Input 2:
A = [1, 4, 5, 2, 4]

Output 1:
1
Output 2:
4
*/

public class BestTimeToBuyAndSellStocks {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int N = A.length;
        // return 0 if the size of the array is less than 2 as there is not selling price
        if(N < 2) {
            return 0;
        }
        // set the buyPrice at start equal to the first index
        int buyPrice = A[0];
        // setting the maxProfit at start equal to zero
        int maxProfit = 0;

        for(int i = 1; i < N; i++) {
            // if the current price is less than the previous then making that as buyPrice
            if(A[i] < buyPrice) {
                buyPrice = A[i];
            } else { // if currentPrice is greater than calculating the currentProfit
                int currentProfit = A[i] - buyPrice;
                // calculating the maxProfit
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
