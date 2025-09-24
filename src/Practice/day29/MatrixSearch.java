package Practice.day29;

/*
Problem Description
Given a matrix of integers A of size N x M and an integer B.
Write an efficient algorithm that searches for integer B in matrix A.
This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
NOTE: Rows are numbered from top to bottom, and columns are from left to right.

Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6

Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.

Output Format
Return 1 if B is present in A else, return 0.

Input 1:
A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3

Input 2:
A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3

Output 1:
1

Output 2:
0

Explanation 1:
 3 is present in the matrix at A[0][1] position so return 1.

Explanation 2:
 3 is not present in the matrix so return 0.
*/

public class MatrixSearch {

    // Approach 1: Staircase Method - start from top right corner and move left if B is less than current value and move bottom if B is greater than current
    // TC => O(N + M)
    // SC => O(1)
    public int searchMatrix(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        // start from top right corner
        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0) {
            if(A[row][col] == B)
                return 1;
            else if(A[row][col] > B)
                col--;
            else
                row++;
        }
        return 0;
    }

    // Approach 2: Binary Search - treat the matrix as a flat array and apply binary search logic
    // TC => O(LogN)
    // SC => O(1)
    public int searchMatrixBinarySearch(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        int low = 0;
        int high = n * m - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if(A[row][col] == B)
                return 1;
            else if(A[row][col] < B)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }
}
