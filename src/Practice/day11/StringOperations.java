package Practice.day11;

/*
Problem Description
Akash likes playing with strings.
One day he thought of applying following operations on the string in the given order:
Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets.
Return the resultant string after applying the above operations.
NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

Problem Constraints
1<=N<=100000

Input Format
First argument is a string A of size N.

Output Format
Return the resultant string.

Input 1:
A="aeiOUz"
Input 2:
A="AbcaZeoB"

Output 1:
"###z###z"
Output 2:
"bc###bc###"
*/

public class StringOperations {

    // Approach: Loop through the string and perform the operations by checking
    // TC => O(N)
    // SC => O(N)
    public String solve(String A) {
        A = A + A;

        // to store the resultant string
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                if(A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u')
                    res.append('#');
                else
                    res.append(A.charAt(i));
            }
        }

        return new String(res);

    }
}
