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
    /*
        Dry Run Example:
        Input matrix A:
        [
          [1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]
        ]
        n = 3
        res = new int[2 * n - 1][n] = int[5][3] initialized to all 0

        Main idea:
        - Traverse every element A[row][col]
        - Each element belongs to an anti-diagonal determined by (row + col)
        - Place it in the first available (zero) spot in res[antiDiagonal]

        Iteration details:

        row = 0
          col = 0 → antiDiagonal = 0 → res[0][0] = 1
          col = 1 → antiDiagonal = 1 → res[1][0] = 2
          col = 2 → antiDiagonal = 2 → res[2][0] = 3

        row = 1
          col = 0 → antiDiagonal = 1 → res[1][1] = 4
          col = 1 → antiDiagonal = 2 → res[2][1] = 5
          col = 2 → antiDiagonal = 3 → res[3][0] = 6

        row = 2
          col = 0 → antiDiagonal = 2 → res[2][2] = 7
          col = 1 → antiDiagonal = 3 → res[3][1] = 8
          col = 2 → antiDiagonal = 4 → res[4][0] = 9

        Final res:
        [
          [1, 0, 0],     // anti-diagonal 0
          [2, 4, 0],     // anti-diagonal 1
          [3, 5, 7],     // anti-diagonal 2
          [6, 8, 0],     // anti-diagonal 3
          [9, 0, 0]      // anti-diagonal 4
        ]
    */
    // TC => Worst Case => O(N^3) -> In the worst case, for each ans[antiDiagonal], we scan up to N positions to find an empty spot (a 0)
    // Amortized Time => O(N^2)
    // SC => O(N^2)
    public int[][] diagonal(int[][] A) {
        int n = A.length;

        // Output matrix to hold the diagonals
        int[][] res = new int[2 * n - 1][n];  // There will be 2n - 1 anti-diagonals, each can hold up to n elements

        // Traverse each element in matrix A
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // The sum of row and col gives the anti-diagonal index
                int antiDiagonal = row + col;

                // Find the first available position in that anti-diagonal (skip filled spots)
                int positionInAntiDiagonal = 0;
                while (res[antiDiagonal][positionInAntiDiagonal] != 0) {
                    positionInAntiDiagonal++;
                }

                // Place the current element in its appropriate anti-diagonal position
                res[antiDiagonal][positionInAntiDiagonal] = A[row][col];
            }
        }

        return res;
    }
}
