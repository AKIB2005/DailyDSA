from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2
            
            # 1. Found the target
            if nums[mid] == target:
                return mid
            
            # 2. Check if the left half is sorted
            if nums[low] <= nums[mid]:
                # Check if target lies within the sorted left half
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                    
            # 3. Otherwise, the right half must be sorted
            else:
                # Check if target lies within the sorted right half
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                    
        # Target not found
        return -1