class Solution {
    public int romanToInt(String s) {
        // Define Roman numeral characters and their corresponding values
        String romanChars = "IVXLCDM";
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
      
        // Create a mapping from Roman characters to their integer values
        Map<Character, Integer> romanToValueMap = new HashMap<>();
        for (int i = 0; i < romanValues.length; i++) {
            romanToValueMap.put(romanChars.charAt(i), romanValues[i]);
        }
      
        // Get the length of the input string
        int length = s.length();
      
        // Initialize result with the value of the last character
        // (Last character is always added, never subtracted)
        int result = romanToValueMap.get(s.charAt(length - 1));
      
        // Process each character from left to right (except the last one)
        for (int i = 0; i < length - 1; i++) {
            // If current character's value is less than the next character's value,
            // subtract it (e.g., IV = 4, IX = 9)
            // Otherwise, add it to the result
            int sign = romanToValueMap.get(s.charAt(i)) < romanToValueMap.get(s.charAt(i + 1)) ? -1 : 1;
            result += sign * romanToValueMap.get(s.charAt(i));
        }
      
        return result;
        //This s demi
    }
}