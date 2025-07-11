package scalar.day6;

/*
Problem Description
Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108

Input Format
There is a single input argument which an integer array A

Output Format
Return an integer array denoting all the leader elements of the array.

Input 1:
 A = [16, 17, 4, 3, 5, 2]
Input 2:
 A = [5, 4]

Output 1:
[17, 2, 5]
Output 2:
[5, 4]
*/

public class LeadersInAnArray {
    public int[] solve(int[] A) {
        int N = A.length;

        // creating an array of size N as we do not know how many leaders are there in the given array
        int[] res = new int[N];
        int count = 0;

        // setting the max as last element since last will always be the leader
        int max = A[N - 1];
        res[count++] = max;

        // looping from end - 1 and check if value is greater than the previous end value and if true
        // we update the max and put the value in res considering it as leader otherwise just continue through the loop
        for(int i = N - 2; i >= 0; i--) {
            if(A[i] > max) {
                res[count++] = A[i];
                max = A[i];
            }
        }

        // creating a new leader array with the exact size of leaders
        // putting the value in reverse order in the new array as initially we put the leader from back to front but we need the output from front to back
        int[] leaders = new int[count];
        for(int i = 0; i < count; i++) {
            leaders[i] = res[count - 1 - i];
        }

        return leaders;
    }
}
