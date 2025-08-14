package Practice.day11;

/*
Problem Description
You are given a character string A having length N,
consisting of only lowercase and uppercase latin letters.
You have to toggle case of each character of string A.
For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.

Problem Constraints
1 <= N <= 10^5
A[i] ∈ ['a'-'z', 'A'-'Z']

Input Format
First and only argument is a character string A.

Output Format
Return a character string.

Input 1:
 A = "Hello"
Input 2:
 A = "tHiSiSaStRiNg"

Output 1:
 hELLO
Output 2:
 ThIsIsAsTrInG
*/

public class ToggleCase {

    // Approach: Just loop through the String and check if the value is UpperCase then make LowerCase and vice versa
    // TC => O(N)
    // SC => O(N) -> StringBuilder
    public String solve(String A) {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) >= 'A' && A.charAt(i) <= 'Z')
                res.append((char) (A.charAt(i) + 32));
            else if(A.charAt(i) >= 'a' && A.charAt(i) <= 'z')
                res.append((char) (A.charAt(i) - 32));
        }

        return new String(res);
    }
}
