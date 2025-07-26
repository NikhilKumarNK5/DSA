package Practice.day7;

/*
Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which
we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.
Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.

Problem Constraints
1 <= N <= 105
1 <= Ai <= 10 4

Input Format
The first argument is the integer array A.

Output Format
Return a single integer denoting the sum of all subarray sums of the given array.

Input 1:
A = [1, 2, 3]
Input 2:
A = [2, 1, 3]

Output 1:
20
Output 2:
19
*/

public class SumOfAllSubarrays {
    // Approach 1 - finding all the subarrays and adding them
    // TC => O(N^3)
    public long subarraySum(int[] A) {
        long ans = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i; j < A.length; j++) {
                long sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += A[k];
                }
                ans += sum;
            }
        }
        return ans;
    }

    // Approach 2 - Carry Forward technique
    // outer loop will track the index
    // inner loop will track the sum of each subarray and the final sum
    // TC => O(N^2)
    public long subarraySumCarryForward(int[] A) {
        long ans = 0;
        for(int i = 0; i < A.length; i++) {
            long sum = 0;
            for(int j = i; j < A.length; j++) {
                sum += A[j];
                ans += sum;
            }
        }
        return ans;
    }

    // Approach 3 - Using Contribution technique
    // We can find out the contribution of each element in the total sum
    // TC => O(N)
    // how to calculate the occurrence of each element
    // for any index i
    // for any subarray to contain i it should start from either 0 till i and end at i till N - 1
    // so possible start indices would be from 0 to i which are in total i + 1 (i - 0 + 1)
    // possible end indices would be from i to N - 1 which in total is n - i (n - 1 - i + 1)
    // occurrence of each element = (i + 1) * (n - i)
    // contribution of each element = occurrence * element
    public long subarraySumContributionTechnique(int[] A) {
        int N = A.length;
        long ans = 0;
        for(int i = 0; i < N; i++) {
            long occurrence = (i + 1) * (N - i);
            long contribution = occurrence * A[i];
            ans += contribution;
        }
        return ans;
    }
}
