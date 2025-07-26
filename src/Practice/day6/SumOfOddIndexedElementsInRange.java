package Practice.day6;

/*
Problem Description
You are given:
An integer array A representing the array of numbers of size N.
A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1],
representing the range [L, R].
For each query in B, calculate the sum of elements in A at odd indices within the specified range [L, R]
and return the results as an array.

Problem Constraints
1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
1 <= Q <= 10^5
0 <= B[i][0], B[i][1] < N
B[i][0] <= B[i][1].

Input Format
First Argument A, is a list of integers representing the array.
Second Argument B, is a 2D list where each sublist B[i]=[L,R] contains two integers L and R,
representing the range for the query.

Output Format
Return a list of integers where each integer is the result of the sum of elements at
odd indices in the range [L, R] for each query.

Input 1:
A = [2, 8, 3, 9, 15]
B = [ [1, 4],
      [0, 2],
      [2, 3] ]
Input 2:
A = [5, 15, 25, 35, 45]
B = [ [2, 2],
      [2, 4] ]

Output 1:
[17, 8, 9]
Output 2:
[0, 35]
*/

public class SumOfOddIndexedElementsInRange {
    public int[] sumOfOddIndexedElements(int A[], int[][] B) {
        int N = A.length;
        int X = B.length;
        int[] res = new int[X];

        // calculating prefix sum of odd indexed elements
        A[0] = 0;
        for(int i = 1; i < N; i++) {
            if(i % 2 != 0) {
                A[i] = A[i - 1] + A[i];
            } else {
                A[i] = A[i - 1];
            }
        }

        // calculating the sum in range
        for(int i = 0; i < X; i++) {
            int L = B[i][0];
            int R = B[i][1];

            if(L == 0) {
                res[i] = A[R];
            } else {
                res[i] = A[R] - A[L - 1];
            }
        }
        return res;
    }
}
