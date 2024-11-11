public class Solution {
    public int myAtoi(String s) {
        // Step 1: Ignore leading whitespace
        s = s.trim();
        if (s.isEmpty()) return 0;

        int index = 0, sign = 1, total = 0;
        // Step 2: Determine the sign
        char firstChar = s.charAt(index);
        if (firstChar == '-' || firstChar == '+') {
            sign = (firstChar == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Convert the digits
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            // Check if the character is a digit
            if (currentChar < '0' || currentChar > '9') break;

            // Convert to integer
            int digit = currentChar - '0';

            // Check for overflow/underflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}
