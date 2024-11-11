import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        // If input is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        // Mapping of digits to their respective letters
        String[] digitToLetters = {
            "",    // 0 and 1 don't map to any letters
            "",    
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
        };
        
        List<String> result = new ArrayList<>();
        backtrack(result, digitToLetters, digits, 0, new StringBuilder());
        return result;
    }
    
    // Helper function for backtracking
    private void backtrack(List<String> result, String[] digitToLetters, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the characters corresponding to the current digit
        String letters = digitToLetters[digits.charAt(index) - '0'];
        
        // Loop through the letters and continue backtracking
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digitToLetters, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);  // Undo the choice for backtracking
        }
    }
}
