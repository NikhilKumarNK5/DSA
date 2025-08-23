package Practice.day12;

/*
Problem Description
Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:
A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different

Problem Constraints
1 <= A <= 2 * 10^9

Input Format
The first and only argument is an integer A.

Output Format
Return 1 if integer A is COLORFUL else return 0.

Input 1:
 A = 23
Input 2:
 A = 236

Output 1:
 1
Output 2:
 0
*/

import java.util.HashSet;

public class ColorfulNumber {

    // Approach: Convert the number to string and then generate all the subarrays and for each subarray calculate the product of it's digits
    // After calculating the product store into HashSet and check if the product already exists and if it does then it is not a colorful number
    // TC => O(N^2)
    // SC => O(N)
    public int colorful(int A) {
        String strNum = Integer.toString(A);

        HashSet<Integer> products = new HashSet<>();

        // generating all the subarrays
        for(int i = 0; i < strNum.length(); i++) {
            int product = 1;
            for(int j = i; j < strNum.length(); j++) {
                int digit = strNum.charAt(j) - '0'; // converts character to integer
                product *= digit;

                // checking if the product exits in the set
                if(products.contains(product))
                    return 0;
                products.add(product);
            }
        }
        return 1;
    }
}
