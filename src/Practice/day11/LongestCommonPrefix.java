package Practice.day11;

/*
Problem Description
Given the array of strings A, you need to find the longest string S,
which is the prefix of ALL the strings in the array.
The longest common prefix for a pair of strings S1 and S2 is the longest string S
which is the prefix of both S1 and S2.
Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Problem Constraints
0 <= sum of length of all strings <= 1000000

Input Format
The only argument given is an array of strings A.

Output Format
Return the longest common prefix of all strings in A.

Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:
A = ["abab", "ab", "abcd"];

Output 1:
"a"
Output 2:
"ab"
*/

import java.util.Arrays;

public class LongestCommonPrefix {

    // Approach: We need to find the longest common prefix in all the elements of the given array
    // We can sort the given array then we can compare the first and last element
    // The common prefix of both the elements would be the result
    // TC => O(NLogN + L)
    // SC => O(L)
    // L is the length of longest common prefix
    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        StringBuilder res = new StringBuilder();

        // sort the array ["ab", "abab", "abcd"]
        Arrays.sort(A);

        String first = A[0]; // "ab"
        String last = A[n - 1]; // "abcd"

        // compare the first ad last element
        // we will traverse from 0 to first.length as that would be the shortest
        for(int i = 0; i < first.length(); i++) {
            if(first.charAt(i) != last.charAt(i))
                break;
            res.append(first.charAt(i));
        }

        return new String(res);
    }
}
