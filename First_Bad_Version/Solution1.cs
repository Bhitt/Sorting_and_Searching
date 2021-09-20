/* 
    Solution 1 
    
    Modify binary search: if the element is found, your 'right' is at mid.... if it isn't found,
    then search right half for the bad version (left = mid + 1).
*/


/* 
    Time Complexity: O(log n) 
    Space Complexity: O(1)
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    public int FirstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if(IsBadVersion(mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // Return first bad version
        return left;
    }
}

/*
    LEET CODE RESULTS

    Runtime: 62 ms, faster than 21.03% of C# online submissions for First Bad Version.
    Memory Usage: 15.1 MB, less than 82.84% of C# online submissions for First Bad Version.
*/