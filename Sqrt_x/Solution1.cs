/* 
	Solution 1 
	
	To find the floor of the square root, try with all-natural numbers starting from 1. Continue 
	incrementing the number until the square of that number is greater than the given number.

	Note: The answer will overflow at 46340, so we bound it by that.
*/


/* 
	Time Complexity: O(√n) 
	Space Complexity: O(1)
*/

public class Solution {
    public int MySqrt(int x) {
        // Zero value
        if(x == 0) return 0;
        
        // Loop until i*i is greater than x and return i
        for(int i = 1; i < 46341; i++){
            // Return i - 1
            if(i * i > x) return i-1;
        }
        
        
        // Overflow
        return 46340;
    }
}

/*
	LEET CODE RESULTS

	Runtime: 76 ms, faster than 16.35% of C# online submissions for Sqrt(x).
	Memory Usage: 15.3 MB, less than 32.80% of C# online submissions for Sqrt(x).
*/