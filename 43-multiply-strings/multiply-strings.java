class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the product is "0"
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        // The maximum possible length of the product is m + n
        int[] pos = new int[m + n];
        
        // Multiply from right to left
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                
                // Calculate the product of the two digits and add it to the existing value
                int product = digit1 * digit2;
                int sum = product + pos[i + j + 1];
                
                // Store the units place at the current index
                pos[i + j + 1] = sum % 10;
                // Add the carry-over tens place to the left adjacent index
                pos[i + j] += sum / 10;
            }
        }
        
        // Build the result string, skipping any leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.toString();
    }
}
