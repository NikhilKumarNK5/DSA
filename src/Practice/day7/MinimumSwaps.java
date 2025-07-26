package Practice.day7;

/*
Problem Description
Given an array of integers A and an integer B, find and return the minimum number of swaps
required to bring all the numbers less than or equal to B together.
Note: It is possible to swap any two elements, not necessarily consecutive.

Problem Constraints
1 <= length of the array <= 100000
-10^9 <= A[i], B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the minimum number of swaps.

Input 1:
 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
Input 2:
 A = [5, 17, 100, 11]
 B = 20

Output 1:
 2
Output 2:
 1
*/

public class MinimumSwaps {
    // Approach - Using Sliding window technique
    public int solve(int[] A, int B) {
        int count = 0; // to get the total count of elements less than equal to B

        // get the total no of elements which are less than equal to B
        for(int i = 0; i < A.length; i++) {
            if(A[i] <= B) {
                count++;
            }
        }

        int windowSize = count;
        int badNos = 0; // numbers which are greater than B

        // checking the badNos for the first window
        for(int i = 0; i < windowSize; i++) {
            if(A[i] > B) {
                badNos++;
            }
        }

        int result = badNos;
        int start = 0;
        int end = windowSize;

        // slide for rest of the window
        // we are taking the min swaps based on badNos as the minimum swaps depend on how many bad nos are present and where they are present
        while(end < A.length) {
            if(A[start] > B) {
                badNos--;
            }
            if(A[end] > B) {
                badNos++;
            }
            result = Math.min(result, badNos);
            start++;
            end++;
        }
        return result;
    }
}
