package Practice.day6;

/*
Problem Description
You are given an integer array A of size N.
You have to perform B operations. In one operation,
you can remove either the leftmost or the rightmost element of the array A.
Find and return the maximum possible sum of the B elements that were removed after the B operations.
NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.

Problem Constraints
1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you removed.

Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:
 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4

Output 1:
 8
Output 2:
 9
*/

public class PickFromBothSides {

    // Approach 1 - prefix and suffix sum
    public int solve(int[] A, int B) {
        int N = A.length;
        int[] prefix = new int[B + 1];
        int[] suffix = new int[B + 1];
        int max = Integer.MIN_VALUE;

        // calculating the sum from front - prefix & from back - suffix
        prefix[0] = 0; // indicates taking no elements from prefix that is front
        suffix[0] = 0; // indicates taking no elements from suffix that is back
        for(int i = 0; i < B; i++) {
            prefix[i + 1] = prefix[i] + A[i];
            suffix[i + 1] = suffix[i] + A[N - 1 - i];
        }

        // calculating the max sum possible
        for(int i = 0; i <= B; i++) {
            int sum = prefix[i] + suffix[B - i];
            max = Math.max(max, sum);
        }
        return max;
    }

    // Approach 2 - Sliding window
    public int solveUsingSlidingWindow(int[] A, int B) {
        int N = A.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        // take all elements from back and none from front
        for(int i = N - B; i < N; i++) {
            sum += A[i];
        }

        max = sum;

        // slide the window and take 1 element from front and remove one from back
        for(int i = 0; i < B; i++) {
            sum = sum - A[N - B + i] + A[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
