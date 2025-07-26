package Practice.day8;

/*
Problem Description
Given an integer array A of size N.
Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
A sequence of numbers is called an arithmetic progression if the difference between any
two consecutive elements is the same.

Problem Constraints
2 <= N <= 10^5
-10^9 <= A[i] <= 10^9

Input Format
The first and only argument is an integer array A of size N.

Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.

Input 1:
 A = [3, 5, 1]
Input 2:
 A = [2, 4, 1]

Output 1:
 1
Output 2:
 0
*/

import java.util.Arrays;

public class ArithmeticProgression {

    // to calculate the common difference we need to sort the array in either ascending or descending
    // then we can compare each common difference
    // TC => O(NLogN)
    public int solve(int[] A) {
        Arrays.sort(A);
        int cd = A[1] - A[0];
        int count = 0;
        for(int i = 1; i < A.length; i++) {
            if((A[i] - A[i - 1]) == cd) {
                count++;
            }
        }
        if(count == A.length - 1)
            return 1;
        return 0;
    }
}
