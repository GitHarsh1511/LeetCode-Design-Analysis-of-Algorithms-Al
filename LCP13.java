import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Create a map for Roman numeral to integer conversion
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Map Roman numerals to their integer values
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = 0;
        int n = s.length();

        // Loop through the Roman numeral string
        for (int i = 0; i < n; i++) {
            // If the current Roman numeral is smaller than the next one, subtract its value
            if (i < n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } 
            // Otherwise, add its value
            else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
    }
}
