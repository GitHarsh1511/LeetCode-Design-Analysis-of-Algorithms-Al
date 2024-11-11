import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>();
        return isMatchHelper(s, p, 0, 0, memo);
    }

    private boolean isMatchHelper(String s, String p, int i, int j, Map<String, Boolean> memo) {
        // Create a unique key for the current state
        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // If we reach the end of the pattern
        if (j == p.length()) {
            boolean match = i == s.length();
            memo.put(key, match);
            return match;
        }

        // Check if current characters match
        boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // Handle '*' in the pattern
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean match = (isMatchHelper(s, p, i, j + 2, memo) || 
                             (firstMatch && isMatchHelper(s, p, i + 1, j, memo)));
            memo.put(key, match);
            return match;
        } else if (firstMatch) {
            boolean match = isMatchHelper(s, p, i + 1, j + 1, memo);
            memo.put(key, match);
            return match;
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution matcher = new Solution();
        System.out.println(matcher.isMatch("aa", "a"));      // Output: false
        System.out.println(matcher.isMatch("aa", "a*"));     // Output: true
        System.out.println(matcher.isMatch("ab", ".*"));     // Output: true
    }
}
