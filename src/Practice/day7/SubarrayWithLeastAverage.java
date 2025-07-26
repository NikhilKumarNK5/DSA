package Practice.day7;

/*
Problem Description
Given an array A of size N, find the subarray of size B with the least average.

Problem Constraints
1 <= B <= N <= 10^5
-10^5 <= A[i] <= 10^5

Input Format
First argument contains an array A of integers of size N.
Second argument contains integer B.

Output Format
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.

Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:
A = [3, 7, 5, 20, -10, 0, 12]
B = 2

Output 1:
3
Output 2:
4
*/

public class SubarrayWithLeastAverage {
    // Approach - Sliding Window - since we have an array of size B that is fixed
    public int solve(int[] A, int B) {
        int sum = 0; // least sum means least avg
        int resultIndex = 0; // taking it has 0 as for the case where the first window has the least average has the firstIndex as 0 and also the min size of array is 1

        // calculating sum of first window
        for(int i = 0; i < B; i++) {
            sum += A[i];
        }

        int minSum = sum; // at the start setting the minSum equal to our sum of first window

        // for sliding through the window
        int start = 1; // next window begins from 1st index
        int end = B; // goes to Bth index

        while(end < A.length) {
            sum = sum - A[start - 1] + A[end]; // removing the element from left and adding from right
            if(sum < minSum) { // if the current sum is less we update the minSum and also the resultIndex
                resultIndex = start;
                minSum = sum;
            }
            start++;
            end++;
        }
        return resultIndex;
    }
}
