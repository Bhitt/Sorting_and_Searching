/*
	Binary Search:
		Runtime: O(log(n)) for average and worst case
		Memory: O(1)

	In binary search, we look for an element x in a sorted array by first comparing x to the midpoint
	of the array. If x is less than the midpoint, then we search the left half of the array. If x is
	greater than the midpoint, then we search the right half of the array. We then repeat this process,
	treating the left and right halves as subarrays. Again, we compare x to the midpoint of this
	subarray and then search either its left or right side. We repeat this process until we either find
	x or the subarray has size 0.
*/

int binarySearch(int[] a, int x){
	int low = 0;
	int high = a.length - 1;
	int mid;

	while(low <= high){
		mid = (low + high)/2;
		if(a[mid] < x){
			low = mid + 1;
		} else if(a[mid] > x){
			high = mid - 1;
		} else {
			return mid;
		}
	}
	return -1; // Error
}

int binarySearchRecursive(int[] a, int x, int low, int high){
	if(low > high) return -1; //Error

	int mid = (low + high)/2;
	if(a[mid] < x){
		return binarySearchRecursive(a, x, mid + 1, high);
	} else if(a[mid] > x){
		return binarySearchRecursive(a, x, low, mid - 1);
	} else {
		return mid;
	}
}