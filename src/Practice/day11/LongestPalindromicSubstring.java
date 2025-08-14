package Practice.day11;

/*
Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A)
Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
Incase of conflict, return the substring which occurs first ( with the least starting index).

Problem Constraints
1 <= N <= 6000

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the longest palindromic substring of string A.

Input 1:
A = "aaaabaaa"
Input 2:
A = "abba

Output 1:
"aaabaaa"
Output 2:
"abba"
*/

public class LongestPalindromicSubstring {

    // Approach 1: Find all the substring and check if they are palindrome and track the maxLength and return the substring with maxLength
    // TC => O(N^3) -> TLE
    public String longestPalindrome(String A) {
        int n = A.length();
        String ans = "";
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
               String sub = A.substring(i, j + 1);
               if(isPalindrome(sub) && sub.length() > ans.length())
                   ans = sub;
            }
        }
        return ans;
    }

    private boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length() - 1;
        while(left < right) {
            if(sub.charAt(left) != sub.charAt(right))
                return false;
        }
        return true;
    }

    // Approach 2: Expand around center approach
    // Checking window for odd length and even length of substring and find maxLength among those along with the start index
    // return the substring with the maxLength either odd or even length
    // TC => O(N^2)
    public String longestPalindromeExpandAroundCenter(String A) {
        int n = A.length();
        int maxLength = 0;
        int start = 0;

        for(int i = 0; i < n; i++) {

            // for odd length
            int left = i;
            int right = i;
            while(left >= 0 && right < n) {
                if(A.charAt(left) != A.charAt(right))
                    break;

                // increasing the window on both sides
                left--;
                right++;
            }
            if(maxLength < right - left - 1) { // right - left - 1 because we are excluding current right and left
                maxLength = right - left - 1;
                start = left + 1;
            }

            // for even length
            left = i;
            right = i + 1;
            while(left >= 0 && right < n) {
                if(A.charAt(left) != A.charAt(right))
                    break;

                // increasing the window on both sides
                left--;
                right++;
            }
            if(maxLength < right - left - 1) {
                maxLength = right - left - 1;
                start = left + 1;
            }
        }
        return A.substring(start, maxLength + start); // from start index to end index
    }
}
