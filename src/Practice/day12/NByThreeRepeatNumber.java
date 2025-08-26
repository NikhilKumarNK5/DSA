package Practice.day12;

/*
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than
N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Note: Read-only array means that the input array should not be modified in the process of solving the problem

Problem Constraints
1 <= N <= 7*10^5
1 <= A[i] <= 10^9

Input Format
The only argument is an integer array A.

Output Format
Return an integer.

Input 1:
[1 2 3 1 1]
Input 2:
[1 2 3]

Output 1:
1
Output 2:
-1
*/

import java.util.HashMap;

public class NByThreeRepeatNumber {

    // Approach 1: Using HashMap -> Store each element and it's count in the map and check if count is greater than N / 3 then return the number else return -1
    // TC => O(N)
    // SC => O(N)
    public int repeatedNumber(int[] A) {
        int N = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);

            if(map.get(A[i]) > N / 3)
                return A[i];
        }
        return -1;
    }

    // Approach 2: Using Boyer Moore Voting Algorithm
    // We can pick two candidates to verify if they appear more than N/3 times
    // Two - because there can be at most 2 elements that appear more than N/3 times in the array
    // After marking the candidates we can count and check if they appear more than N/3 times and return
    // TC => O(N)
    // SC => O(1)
    public int repeatedNumberVotingAlgo(int[] A) {
        int N = A.length;
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;

        // shortlisting candidates that could appear more than 2 times
        for(int current : A) {
            if(current == candidate1)
                count1++;
            else if(current == candidate2)
                count2++;
            else if(count1 == 0) {
                candidate1 = current;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = current;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // now calculating the actual count of both the candidates to check greater than N/3
        count1 = 0;
        count2 = 0;
        for(int ele : A) {
            if(ele == candidate1)
                count1++;
            else if(ele == candidate2)
                count2++;
        }

        // checking if the candidate is greater than N/3
        if(count1 > N / 3)
            return candidate1;
        else if(count2 > N / 3)
            return candidate2;
        return -1;
    }
}
