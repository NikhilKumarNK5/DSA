package scalar.day8;

/*
Problem Description
Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.
Find the minimum cost to remove all elements from the array.

Problem Constraints
0 <= N <= 1000
1 <= A[i] <= 10^3

Input Format
First and only argument is an integer array A.

Output Format
Return an integer denoting the total cost of removing all elements from the array.

Input 1:
 A = [2, 1]
Input 2:
 A = [5]

Output 1:
 4
Output 2:
 5
*/

import java.util.ArrayList;
import java.util.Collections;

public class ElementsRemoval {
    // Sorting and calculating the final cost using element contribution
    // [a, b, c, d] => a > b > c > d
    // (a + b + c + d) + (b + c + d) + (c + d) + (d) => a + 2b + 3c + 4d
    // => a(i+1) + b(i+1) + c(i+1) + d(i+1)
    // TC => O(NLogN)
    public int solve(ArrayList<Integer> A) {
        int finalCost = 0;
        Collections.sort(A, Collections.reverseOrder());
        for(int i = 0; i < A.size(); i++) {
            finalCost += A.get(i) * (i + 1);
        }
        return finalCost;
    }
}
