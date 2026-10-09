class Solution:
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        # Sort the array to allow the two-pointer approach
        nums.sort()
        
        # Initialize closest_sum with the sum of the first triplet
        closest_sum = nums[0] + nums[1] + nums[2]
        n = len(nums)
        
        for i in range(n - 2):
            # Optimization: Skip duplicates for the first element
            if i > 0 and nums[i] == nums[i - 1]:
                continue
                
            left = i + 1
            right = n - 1
            
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]
                
                # If we find the exact target, return immediately
                if current_sum == target:
                    return current_sum
                
                # Update closest_sum if current_sum is closer to the target
                if abs(current_sum - target) < abs(closest_sum - target):
                    closest_sum = current_sum
                
                # Move pointers based on how current_sum compares to target
                if current_sum < target:
                    left += 1
                else:
                    right -= 1
                    
        return closest_sum
