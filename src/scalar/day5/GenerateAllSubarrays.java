package scalar.day5;

/*
Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array
Note : The order of the subarrays in the resulting 2D array does not matter.

Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105

Input Format
First argument A is an array of integers.

Output Format
Return a 2D array of integers in any order.

Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]

Example Output
Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
*/

public class GenerateAllSubarrays {
    public int[][] solve(int[] A) {
        int N = A.length;

        // total no of subarrays that can be generated
        int total = N * (N + 1) / 2;
        int[][] result = new int[total][];
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int size = j - i + 1; // each subarray size
                int[] subarray = new int[size]; // creating an array to create each subarray

                // storing the values in subarray
                for (int k = 0; k < size; k++) {
                    subarray[k] = A[i + k];
                }

                // storing the subarray in the 2D array
                result[index++] = subarray;
            }
        }
        return result;
    }
}
