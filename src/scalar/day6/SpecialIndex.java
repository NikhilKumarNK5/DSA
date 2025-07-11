package scalar.day6;

/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such
that removing an element from these indices makes the sum of even-indexed and
odd-indexed array elements equal.

Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109

Input Format
First argument contains an array A of integers of size N

Output Format
Return the count of array indices such that removing an element from these indices
makes the sum of even-indexed and odd-indexed array elements equal.

Input 1:
A = [2, 1, 6, 4]
Input 2:
A = [1, 1, 1]

Example Output
Output 1:
1
Output 2:
3
*/

public class SpecialIndex {
    public int solve(int[] A) {
        int N = A.length;
        int[] pSe = new int[N];
        int[] pSo = new int[N];
        int res = 0;

        // prefixSum of even indexed elements
        pSe[0] = A[0];
        for(int i = 1; i < N; i++) {
            if(i % 2 == 0) {
                pSe[i] = pSe[i - 1] + A[i];
            } else {
                pSe[i] = pSe[i - 1];
            }
        }

        // prefixSum of odd indexed elements
        pSo[0] = 0;
        for(int i = 1; i < N; i++) {
            if(i % 2 != 0) {
                pSo[i] = pSo[i - 1] + A[i];
            } else {
                pSo[i] = pSo[i - 1];
            }
        }

        int sumOfEven = 0;
        int sumOfOdd = 0;

        for(int i = 0; i < N; i++) {
            // when the first element is removed that is i = 0
            // odd indexed become even and vice versa
            if(i == 0) {
                sumOfEven = pSo[N - 1] - pSo[0];
                sumOfOdd = pSo[N - 1] - pSe[0];
            }

            // when the last index is removed
            // indexed remain same but the sum would depend based on whether the last index was odd or even
            else if(i == N - 1) {
                sumOfEven = pSe[i - 1]; // pSe[N - 2]
                sumOfOdd = pSo[i - 1]; // pSo[N - 2]
            }

            //if any middle element is removed
            // indexes on the left of i remain the same but on the right of i odd becomes even and vice versa
            else {
                sumOfEven = pSe[i - 1] + (pSo[N - 1] - pSo[i]);
                sumOfOdd = pSo[i - 1] + (pSe[N - 1] - pSe[i]);
            }

            if(sumOfEven == sumOfOdd) {
                res++;
            }
        }
        return res;
    }
}
