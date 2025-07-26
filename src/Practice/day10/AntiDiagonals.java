package Practice.day10;

/*
Problem Description
Given a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9

Input Format
Only argument is a 2D array A of size N * N.

Output Format
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.

Input 1:
1 2 3
4 5 6
7 8 9
Input 2:
1 2
3 4

Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:
1 0
2 3
4 0
*/

public class AntiDiagonals {
    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] res = new int[2 * n - 1][n];

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {

            }
        }

        return res;
    }
}
