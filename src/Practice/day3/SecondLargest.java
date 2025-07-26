package Practice.day3;

/*
Problem Description
You are given an integer array A. You have to find the second-largest element/value in the array
or report that no such element exists.

Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 109

Input Format
The first argument is an integer array A.

Output Format
Return the second-largest element. If no such element exist then return -1.

Input 1:
 A = [2, 1, 2]
Input 2:
 A = [2]

Output 1:
 1
Output 2:
 -1
*/

public class SecondLargest {
    public int solve(int[] A) {
        int max = -1;
        int secondMax = -1;
        if(A.length == 1)
            return -1;
        else {
            for(int i = 0; i < A.length; i++) {
                if(A[i] > max) {
                    secondMax = max;
                    max = A[i];
                }
                else if(A[i] > secondMax && A[i] != max) {
                    secondMax = A[i];
                }
            }
        }
        return secondMax;
    }
}
