import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] v) {
        // If the input array is empty, return an empty string
        if (v == null || v.length == 0) return "";
        
        // Sort the array of strings
        Arrays.sort(v);
        
        // Take the first and the last strings after sorting
        String first = v[0];
        String last = v[v.length - 1];
        StringBuilder ans = new StringBuilder();
        
        // Compare characters of the first and the last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();  // Return result if characters do not match
            }
            ans.append(first.charAt(i));  // Append matching character to result
        }
        
        return ans.toString();  // Return the longest common prefix
    }
}
