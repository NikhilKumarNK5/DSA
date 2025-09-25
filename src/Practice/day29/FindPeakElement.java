package Practice.day29;

/*
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors.
For corner elements, we need to consider only one neighbor.

NOTE:
It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

Input 1:
A = [1, 2, 3, 4, 5]

Input 2:
A = [5, 17, 100, 11]

Output 1:
 5

Output 2:
 100

Explanation 1:
 5 is the peak.

Explanation 2:
 100 is the peak.
*/

public class FindPeakElement {

    // Approach 1: Max element will always be peak - find max and return
    // TC => O(N)
    // SC => O(1)
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for(int ele : A) {
            max = Math.max(max, ele);
        }
        return max;
    }

    // Approach 2: Binary Search on Answer
    // TC => O(LogN)
    // SC => O(1)
    public int solveBS(int[] A) {
        int n = A.length;

        if(n == 1 || A[0] >= A[1])
            return A[0];
        if(A[n - 1] >= A[n - 2])
            return A[n - 1];

        int low = 1;
        int high = n - 2;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1])
                return A[mid];
            else if(A[mid - 1] > A[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
