class Solution {
    public int mySqrt(int x) {
        // Base cases for 0 and 1
        if (x < 2) {
            return x;
        }
        
        int left = 1;
        int right = x / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = (long) mid * mid; // Cast to long to prevent overflow
            
            if (num == x) {
                return mid;
            } else if (num < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // When left > right, 'right' points to the floor value of sqrt(x)
        return right;
    }
}
