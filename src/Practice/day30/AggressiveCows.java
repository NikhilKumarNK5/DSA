package Practice.day30;

/*
Problem Description
Farmer John has built a new long barn with N stalls.
Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible.
What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 10^9
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

Input 1:
A = [1, 2, 3, 4, 5]
B = 3

Input 2:
A = [1, 2]
B = 2

Output 1:
 2

Output 2:
 1

Explanation 1:
 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively.
 So the minimum distance will be 2.

Explanation 2:
 The minimum distance will be 1.
*/

import java.util.Arrays;

public class AggressiveCows {

    // Approach: Binary Search on Answer
    // choose best and worst case to find the search space
    // worst case -> cows = N -> minimum distance of any two consecutive elements (I am considering 1 as minimum possible distance)
    // best case -> only one cow -> minimum distance = A[n-1] - A[0]
    // TC => O(NlogN)
    // SC => O(1)
    public int solve(int[] A, int B) {
        // need to sort the array first if it is not sorted
        Arrays.sort(A);

        int n = A.length;
        int low = 1; // minimum possible distance
        int high = A[n - 1] - A[0]; // maximum possible distance
        int res = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canPlace(A, B, mid)) {
                res = mid; // mid is valid
                low = mid + 1; // try to maximize the distance
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private boolean canPlace(int[] A, int cows, int distance) {
        int c = 1; // using 1 cow to begin with - first cow placed in first stall
        int lastPlaced = A[0]; // the place were first cow is placed

        for(int i = 1; i < A.length; i++) {
            if(A[i] - lastPlaced >= distance) { // if the current distance is greater or equal then place another cow
                c++;
                lastPlaced = A[i];
                if(c == cows)
                    return true; // all cows are placed
            }
        }
        return false; // all cows were not placed
    }
}
