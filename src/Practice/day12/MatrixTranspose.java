package Practice.day12;

/*
Problem Description
Given a 2D integer array A, return the transpose of A.
The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000

Input Format
First argument is a 2D matrix of integers.

Output Format
You have to return the Transpose of this 2D matrix.

Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:
A = [[1, 2],[1, 2],[1, 2]]

Output 1:
[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:
[[1, 1, 1], [2, 2, 2]]
*/

public class MatrixTranspose {

    // Approach: If we have a square matrix then we can do the transpose in-place but in case of rectangular matrix the number of rows and columns interchange
    // 2 * 3 matrix becomes 3 * 2 so we will be following the approach to create a new matrix with m * n and store the values as per transpose in that
    // TC => O(N * M)
    // SC => O(N * M)
    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] res = new int[m][n];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                res[col][row] = A[row][col];
            }
        }

        return res;
    }
}
