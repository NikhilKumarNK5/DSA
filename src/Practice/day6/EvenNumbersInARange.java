package Practice.day6;

/*
Problem Description
You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
Each query consists of two integers B[i][0] and B[i][1].
For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].

Problem Constraints
1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 109
0 <= B[i][0] <= B[i][1] < N

Input Format
First argument A is an array of integers.
Second argument B is a 2D array of integers.

Output Format
Return an array of integers.

Input 1:
A = [1, 2, 3, 4, 5]
B = [   [0, 2]
        [2, 4]
        [1, 4]   ]
Input 2:
A = [2, 1, 8, 3, 9, 6]
B = [   [0, 3]
        [3, 5]
        [1, 3]
        [2, 4]   ]

Output 1:
[1, 1, 2]
Output 2:
[2, 1, 1, 1]
*/

public class EvenNumbersInARange {
    public int[] solve(int[] A, int[][] B) {
        int N = A.length;
        int X = B.length;
        int[] res = new int[X];

        // calculating prefix count of even number
        int[] pCount = new int[N];
        if(A[0] % 2 == 0) {
            pCount[0] = 1;
        } else {
            pCount[0] = 0;
        }

        for(int i = 1; i < N; i++) {
            if(A[i] % 2 == 0) {
                pCount[i] = pCount[i - 1] + 1;
            } else {
                pCount[i] = pCount[i - 1];
            }
        }

        // calculating the result
        for(int i = 0; i < X; i++) {
            int L = B[i][0];
            int R = B[i][1];

            if(L == 0) {
                res[i] = pCount[R];
            } else {
                res[i] = pCount[R] - pCount[L - 1];
            }
        }

        return res;
    }
}
