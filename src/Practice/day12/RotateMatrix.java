package Practice.day12;

/*
Problem Description
You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note: If you end up using an additional array, you will only receive partial score.

Problem Constraints
1 <= n <= 1000

Input Format
First argument is a 2D matrix A of integers

Output Format
Return the 2D rotated matrix.

Input 1:
 [
    [1, 2],
    [3, 4]
 ]
Input 2:

 [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
 ]

Output 1:
 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [7, 4, 1],
    [8, 5, 2],
    [9, 6, 3]
 ]
*/

public class RotateMatrix {

    // Approach: Since the ask is to do it in place, we cannot use a new matrix so need to transpose and reverse each row to obtain the result
    // In-place approach only works if the given matrix is square
    // TC => O(N^2)
    public void solve(int[][] A) {
        int n = A.length;

        // transpose of the matrix
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(row < col) {
                    int temp = A[row][col];
                    A[row][col] = A[col][row];
                    A[col][row] = temp;
                }
            }
        }

        // reverse each row
        for(int row = 0; row < n; row++) {
            int start = 0;
            int end = n - 1;
            while(start < end) {
                int temp = A[row][start];
                A[row][start] = A[row][end];
                A[row][end] = temp;
                start++;
                end--;
            }
        }
    }
}
