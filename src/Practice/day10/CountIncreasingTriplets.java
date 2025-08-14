package Practice.day10;

/*
Problem Description
You are given an array A of N elements. Find the number of triplets i,j and k
such that i<j<k and A[i]<A[j]<A[k]

Problem Constraints
1 <= N <= 10^3
1 <= A[i] <= 10^9

Input Format
First argument A is an array of integers.

Output Format
Return an integer.

Input 1:
A = [1, 2, 4, 3]
Input 2:
A = [2, 1, 2, 3]

Output 1:
2
Output 2:
1
*/

public class CountIncreasingTriplets {
    // Approach 1: Brute Force - check all possible i, j, k combinations using 3 loops
    // TC => O(N^3)
    public int solve(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] < A[j] && A[j] < A[k])
                        count++;
                }
            }
        }
        return count;
    }

    // Approach 2: Fixing the middle element and counting the elements less than it on left and greater than it on right
    // Sum of Product of two gives the result
    /*
        A = [1, 2, 3, 4]
        Initial:
        res = 0
        A.length = 4

        j = 1, A[j] = 2
        --------------------------------
        left = 0
           i = 0 → A[0] = 1 < 2 → left = 1
        right = 0
           k = 2 → A[2] = 3 > 2 → right = 1
           k = 3 → A[3] = 4 > 2 → right = 2
        res += left * right = 1 * 2 = 2
        res = 2

        j = 2, A[j] = 3
        --------------------------------
        left = 0
           i = 0 → A[0] = 1 < 3 → left = 1
           i = 1 → A[1] = 2 < 3 → left = 2
        right = 0
           k = 3 → A[3] = 4 > 3 → right = 1
        res += left * right = 2 * 1 = 2
        res = 4

        j = 3, A[j] = 4
        --------------------------------
        left = 0
           i = 0 → A[0] = 1 < 4 → left = 1
           i = 1 → A[1] = 2 < 4 → left = 2
           i = 2 → A[2] = 3 < 4 → left = 3
        right = 0
           (No k values since j+1 = 4 is out of range)
        res += left * right = 3 * 0 = 0
        res = 4

        Final result = 4
        Triplets: (1,2,3), (1,2,4), (1,3,4), (2,3,4)
     */
    // TC => O(N^2)
    public int solveOptimized(int[] A) {
        int res = 0;
        for(int j = 1; j < A.length; j++) {
            int left = 0;
            int right = 0;
            for(int i = 0; i < j; i++) {
                if(A[i] < A[j])
                    left++;
            }
            for(int k = j + 1; k < A.length; k++) {
                if(A[j] < A[k])
                    right++;
            }
            res += left * right;
        }
        return res;
    }
}
