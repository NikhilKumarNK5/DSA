package scalar.day5;

/*
Problem Description
Given an array A of length N, return the subarray from B to C.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
0 <= B <= C < N

Input Format
The first argument A is an array of integers
The remaining argument B and C are integers.

Output Format
Return a subarray

Input 1:
A = [4, 3, 2, 6]
B = 1
C = 3
Input 2:
A = [4, 2, 2]
B = 0
C = 1

Output 1:
[3, 2, 6]
Output 2:
[4, 2]
*/

public class SubArrayInAGivenRange {
    public int[] solve(int[] A, int B, int C) {
        // size of the result array
        int size = C - B + 1;
        int res[] = new int[size];
        for(int i = 0; i < size ; i++) {
            res[i] = A[B + i];
        }
        return res;
    }
}

/*
Dry run for Input 1:
A = [4, 3, 2, 6]
B = 1
C = 3

size = 3 - 1 + 1  = 3
res[0] = A[1 + 0] = 3
res[1] = A[1 + 1] = 2
res[2] = A[1 + 2] = 6
--> Output - [3, 2, 6]
*/
