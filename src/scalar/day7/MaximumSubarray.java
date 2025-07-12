package scalar.day7;

/*
Problem Description
You are given an integer array C of size A. Now you need to find a subarray
(contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.

Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106

Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.

Output Format
Return a single integer which denotes the maximum sum.

Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:
A = 3
B = 1
C = [2, 2, 2]

Output 1:
12
Output 2:
0
*/

public class MaximumSubarray {
    // Approach 1 - Brute force
    // finding sum of each subarray and checking
    // TC => O(N^2)
    public int maxSubarray(int A, int B, int[] C) {
        int ans = 0;
        for(int i = 0; i < A; i++) {
            int sum = 0;
            for(int j = i; j < A; j++) {
                sum += C[j];
                if(sum <= B) {
                    ans = Math.max(ans, sum);
                } else {
                    break; // breaks out of inner loop
                }
            }
        }
        return ans;
    }

    // Approach 2 - Sliding window
    // we can use the window such that once the sum exceeds B we can reduce the window
    // TC => O(N)
    public int maxSubarraySlidingWindow(int A, int B, int[] C) {
        int ans = 0;
        int sum = 0;
        int left = 0; // to reduce the size of window from left of the array C
        for(int right = 0; right < A; right++) {
            sum += C[right];

            // only enters loop when sum is greater than B and left <= right
            while(sum > B && left <= right) {
                sum -= C[left]; // reducing the window size
                left++;
            }

            // updating the ans only if it is less than equal to B
            // updating answer after while so that it updates after we reduce the window size and give us the correct result
            if(sum <= B) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
