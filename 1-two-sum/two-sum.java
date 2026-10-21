import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists in the map, we found the pair
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }
            
            // Otherwise, add the current number and its index to the map
            numToIndex.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (though LeetCode guarantees one)
        return new int[] {};
    }
}
