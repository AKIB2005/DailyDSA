import java.util.Arrays;

public class Solution {
    public long maxAlternatingSum(int[] nums) {
        // 1. Square the numbers and sort them in ascending order
        long[] squared = Arrays.stream(nums)
                               .mapToLong(x -> (long) x * x)
                               .sorted()
                               .toArray();
        
        int n = squared.length;
        long sum1 = 0;
        long sum2 = 0;
        
        // 2. Subtract the first half, add the second half
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                sum1 += squared[i];
            } else {
                sum2 += squared[i];
            }
        }
        
        return sum2 - sum1;
    }
}
