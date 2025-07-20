package scalar.day10;

/*
Problem Description
You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.

Problem Constraints
1 <= N <= 10^3
-1000 <= A[i][j] <= 1000

Input Format
There are 1 lines in the input. First 2 integers R, C are the number of rows and columns.
Then R * C integers follow corresponding to the rowwise numbers in the 2D array A.

Output Format
Return an integer denoting the sum of main diagonal elements.

Input 1:
3 3 1 -2 -3 -4 5 -6 -7 -8 9
Input 2:
2 2 3 2 2 3

Output 1:
 15
Output 2:
 6
*/

public class MainDiagonalSum {
    // Approach 1: Brute force - To calculate the main diagonal sum
    // Can loop through both row and columns and add the diagonals
    // For main diagonals only add when the row == column
    // TC => O(N^2)
    public int solve(final int[][] A) {
        int sum = 0;
        for(int row = 0; row < A.length; row++) {
            for(int col = 0; col < A[row].length; col++) {
                if(row == col) {
                    sum += A[row][col];
                }
            }
        }
        return sum;
    }

    // Approach 2: Optimized
    // Instead of looping twice we can use one loop and keep the sum of all the elements where both row and col are equal
    // A[row][row]
    // TC => O(N)
    public int solveAntiDiagonal(final int[][] A) {
        int sum = 0;
        for(int row = 0; row < A.length; row++) {
            sum += A[row][row];
        }
        return sum;
    }
}
