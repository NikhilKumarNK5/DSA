package Practice.day5;

/*
Problem Description
You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
The equilibrium index of an array is an index such that the sum of elements at lower indexes
is equal to the sum of elements at higher indexes.
If there are no elements that are at lower indexes or at higher indexes,
then the corresponding sum of elements is considered as 0.
Note:
Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.

Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105

Input Format
First argument is an array A .

Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.

Input 1:
A = [-7, 1, 5, 2, -4, 3, 0]
Input 2:
A = [1, 2, 3]

Output 1:
3
Output 2:
-1
*/

public class EquilibriumIndexOfAnArray {
    public int solve(int[] A) {
        int leftSum = 0;
        int totalSum = 0;
        int N = A.length;

        for(int i = 0; i < N; i++) {
            totalSum += A[i];
        }

        for(int i = 0; i < N; i++) {
            int rightSum = totalSum - leftSum - A[i];

            if(leftSum == rightSum) {
                return i;
            }
            leftSum += A[i];
        }
        return -1;
    }
}
