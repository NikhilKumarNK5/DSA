package Practice.day11;

/*
Problem Description
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.

Problem Constraints
1 <= |A| <= 1000

Input Format
The first and only argument contains the string A, consisting of lowercase English alphabets.

Output Format
Return an integer containing the answer.

Input 1:
  "abobc"
Input 2:
  "bobob"

Output 1:
  1
Output 2:
  2

*/

public class CountOccurrences {

    // Approach: Sliding Window -  take a window of size 3 that is of length "bob" and check
    // TC => O(N)
    public int solve(String A) {
        int n = A.length();
        int count = 0;
        for(int i = 0; i < n - 2; i++) {
            // sliding window to compare (window of size 3)
            if(A.substring(i, i + 3).equals("bob"))
                count++;
        }
        return count;
    }
}
