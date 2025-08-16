package Practice.day11;

/*
You are given a string S, and you have to find all the amazing substrings of S.
An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input
Only argument given is string S.
Output
Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.

Constraints
1 <= length(S) <= 1e6
S can have special characters

Example
Input
    ABEC
Output
    6
Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
*/

public class AmazingSubarrays {

    // Approach: Find the vowel and if it exists then all the subarrays starting from that point will be considered amazing
    // To find the total such subarrays starting from that point, we can use A.length - index
    // TC => O(N)
    public int solve(String A) {
        int n = A.length();
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int c = Character.toLowerCase(A.charAt(i));
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
                ans += n - i;
        }
        return (int) (ans % 10003);
    }
}
