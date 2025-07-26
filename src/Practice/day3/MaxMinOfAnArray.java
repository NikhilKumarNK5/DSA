package Practice.day3;

/*
Problem Description
Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.

Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109

Input Format
First argument A is an integer array.

Output Format
Return the sum of maximum and minimum element of the array

Input 1:
A = [-2, 1, -4, 5, 3]
Input 2:
A = [1, 3, 4, 1]

Output 1:
1
Output 2:
5
*/

public class MaxMinOfAnArray {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int length = A.length;
        int sum = 0;
        for(int i = 0; i < length; i ++ ){
            if(A[i] < min) {
                min = A[i];
            }
            if(A[i] > max) {
                max = A[i];
            }
        }
        sum = min + max;
        return sum;
    }
}
