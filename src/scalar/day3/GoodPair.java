package scalar.day3;

/*
Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and
(A[i] + A[j] == B). Check if any good pair exist or not.

Problem Constraints
1 <= A.size() <= 104
1 <= A[i] <= 109
1 <= B <= 109

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return 1 if good pair exist otherwise return 0.

Input 1:
A = [1,2,3,4]
B = 7
Input 2:
A = [1,2,4]
B = 4
Input 3:
A = [1,2,2]
B = 4

Output 1:
1
Output 2:
0
Output 3:
1
*/

import java.util.HashMap;

public class GoodPair {
    // Approach one - Brute Force -> TC => O(N^2)
    public int solve(int[] A, int B) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 1; j < A.length; j++) {
                if(i != j && (A[i] + A[j] == B)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // Approach two - HashMap -> TC => O(N)
    public int TwoSum(int[] A, int B) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            int diff = B - A[i];
            if(hs.containsKey(diff))
                return 1;
            else {
                hs.put(A[i], i);
            }
        }
        return 0;
    }
}
