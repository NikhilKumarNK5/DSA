package Practice.day3;

/*
Problem Description
Given an integer array A of size N and an integer B,
you have to return the same array after rotating it B times towards the right.

Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the array A after rotating it B times to the right

Input 1:
A = [1, 2, 3, 4]
B = 2
Input 2:
A = [2, 5, 6]
B = 1

Output 1:
[3, 4, 1, 2]
Output 2:
[6, 2, 5]
*/

public class ArrayRotation {
    public int[] solve(int[] A, int B) {
        int N = A.length;
        B = B % N;
        reverseArray(A, 0, N-1);
        reverseArray(A, 0, B-1);
        reverseArray(A, B, N-1);
        return A;
    }

    public int[] reverseArray(int[] A, int start, int end) {
        while(start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start ++;
            end--;
        }
        return A;
    }
}
