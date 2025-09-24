package Practice.day29;

/*
Problem Description
Given an integer A representing the number of square blocks.
The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
The first stair would require only one block, and the second stair would require two blocks, and so on.
Find and return the maximum height of the staircase.

Problem Constraints
0 <= A <= 10^9

Input Format
The only argument given is integer A.

Output Format
Return the maximum height of the staircase using these blocks.

Input 1:
 A = 10

Input 2:
 A = 20

Output 1:
 4

Output 2:
 5

Explanation 1:
 The stairs formed will have height 1, 2, 3, 4.

Explanation 2:
 The stairs formed will have height 1, 2, 3, 4, 5.
*/

public class MaximumHeightOfStaircase {

    // Approach: Binary Search from 0 to A and store the result and move
    // find sum using n * (n+1)/2 and compare with A and if the sum is less or equal then store n as res and move right to find next greater smallest value
    // TC => O(LogN)
    // SC => O(1)
    public int solve(int A) {
        int low = 0;
        int high = A;
        int res = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            long sum = (long) mid * (mid + 1) / 2;

            if(sum <= A) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
