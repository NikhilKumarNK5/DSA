package Practice.day29;

/*
Problem Description
Given a sorted array of integers A (0-indexed) of size N,
find the left most and the right most index of a given integer B in the array A.
Return an array of size 2, such that
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].
Note : Note: The time complexity of your algorithm must be O(log n)..

Problem Constraints
1 <= N <= 10^6
1 <= A[i], B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array.
If B is not found in A, return [-1, -1].

Input 1:
 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:
 A = [5, 17, 100, 111]
 B = 3

Output 1:
 [3, 4]
Output 2:
 [-1, -1]

Explanation 1:
 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:
 There is no occurrence of 3 in the array.
*/

public class SearchForARange {

    // Approach: Find the first and last occurrence using Binary Search and store the result in an array
    // TC => O(LogN)
    // SC => O(1)
    public int[] searchRange(final int[] A, int B) {
        int[] res = new int[2];
        res[0] = searchFirst(A, B);
        res[1] = searchLast(A, B);
        return res;
    }

    private int searchFirst(int[] A, int B) {
        int first = -1;
        int low = 0;
        int high = A.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == B) {
                first = mid;
                high = mid - 1;
            } else if(A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private int searchLast(int[] A, int B) {
        int last = -1;
        int low = 0;
        int high = A.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == B) {
                last = mid;
                low = mid + 1;
            } else if(A[mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
}
