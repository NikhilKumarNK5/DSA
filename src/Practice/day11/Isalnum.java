package Practice.day11;

/*
Problem Description
You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format
Only argument is a character array A.

Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.

Input 1:
 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:
 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

Output 1:
 1
Output 2:
 0
*/

public class Isalnum {
    // Approach : Check if the characters are in the range of a-z, A-Z, 0-9
    // TC => O(N)
    public int solve(char[] A) {
        for(int i = 0; i < A.length; i++) {
            if(!(A[i] >= 'a' && A[i] <= 'z') && !(A[i] >= 'A' && A[i] <= 'Z') && !(A[i] >= '0' && A[i] <= '9'))
                return 0;
        }
        return 1;
    }
}
