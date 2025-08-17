package Practice.day12;

/*
Problem Description
You are given a string A of size N.
Return the string A after reversing the string word by word.

NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces,
even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

Problem Constraints
1 <= N <= 3 * 10^5

Input Format
The only argument given is string A.

Output Format
Return the string A after reversing the string word by word.

Input 1:
A = "the sky is blue"
Input 2:
A = "this is ib"

Output 1:
"blue is sky the"
Output 2:
"ib is this"
*/

public class ReverseTheString {

    // Approach: Solve by splitting the string based on space and storing each word in an array of Strings
    // Reverse the array
    // Join the words from array using space
    // TC => O(N)
    // SC => O(N)
    public String solve(String A) {

        // split the string word by word and put into array
        // trim() - trims the extra spaces from start and end
        // replace() - takes in the replacement and what to replace - so replaces all spaces with single space
        // split() - splits the string based upon the character specified - space here
        String[] words = A.trim().replaceAll("\\s", " ").split(" ");

        // reverse the array
        int start = 0;
        int end = words.length - 1;
        while(start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }

        // join the words from array using space
        String res = String.join(" ", words);

        return res;
    }
}
