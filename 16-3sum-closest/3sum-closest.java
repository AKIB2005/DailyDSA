class Solution {
    /**
     * Finds three numbers in the array whose sum is closest to the target value.
     * 
     * @param nums   The input array of integers
     * @param target The target sum to get closest to
     * @return The sum of three numbers that is closest to the target
     */
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to enable two-pointer approach
        Arrays.sort(nums);
      
        int closestSum = 1 << 30;
        int arrayLength = nums.length;
      
        // Fix the first number and find the other two using two pointers
        for (int i = 0; i < arrayLength; ++i) {
            // Initialize two pointers: left pointer starts after i, right pointer at the end
            int left = i + 1;
            int right = arrayLength - 1;
          
            // Use two-pointer technique to find the closest sum
            while (left < right) {
                // Calculate the current sum of three numbers
                int currentSum = nums[i] + nums[left] + nums[right];
              
                // If we found the exact target, return immediately
                if (currentSum == target) {
                    return currentSum;
                }
              
                // Update closest sum if current sum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
              
                // Move pointers based on comparison with target
                if (currentSum > target) {
                    // Sum is too large, move right pointer left to decrease sum
                    --right;
                } else {
                    // Sum is too small, move left pointer right to increase sum
                    ++left;
                }
            }
        }
      
        return closestSum;
    }
}