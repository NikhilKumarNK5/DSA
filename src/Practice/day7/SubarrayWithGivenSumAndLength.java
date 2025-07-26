package Practice.day7;

/*
Problem Description
Given an array A of length N. Also given are integers B and C.
Return 1 if there exists a subarray with length B having sum C and 0 otherwise

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 104
1 <= B <= N
1 <= C <= 109

Input Format
First argument A is an array of integers.
The remaining arguments B and C are integers

Output Format
Return 1 if such a subarray exist and 0 otherwise

Input 1:
A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:
A = [4, 2, 2, 5, 1]
B = 4
C = 6

Output 1:
1
Output 2:
0
*/

public class SubarrayWithGivenSumAndLength {
    // solved using sliding window technique
    public int solve(int[] A, int B, int C) {
        int ans = 0;
        int sum = 0;
        int N = A.length;

        // sum of first B elements - first window
        for(int i = 0; i < B; i++) {
            sum += A[i];
        }

        // return 1 if the sum of first B elements is equal to C
        if(sum == C) return 1;

        // loop through the window
        for(int i = 1; i < N; i++) {
            // sliding the window, remove the element at start and adding the next element
            sum = sum - A[i - 1] + A[N - 1 - i];
            if(sum == C) return 1;
        }
        return 0;
    }
}
