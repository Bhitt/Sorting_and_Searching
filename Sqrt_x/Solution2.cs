/* 
	Solution 2 
	
	A better solution is to divide up the integers you test similarly to a binary search.

	Note: The answer will overflow at 46340, so we bound it by that.
*/


/* 
	Time Complexity: O(log n)
	Space Complexity: O(1)
*/

public class Solution {
    public int MySqrt(int x) {
        // Base Cases
        if (x == 0 || x == 1)
            return x;
  
        // Do Binary Search 
        // for floor(sqrt(x))
        int start = 1, end = 46340, ans = 0;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
  
            // If x is a 
            // perfect square
            if (mid * mid == x)
                return mid;
  
            // Since we need floor, we 
            // update answer when mid * 
            // mid is smaller than x, 
            // and move closer to sqrt(x)
            if (mid * mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
              
            // If mid*mid is 
            // greater than x
            else 
                end = mid-1;
        }
        return ans;
    }
}

/* 
	LEET CODE RESULTS

	Runtime: 47 ms, faster than 35.12% of C# online submissions for Sqrt(x).
	Memory Usage: 15.3 MB, less than 64.98% of C# online submissions for Sqrt(x).
*/