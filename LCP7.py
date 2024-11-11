class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # Define the bounds for a signed 32-bit integer
        INT_MIN, INT_MAX = -2**31, 2**31 - 1

        # Determine the sign and reverse the digits
        sign = -1 if x < 0 else 1
        reversed_x = int(str(abs(x))[::-1]) * sign

        # Check if the reversed integer is within the bounds
        if reversed_x < INT_MIN or reversed_x > INT_MAX:
            return 0
        
        return reversed_x

# Example usage
solution = Solution()
print(solution.reverse(123))   # Output: 321
print(solution.reverse(-123))  # Output: -321
print(solution.reverse(120))   # Output: 21
