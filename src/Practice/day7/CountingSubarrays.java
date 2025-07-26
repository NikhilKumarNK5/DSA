package Practice.day7;

/*
Problem Description
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.

Problem Constraints
1 <= N <= 5 x 10^3
1 <= A[i] <= 1000
1 <= B <= 10^7

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the number of subarrays in A having sum less than B.

Input 1:
 A = [2, 5, 6]
 B = 10
Input 2:
 A = [1, 11, 2, 3, 15]
 B = 10

Output 1:
 4
Output 2:
 4
*/

public class CountingSubarrays {
    // Approach 1: Brute Force
    // Find the sum of each subarray and then check if sum is less than B then increase the count
    // At the end return the count
    // TC => O (N^2)
    public int solve(int[] A, int B) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            int sum = 0;
            for(int j = i; j < A.length; j++) {
                sum += A[j];

                if(sum < B) {
                    count++;
                }
            }
        }
        return count;
    }

    // Approach 2: using sliding window
    // since all are non-negative numbers we can use the sliding window technique to keep running sum
    // TC => O(N)
    public int solveSlidingWindow(int[] A, int B) {
        int n = A.length;
        int start = 0;
        int end = 0;
        long sum = 0;
        int count = 0;

        while(end < n) {
            sum += A[end]; // adding the current element to window sum

            // if the current sum >= B, shrink the window from the start
            while(sum >= B && start <= end) {
                sum -= A[start]; // remove element from start
                start++; // moving the start of the window forward
            }

            // At this point all subarrays from start to end have sum < B
            count += (end - start + 1);

            // moving the end to expand the window
            end++;
        }
        return count;
    }
}
