class Solution {
    public int findNthDigit(int n) {
        int digitLength = 1;
        long count = 9; // Use long to prevent integer overflow
        long start = 1; // Use long to prevent integer overflow
        
        // Step 1: Find the digit length range where the nth digit falls
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }
        
        // Step 2: Identify the exact number that contains the nth digit
        long targetNum = start + (n - 1) / digitLength;
        
        // Step 3: Extract the specific digit from that target number
        String targetStr = Long.toString(targetNum);
        return targetStr.charAt((n - 1) % digitLength) - '0';
    }
}
