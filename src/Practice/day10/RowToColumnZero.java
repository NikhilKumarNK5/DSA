package Practice.day10;

/*
Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
Specifically, make entire ith row and jth column zero.

Problem Constraints
1 <= A.size() <= 10^3
1 <= A[i].size() <= 10^3
0 <= A[i][j] <= 10^3

Input Format
First argument is a 2D integer matrix A.

Output Format
Return a 2D matrix after doing required operations.

Input 1:
[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

Output 1:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]

*/

public class RowToColumnZero {

    // Approach 1: Here since the given matrix only holds positive values, so we can use -1 to mark the rows and cols to be set as 0
    // Once we find a 0, we mark the corresponding row and col values as -1 whenever there isn't any 0
    // After all the marking is complete we update the matrix (where -1 set to 0)
    // TC => O(N * M)
    // SC => O(1) -> InPlace modification
    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        for(int row = 0; row < n; row++) {
            for(int column = 0; column < m; column++) {
                if(A[row][column] == 0){
                    for(int r = 0; r < n; r++){
                        if(A[r][column] != 0) {
                            A[r][column] = -1;
                        }
                    }
                    for(int c = 0; c < m; c++) {
                        if(A[row][c] != 0) {
                            A[row][c] = -1;
                        }
                    }
                }
            }
        }

        for(int row = 0; row < n; row++) {
            for(int column = 0; column < m; column++) {
                if(A[row][column] == -1) {
                    A[row][column] = 0;
                }
            }
        }

        return A;
    }

    // Approach 2: If we have a situation where we can have both the negative and positive elements in the matrix
    // We will use the first row and first column as a flag to mark the zeroes
    // TC => O(N * M)
    // SC => O(1) - in place marking
    public int[][] solveZeroes(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        boolean firstColZero = false;
        boolean firstRowZero = false;

        // checking if the first col has any zeroes
        for(int r = 0; r < n; r++) {
            if(A[r][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // checking if the first row has any zeroes
        for(int c = 0; c < m; c++) {
            if(A[0][c] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // using the first row and first column to mark the zeroes
        for(int row = 1; row < n; row++) {
            for(int col = 1; col < m; col++) {
                if(A[row][col] == 0) {
                    A[row][0] = 0;
                    A[0][col] = 0;
                }
            }
        }

        // using the markers to set zeroes in the matrix
        for(int row = 1; row < n; row++) {
            for(int col = 1; col < m; col++) {
                if(A[row][0] == 0 || A[0][col] == 0)
                    A[row][col] = 0;
            }
        }

        // if the first col has zeroes then set the entire col to 0
        if(firstColZero) {
            for(int r = 0; r < n; r++) {
                A[r][0] = 0;
            }
        }

        // if the first row has zeroes then set the entire row to 0
        if(firstRowZero) {
            for(int c = 0; c < m; c++) {
                A[0][c] = 0;
            }
        }

        return A;
    }
}
