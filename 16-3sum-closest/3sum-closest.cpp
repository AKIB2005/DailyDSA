#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>

class Solution {
public:
    int threeSumClosest(std::vector<int>& nums, int target) {
        int n = nums.size();
        
        // Step 1: Sort the array to use the two-pointer technique
        std::sort(nums.begin(), nums.end());
        
        // Initialize with the sum of the first three elements
        long long closestSum = nums[0] + nums[1] + nums[2]; 
        
        // Step 2: Iterate through the array fixing the first element
        for (int i = 0; i < n - 2; ++i) {
            // Optimization: Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            // Step 3: Use two pointers to find the closest pair for nums[i]
            while (left < right) {
                long long currentSum = (long long)nums[i] + nums[left] + nums[right];
                
                // If the exact target is found, return immediately
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Update closestSum if the current deviation is smaller
                if (std::abs(currentSum - target) < std::abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move pointers based on the sum comparison with target
                if (currentSum < target) {
                    ++left; // Increase the sum
                } else {
                    --right; // Decrease the sum
                }
            }
        }
        
        return closestSum;
    }
};
