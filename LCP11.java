class Solution {
    public int maxArea(int[] height) {
        int left = 0;  // Start pointer from the leftmost line
        int right = height.length - 1;  // Start pointer from the rightmost line
        int maxArea = 0;  // To store the maximum area
        
        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the area between the two lines
            int area = Math.min(height[left], height[right]) * (right - left);
            // Update maxArea if we find a larger one
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer with the smaller height inward to try for a bigger container
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;  // Return the maximum area found
    }
}
