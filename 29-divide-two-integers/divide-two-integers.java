class Solution {
    public int divide(int dividend, int divisor) {
        // Edge Case 1: Direct exit if divisor is 1
        if (divisor == 1) {
            return dividend;
        }
        
        // Edge Case 2: Strict 32-bit overflow guard (-2^31 / -1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the final result
        // True if both have the same sign, false otherwise
        boolean isPositiveResult = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        
        // Convert both numbers to NEGATIVE to prevent overflow
        int negDividend = dividend > 0 ? -dividend : dividend;
        int negDivisor = divisor > 0 ? -divisor : divisor;
        
        int quotient = 0;
        
        // Since both are negative, we check if dividend <= divisor 
        // (e.g., -10 is less than or equal to -3)
        while (negDividend <= negDivisor) {
            int currentDivisor = negDivisor;
            int multiple = 1;
            
            // Prevent bit-overflow before shifting: 
            // Check if currentDivisor is greater than or equal to half of Integer.MIN_VALUE
            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && negDividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1; // Exponentially double the divisor
                multiple <<= 1;       // Exponentially double the multiplier
            }
            
            // Subtract the chunk from dividend and add multiple to quotient
            negDividend -= currentDivisor;
            quotient += multiple;
        }
        
        // Return positive or negative quotient based on the signs
        return isPositiveResult ? quotient : -quotient;
    }
}
