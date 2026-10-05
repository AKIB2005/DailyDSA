class Solution {
    public String countAndSay(int n) {
        // Base case
        String currentSeq = "1";
        
        // Generate sequences iteratively up to n
        for (int iter = 1; iter < n; iter++) {
            StringBuilder nextSeq = new StringBuilder();
            int i = 0;
            
            while (i < currentSeq.length()) {
                int count = 1;
                // Count consecutive identical characters
                while (i + 1 < currentSeq.length() && currentSeq.charAt(i) == currentSeq.charAt(i + 1)) {
                    count++;
                    i++;
                }
                
                // Append the count followed by the digit character
                nextSeq.append(count);
                nextSeq.append(currentSeq.charAt(i));
                i++;
            }
            
            currentSeq = nextSeq.toString();
        }
        
        return currentSeq;
    }
}
