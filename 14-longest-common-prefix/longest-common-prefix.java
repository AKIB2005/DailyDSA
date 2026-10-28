class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Guard clause: if the input array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Iterate through the characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Compare this character with the character at index i in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If the current string is shorter than i or characters don't match
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    // Return the prefix up to the current index
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If the loops finish completely, the entire first string is the common prefix
        return strs[0];
    }
}
