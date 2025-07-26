package Practice.day2;

/*
Problem Description
Given an integer A, you need to find the count of it's factors.
Factor of a number is the number which divides it perfectly leaving no remainder.
Example : 1, 2, 3, 6 are factors of 6

Problem Constraints
1 <= A <= 109

Input Format
First and only argument is an integer A.

Output Format
Return the count of factors of A.
*/

public class CountFactors {
    public int solve(int A) {
        int count = 0;
        for(int i = 1; i * i <= A; i++) {
            if(A % i == 0) {
                if(i != A/i) {
                    count += 2;
                }
                else {
                    count++;
                }
            }
        }
        return count;
    }
}
