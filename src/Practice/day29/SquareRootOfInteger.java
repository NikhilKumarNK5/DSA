package Practice.day29;

/*
Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.

Problem Constraints
0 <= A <= 10^9

Input Format
The first and only argument given is the integer A.

Output Format
Return floor(sqrt(A))

Input 1:
 11
Input 2:
 9

Output 1:
 3
Output 2:
 3

Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
Explanatino 2:
When A = 9 which is a perfect square of 3, so we return 3.
*/

public class SquareRootOfInteger {

    // Approach: Use Binary Search to search a value that is smaller or equal to A / mid and store it and keep going right till you find a value that is the biggest floor value is not a sqrt
    // TC => O(LogN)
    // SC => O(1)
    public int sqrt(int A) {
        int low = 1;
        int high = A;
        int res = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(mid <= A / mid) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
