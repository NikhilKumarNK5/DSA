package Practice.day7;

/*
Problem Description
Given an array of integers A,
a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.

Problem Constraints
1 <= len(A) <= 5 x 10^3
1 <= A[i] <= 10^3
1 <= B <= 10^7

Input Format
The first argument given is the integer array A.
The second argument given is an integer B.

Output Format
Return the count of good subarrays in A.

Input 1:
A = [1, 2, 3, 4, 5]
B = 4
Input 2:
A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65

Output 1:
6
Output 2:
36
*/

public class GoodSubarray {

    // Checking the sum of each subarray and the length of each subarray and comparing
    // TC => O(N^2)
    public int solve(int[] A, int B) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            int sum = 0; // setting sum as 0 to calculate sum of each subarray and not sum all
            for(int j = i; j < A.length; j++) {
                sum += A[j];

                int lengthOfSubarray = j - i + 1;
                if((lengthOfSubarray % 2 == 0 && sum < B) || (lengthOfSubarray % 2 != 0 && sum > B)) {
                    count++;
                }
            }
        }
        return count;
    }
}
