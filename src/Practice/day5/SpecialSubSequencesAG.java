package Practice.day5;

/*
Problem Description
You have given a string A having Uppercase English letters.
You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.

Problem Constraints
1 <= length(A) <= 105

Input Format
First and only argument is a string A.

Output Format
Return an long integer denoting the answer.

Input 1:
 A = "ABCGAG"
Input 2:
 A = "GAB"

Output 1:
 3
Output 2:
 0

*/

public class SpecialSubSequencesAG {

    // Approach 1 - Brute Force
    public long bruteForceSolve(String A) {
        long ans = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'A') {
                for(int j = i + 1; j < A.length(); j++) {
                    if(A.charAt(j) == 'G') {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    // Approach 2 - Optimal Approach using carry forward technique
    public long solve(String A) {
        long countA = 0;
        long ans = 0;

        //using the carry forward technique - TC => O(N)
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'A')
                countA++;
            else if (A.charAt(i) == 'G') {
                ans += countA;
            }
        }
        return ans;
    }
}
