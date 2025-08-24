package Practice.day16;

/*
Problem Description
Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.

Problem Constraints
1 <= N <= 10^6
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.

Input 1:
 A = [1, 2, 3, 4, -10]
Input 2:
 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 1:
 10
Output 2:
 6
*/

public class MaxSumContiguousSubarray {

    // Approach 1: Find each subarray sum and track the maximum sum
    // TC => O(N^2) - TLE
    public int maxSubArray(final int[] A) {
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += A[j];

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Approach 2: Kadane's Algorithm
    // Keep calculating the currSum and track the maxSum and if the currSum becomes less than 0 then reset it and track
    // TC => O(N)
    public int maxSubArrayKadane(final int[] A) {
        int n = A.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            currSum += A[i];

            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
}
