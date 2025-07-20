package scalar.day10;

/*
Problem Description
You are given a 2D matrix A of integers.
Your task is to compute the sum of elements in each row and
return a 1D array where each element represents the sum of a corresponding row in the matrix.

Problem Constraints
1 <= A.size() <= 10^3
1 <= A[i].size() <= 10^3
1 <= A[i][j] <= 10^3

Input Format
First argument A is a 2D array of integers.(2D matrix).

Output Format
Return an array containing row-wise sums of original matrix.

Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

Output 1:
[10,26,18]
*/

public class RowSum {
    // Approach: Loop through all the rows and add the columns
    // TC => O(N^2)
    public int[] solve(int[][] A) {
        int[] res = new int[A.length];
        for(int row = 0; row < A.length; row++) {
            int sum = 0;
            for(int col = 0; col < A[row].length; col++) {
                sum += A[row][col];
            }
            res[row] = sum;
        }
        return res;
    }
}
