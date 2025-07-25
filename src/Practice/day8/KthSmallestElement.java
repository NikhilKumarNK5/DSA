package Practice.day8;

/*
Problem Description
Find the Bth smallest element in given array A .
NOTE: Users should try to solve it in less than equal to B swaps.

Problem Constraints
1 <= |A| <= 100000
1 <= B <= min(|A|, 500)
1 <= A[i] <= 10^9

Input Format
The first argument is an integer array A.
The second argument is integer B.

Output Format
Return the Bth smallest element in given array.

Input 1:
A = [2, 1, 4, 3, 2]
B = 3
Input 2:
A = [1, 2]
B = 2

Output 1:
 2
Output 2:
 2
*/

import java.util.Arrays;

public class KthSmallestElement {
    // Approach is to sort the array in ascending and return the (B-1)th element
    // TC => O(nLogn)
    public int kthsmallest(final int[] A, int B) {
        int[] check = A; // since A is final and cannot be modified
        Arrays.sort(check);

        return check[B - 1];
    }
}
