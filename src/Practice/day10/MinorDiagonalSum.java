package Practice.day10;

/*
Problem Description
You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
Minor diagonal of a M X M matrix A is a collection of elements A[i, j]
such that i + j = M + 1 (where i, j are 1-based).

Problem Constraints
1 <= N <= 10^3
-1000 <= A[i][j] <= 1000

Input Format
First and only argument is a 2D integer matrix A.

Output Format
Return an integer denoting the sum of minor diagonal elements.

Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
Input 2:
 A = [[3, 2],
      [2, 3]]

Output 1:
 -5
Output 2:
 4
*/

public class MinorDiagonalSum {

    // Approach 1: According to the question the input is square matrix
    // Loop and find the sum
    // TC => O(N^2)
    public int solve(final int[][] A) {
        int m = A.length;
        int sum = 0;
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < m; col++) {
                if(((row + 1) + (col + 1)) == m + 1) { // since it is given that i and j are 1 based
                    sum += A[row][col];
                }
            }
        }
        return sum;
    }
}
