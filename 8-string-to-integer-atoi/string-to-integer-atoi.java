class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string contains only spaces
        if (i == n) return 0;

        // 2. Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        long num = 0;

        // 3. Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            num = num * 10 + (s.charAt(i) - '0');

            // 4. Handle overflow
            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }
}