import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Cache to store the results of (s1 + "," + s2) pairs
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base Case 1: If strings are identical, they are scrambles of each other
        if (s1.equals(s2)) return true;
        
        // Base Case 2: If lengths differ, they cannot be scrambles
        if (s1.length() != s2.length()) return false;

        // Check the cache to see if we already computed this pair
        String key = s1 + "," + s2;
        if (memo.containsKey(key)) return memo.get(key);

        // Optimization: Quick check if both strings have the exact same character frequencies
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();
        // Try every possible split point from index 1 to n-1
        for (int i = 1; i < n; i++) {
            // Case 1: Substrings are NOT swapped
            // s1 left with s2 left && s1 right with s2 right
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Substrings ARE swapped
            // s1 left with s2 right && s1 right with s2 left
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && 
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}
