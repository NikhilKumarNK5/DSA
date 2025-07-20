package scalar.day10;

/*
Problem Description
You are given a 2D integer matrix A,
return a 1D integer array containing column-wise sums of original matrix.

Problem Constraints
1 <= A.size() <= 10^3
1 <= A[i].size() <= 10^3
1 <= A[i][j] <= 10^3

Input Format
First argument is a 2D array of integers.(2D matrix).

Output Format
Return an array containing column-wise sums of original matrix.

Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

Output 1:
{15,10,13,16}
*/

public class ColumnSum {
    // Approach - Loop though each column and add the element present in the row
    // TC => O(N^2)
    public int[] solve(int[][] A) {
        int[] res = new int[A[0].length];
        for(int col = 0; col < A[0].length; col++) {
            int sum = 0;
            for(int row = 0; row < A.length; row++) {
                sum += A[row][col];
            }
            res[col] = sum;
        }
        return res;
    }
}
