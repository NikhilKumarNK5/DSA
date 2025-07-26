package Practice.day5;

/*
Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
0 <= L <= R < N

Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.

Output Format
Return an integer array of length M where ith element is the answer for ith query in B.

Input 1:
A = [1, 2, 3, 4, 5]
B = [[0, 3], [1, 2]]
Input 2:
A = [2, 2, 2]
B = [[0, 0], [1, 2]]

Output 1:
[10, 5]
Output 2:
[2, 4]
*/

public class RangeSumQuery {
    public long[] rangeSum(int[] A, int[][] B) {

        int N = A.length;
        long[] pSum = new long[A.length];
        pSum[0] = A[0];

        // creating prefix sum of A [1, 3, 6, 10, 15]
        for(int i = 1; i < N; i++) {
            pSum[i] = pSum[i-1] + A[i];
        }

        long[] res = new long[B.length];

        for(int j = 0; j < B.length; j++) {
            int L = B[j][0];
            int R = B[j][1];

            if(L == 0) {
                res[j] = pSum[R]; // [0, 3] - [pSum[R] -> pSum[3] -> 10]
            } else {
                res[j] = pSum[R] - pSum[L-1]; // [1, 2] - [pSum[2] - pSum[1-1] -> 6 - 1 -> 5]
            }
        }
        return res;
    }
}
