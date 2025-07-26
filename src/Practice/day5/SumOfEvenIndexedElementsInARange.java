package Practice.day5;

/*
Problem Description
You are given:
An integer array A representing the array of numbers of size N.
A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1],
representing the range [L, R].
For each query in B, calculate the sum of elements in A at EVEN indices within the specified range
[L, R] and return the results as an array.

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
Return a list of integers where each integer is the result of the sum of elements at even indices
in the range [L, R] for each query.

Input 1:
A = [2, 8, 3, 9, 15]
B = [ [1, 4],
      [0, 2],
      [2, 3] ]
Input 2:
A = [5, 15, 25, 35, 45]
B = [ [1, 1],
      [0, 0] ]

Output 1:
[18, 5, 3]
Output 2:
[0, 5]
*/

public class SumOfEvenIndexedElementsInARange {
    public int[] sumOfEvenIndexedElements(int[] A, int[][] B) {

        int N = A.length;
        int res[] = new int[B.length];

        // Prefix sum of Even indexed elements
        for(int i = 1; i < A.length; i++) {
            if(i % 2 == 0) {
                A[i] = A[i - 1] + A[i];
            } else {
                A[i] = A[i-1];
            }
        }

        for(int j = 0; j < B.length; j++) {
            int L = B[j][0];
            int R = B[j][1];

            if(L == 0) {
                res[j] = A[R];
            } else {
                res[j] = A[R] - A[L-1];
            }
        }
        return res;
    }
}
