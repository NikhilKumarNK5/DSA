package scalar.day7;

/*
Problem Description
Given an array A of length N, Find the maximum subarray sum out of all possible subarray of length B.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 106

Input Format
First argument A is an array of integers.
Second argument B is length of subarray.

Output Format
Return a single integer i.e. max subarray sum

Input 1:
A = [6, 7, 8, 2]
B = 2
Input 2:
A = [3, 9, 5, 6, 5, 11]
B = 3

Output 1:
15
Output 2:
22
*/
public class MaximumSubarraySumOfFixedLength {
    public long solve(int[] A, int B) {
        long ans = 0;
        long sum = 0;
        int N = A.length;

        // calculate the sum of first window
        for(int i = 0; i < B; i++) {
            sum += A[i];
        }
        ans = sum;

        // check for all the other windows as well as update the ans with max value
        int start = 0;
        int end = B;
        while(end < N) {
            sum = sum - A[start] + A[end];
            ans = Math.max(ans, sum);
            start++;
            end++;
        }
        return ans;
    }
}
