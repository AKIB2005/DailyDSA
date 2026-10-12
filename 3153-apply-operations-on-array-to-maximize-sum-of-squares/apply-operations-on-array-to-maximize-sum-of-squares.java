import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] count = new int[32];

        // Step 1: Count frequency of each bit position
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }

        // Step 2: Greedily build the k largest numbers
        long totalSumOfSquares = 0;
        for (int step = 0; step < k; step++) {
            long currentNum = 0;
            for (int i = 31; i >= 0; i--) {
                if (count[i] > 0) {
                    currentNum |= (1L << i);
                    count[i]--;
                }
            }
            
            long square = (currentNum * currentNum) % MOD;
            totalSumOfSquares = (totalSumOfSquares + square) % MOD;
        }

        return (int) totalSumOfSquares;
    }
}
