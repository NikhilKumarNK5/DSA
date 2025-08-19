package Practice.day12;

/*
Problem Description
You are given two lowercase strings A and B each of length N.
Return 1 if they are anagrams to each other and 0 if not.
Note : Two strings A and B are called anagrams to each other if
A can be formed after rearranging the letters of B.

Problem Constraints
1 <= N <= 10^5
A and B are lowercase strings

Input Format
Both arguments A and B are a string.

Output Format
Return 1 if they are anagrams and 0 if not

Input 1:
A = "cat"
B = "bat"
Input 2:
A = "secure"
B = "rescue"

Output 1:
0
Output 2:
1
*/

import java.util.Arrays;
import java.util.HashMap;

public class CheckAnagrams {

    // Approach 1: Sorting - sort the two string and check if they are equal or not
    // TC => O(NLogN)
    // SC => O(1N)
    public int solve(String A, String B) {
        // if the length is not equal they are not anagrams
        if(A.length() != B.length())
            return 0;

        // storing the string into character arrays
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        // sort the two arrays
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        if(Arrays.equals(arrA, arrB))
            return 1;
        return 0;
    }

    // Approach 2: Using HashMap - increase frequency of a character using one string and reduce that using another
    // if the frequency stays 0 then it is anagram else not
    // Same can be achieved using two HashMaps and storing the frequency of each character and then comparing the frequency and if they are same it is anagram
    // TC => O(N)
    // SC => O(N)
    public int solveHashMap(String A, String B) {

        // if the length is not equal they are not anagrams
        if(A.length() != B.length())
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            // add from A
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);

            // remove from B
            map.put(B.charAt(i), map.getOrDefault(B.charAt(i), 0) - 1);
        }

        // After processing both strings, all counts should be 0
        for(int count: map.values()) {
            if(count != 0)
                return 0;
        }
        return 1;
    }
}
