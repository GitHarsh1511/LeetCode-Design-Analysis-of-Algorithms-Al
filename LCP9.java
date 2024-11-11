public class Solution {
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }
        
        // Convert integer to string
        String str = Integer.toString(x);
        
        // Compare the string with its reverse
        String reversedStr = new StringBuilder(str).reverse().toString();
        
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));  // Output: true
        System.out.println(isPalindrome(-121)); // Output: false
        System.out.println(isPalindrome(10));   // Output: false
    }
}
