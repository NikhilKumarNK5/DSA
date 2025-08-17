package Practice.day12;

/*
Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.

Problem Constraints
1 <= |A| <= 10^5
String A consist only of lowercase characters.

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the reversed string.

Input 1:
 A = "scaler"
Input 2:
 A = "academy"

Output 1:
 "relacs"
Output 2:
 "ymedaca"
*/

public class SimpleReverse {

    // Approach: Use a StringBuilder and store in reverse order and return
    // TC => O(N)
    // SC => O(N)
    public String solve(String A) {
        StringBuilder res = new StringBuilder();
        for(int i = A.length() - 1; i >= 0; i--) {
            res.append(A.charAt(i));
        }
        return new String(res);
    }
}
