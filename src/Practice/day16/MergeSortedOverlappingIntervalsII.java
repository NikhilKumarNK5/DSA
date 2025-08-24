package Practice.day16;

/*
Problem Description
You are given a collection of intervals A in a 2-D array format,
where each interval is represented by a pair of integers `[start, end]`.
The intervals are sorted based on their start values.
Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.

Problem Constraints
1 <= len(A) <= 100000.
1 <= A[i][0] <= A[i][1] <= 100000
A is sorted based on the start value (A[i][0])

Input Format
First argument is a list of intervals in 2-Dimensional Array.

Output Format
Return the sorted list of intervals after merging all the overlapping intervals.

Input 1:
[ [1, 3], [2, 6], [8, 10], [15, 18] ]
Input 2:
[ [2, 10], [4, 9], [6, 7] ]

Output 1:
[ [1, 6], [8, 10], [15, 18] ]
Output 2:
[ [2, 10] ]
*/

import java.util.ArrayList;

public class MergeSortedOverlappingIntervalsII {

    // Approach: Since it's already sorted based on start time we can directly just merge checking the values of current start with previous end and keep updating the intervals and adding to the list
    // TC => O(N)
    public int[][] solve(int[][] A) {
        ArrayList<int[]> res = new ArrayList<>();
        int currStart = A[0][0];
        int currEnd = A[0][1];

        for(int i = 1; i < A.length; i++) {
            if(A[i][0] <= currEnd) {
                currEnd = Math.max(currEnd, A[i][1]);
            } else {
                res.add(new int[]{currStart, currEnd});
                currStart = A[i][0];
                currEnd = A[i][1];
            }
        }
        res.add(new int[] {currStart, currEnd});

        return res.toArray(new int[res.size()][]);
    }
}
