package scalar.day8;

/*
Problem Description
Given an integer array A, find if an integer p exists in the array
such that the number of integers greater than p in the array equals p.

Problem Constraints
1 <= |A| <= 2*10^5
-108 <= A[i] <= 10^8

Input Format
First and only argument is an integer array A.

Output Format
Return 1 if any such integer p is present else, return -1.

Input 1:
 A = [3, 2, 1, 3]
Input 2:
 A = [1, 1, 3, 3]

Output 1:
 1
Output 2:
 -1
*/

import java.util.ArrayList;
import java.util.Collections;

public class NobleIntegers {
    // Approach 1: Brute force
    // for each element checking the number of elements greater than itself
    // TC => O(N^2)
    public int solve(int[] A) {
        for(int i = 0; i < A.length; i++) {
            int count = 0;
            for(int j = 0; j < A.length; j++) {
                if(A[j] > A[i])
                    count++;
            }
            if(count == A[i]) {
                return 1;
            }
        }
        return -1;
    }

    // Approach 2: using sorting
    // reverse sort the array and compare
    // TC => O(nLogn)
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int count = 0; // storing the index to check
        if(A.get(0) == 0) return 1; // if first element is 0 then there exists no element greater than it as it is reverse sorted
        for(int i = 1; i < A.size(); i++) {
            if(A.get(i) != A.get(i - 1)) {
                count = i; // if the element is not equal to previous then we can update the index
            }
            if(A.get(i) == count) {
                return 1; // if the index and element is equal that means it is noble
            }
            // [3, 3, 2, 1] -> 2 index is 2, and it has 2 elements greater than itself
        }
        return -1;
    }
}
