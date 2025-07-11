package scalar.day6;

/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains
at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.

Problem Constraints
1 <= |A| <= 2000

Input Format
First and only argument is vector A

Output Format
Return the length of the smallest subarray which has at least one occurrence of
minimum and maximum element of the array

Input 1:
A = [1, 3, 2]
Input 2:
A = [2, 6, 1, 6, 9]

Output 1:
 2
Output 2:
 3
*/

public class ClosestMinMax {
    public int solve(int[] A) {
        int N = A.length;
        int res = N;
        int min = A[0];
        int max = A[0];

        // finding min and max elements in the array
        for(int i = 0; i < N; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int[] lastMin = new int[N];
        int[] lastMax = new int[N];

        if(A[0] != min) {
            lastMin[0] = -1;
        }
        if(A[0] != max) {
            lastMax[0] = -1;
        }

        // storing the indices of closest min and closest max
        for(int i = 1; i < N; i++) {
            if(A[i] < min) {
                lastMin[i] = i;
            } else {
                lastMin[i] = lastMin[i - 1];
            }
            if(A[i] > max) {
                lastMax[i] = i;
            } else {
                lastMax[i] = lastMax[i - 1];
            }
        }

        // finding length throughout the elements if lastMin and lastMax indices exist
        for(int i = 0; i < N; i++) {
            if(lastMin[i] != -1 && lastMax[i] != -1) {
                int start = Math.min(lastMin[i], lastMax[i]);
                int end = Math.max(lastMin[i], lastMax[i]);
                int len = end - start + 1;
                res = Math.min(res, len); // calculating the minimum length
            }
        }
        return res;
    }
}
