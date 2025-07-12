package scalar.day7;

public class MaximumSubarraySumOfFixedLength {
    public long solve(int[] A, int B) {
        long ans = 0;
        long sum = 0;
        int N = A.length;

        // calculate the sum of first window
        for(int i = 0; i < B; i++) {
            sum += A[i];
        }
        ans = sum;

        // check for all the other windows as well as update the ans with max value
        int start = 0;
        int end = B;
        while(end < N) {
            sum = sum - A[start] + A[end];
            ans = Math.max(ans, sum);
            start++;
            end++;
        }
        return ans;
    }
}
