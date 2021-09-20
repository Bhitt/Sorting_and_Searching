/* 
	Solution 1 
	
	Use binary search to find the element. Then use a modified binary search to look right and left
	for the first and last position of the element.
*/


/* 
	Time Complexity: O(log n)
	Space Complexity: O(1)
*/

public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        // Value not found
        int[] result = {-1,-1};
        
        // First find value using binary search
        int foundIndex = binarySearch(nums, 0, nums.Length - 1, target);
        if(foundIndex == -1) return result; // Value not found
        
        // Search for leftmost target element (if it wasnt foundIndex)
        result[0] = searchLeft(nums, 0, foundIndex - 1, target, foundIndex);
        
        // Search for rightmost target element (if it wasnt foundIndex)
        result[1] = searchRight(nums, foundIndex + 1, nums.Length - 1, target, foundIndex);
        
        // Exit stage right
        return result;
    }
    
    
    int binarySearch(int[] nums, int left, int right, int target){
        // value not in array
        if(left > right) return -1;
    
        // find mid of array chunk
        int mid = left + (right-left)/2;
        
        // found
        if(nums[mid] == target) return mid;
        
        // search left
        else if(nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
        
        // search right
        else return binarySearch(nums, mid + 1, right, target);
    }
    
    int searchLeft(int[] nums, int left, int right, int target, int lastIndex){
        // out of bounds
        if(left > right) return lastIndex;
        
        // calculate mid of the array chunk
        int mid = left + (right - left)/2;
        
        // found, update lastIndex and continue left
        if(nums[mid] == target) {
            lastIndex = mid;
            return searchLeft(nums, left, mid - 1, target, lastIndex);
        }
        
        // search right
        else {
            return searchLeft(nums, mid + 1, right, target, lastIndex);
        }
    }
    
    int searchRight(int[] nums, int left, int right, int target, int lastIndex){
         // out of bounds
        if(left > right) return lastIndex;
        
        // calculate mid of the array chunk
        int mid = left + (right - left)/2;
        
        // found, update lastIndex and continue right
        if(nums[mid] == target) {
            lastIndex = mid;
            return searchRight(nums, mid + 1, right, target, lastIndex);
        }
        
        // search left
        else {
            return searchRight(nums, left, mid - 1, target, lastIndex);
        }
    }
}

/*
	LEET CODE RESULTS

	Runtime: 359 ms, faster than 28.35% of C# online submissions for Find First and Last Position of 
	Element in Sorted Array.

	Memory Usage: 32.4 MB, less than 96.14% of C# online submissions for Find First and Last Position 
	of Element in Sorted Array.
*/