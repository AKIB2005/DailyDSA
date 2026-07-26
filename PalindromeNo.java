class Solution {
    public boolean isPalindrome(int n) {
        int original = n;
        int rev = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            rev = rev * 10 + lastDigit;
            n = n / 10;
        }

        return original == rev;
    }
}