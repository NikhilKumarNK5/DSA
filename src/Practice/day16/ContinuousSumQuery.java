package Practice.day16;

/*
Problem Description
There are A beggars sitting in a row outside a temple.
Each beggar initially has an empty pot. When the devotees come to the temple,
they donate some amount of coins to these beggars.
Each devotee gives a fixed amount of coin(according to their faith and ability)
to some K beggars sitting next to each other.
Given the amount P donated by each devotee to the beggars ranging from L to R index,
where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day,
provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B

Problem Constraints
1 <= A <= 2 * 10^5
1 <= L <= R <= A
1 <= P <= 10^3
0 <= len(B) <= 10^5

Input Format
The first argument is a single integer A.
The second argument is a 2D integer array B.

Output Format
Return an array(0 based indexing) that stores the total number of coins in each beggars pot.

Input 1:-
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
Output 1:-
10 55 45 25 25
*/

public class ContinuousSumQuery {

    // Approach 1: Brute Force - for each query compute the value at index j for res
    // TC => O(Q * N) - TLE
    public int[] solve(int A, int[][] B) {
        int[] res = new int[A];

        for(int i = 0; i < B.length; i++) {
            int L = B[i][0] - 1;
            int R = B[i][1] - 1;
            int P = B[i][2];

            for(int j = L; j <= R; j++) {
                res[j] += P;
            }
        }
        return res;
    }

    // Approach 2: Using the concept of prefix sum
    // Add P into the start index L
    // Remove P from the end index R + 1 so the value is not included after the end index in prefix sum
    // Calculate the final prefix sum
    /*
        Input:
        A = 5
        B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

        Initial difference array (res):
        res = [0, 0, 0, 0, 0]

          Query 1: [L, R, P] = [1, 2, 10]  (1-based)
          Convert to 0-based: L0 = 0, R0 = 1, P = 10
          Operations:
          res[L0]     += P   -> res[0] += 10
          if (R0+1<A) res[R0+1] -= P -> res[2] -= 10  (since 1+1 < 5)
          res = [10, 0, -10, 0, 0]

          Query 2: [L, R, P] = [2, 3, 20]  (1-based)
          Convert to 0-based: L0 = 1, R0 = 2, P = 20
          Operations:
          res[L0]     += P   -> res[1] += 20
          if (R0+1<A) res[R0+1] -= P -> res[3] -= 20  (since 2+1 < 5)
          res = [10, 20, -10, -20, 0]

          Query 3: [L, R, P] = [2, 5, 25]  (1-based)
          Convert to 0-based: L0 = 1, R0 = 4, P = 25
          Operations:
          res[L0]     += P   -> res[1] += 25
          if (R0+1<A) res[R0+1] -= P -> (R0+1 = 5) not < 5, so SKIP
          res = [10, 45, -10, -20, 0]

          Build final array by prefix sum over res
          res[i] = res[i-1] + res[i]

          i = 0: res[0] = 10
          i = 1: res[1] = 10  + 45  = 55
          i = 2: res[2] = 55  + (-10) = 45
          i = 3: res[3] = 45  + (-20) = 25
          i = 4: res[4] = 25  + 0   = 25

          Final result:
            res = [10, 55, 45, 25, 25]
     */
    // TC => O(N)
    public int[] solvePrefixSum(int A, int[][] B) {
        // result array
        int[] res = new int[A];

        for(int i = 0; i < B.length; i++) {
            int L = B[i][0] - 1; // 1 based indexing being converted to 0 based indexing
            int R = B[i][1] - 1;
            int P = B[i][2];

            res[L] = res[L] + P;

            if(R + 1 < A )
                res[R + 1] = res[R + 1] - P;
        }

        // finding prefix sum of the result
        for(int i = 1; i < A; i++) {
            res[i] = res[i - 1] + res[i];
        }

        return res;
    }
}
