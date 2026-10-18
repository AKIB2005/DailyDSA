class Solution {
    public int reverse(int n) {
        long rev = 0; 

        while (n != 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n / 10;
        }

       
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}