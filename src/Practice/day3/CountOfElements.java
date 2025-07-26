package Practice.day3;

/*
Problem Description
Given an array A of N integers.
Count the number of elements that have at least 1 elements greater than itself.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
First and only argument is an array of integers A.

Output Format
Return the count of elements.

Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]

Output 1:
2
Output 2:
1
*/

public class CountOfElements {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] < max) {
                count++;
            }
        }
        return count;
    }
}
