/* 
	Solution 1 
	
	We can use a binary search but must first find the length of the list. We can do so by checking
	1, then 2, then 4, then 8, then 16, and so on until we hit a -1 value. From here, we do a simple
	binary search with a few changes. If the mid point is -1, we need to treat this as a "too big"
	value and search left. Another change is that if we find a value larger than the value x, we'll
	jump over to the binary search early.
*/


/* 
	Time Complexity: O(log n)
	Space Complexity: O(1)
*/

int search(Listy list, int value){
	int index = 1;
	while(list.elementAt(index) != -1 && list.elementAt(index) < value){
		index *= 2;
	}
	return binarySearch(list, value, index/2, index);
}

int binarySearch(Listy list, int value, int low, int high){
	int mid;

	while(low <= high){
		mid = (low + high)/2;
		int middle = list.elementAt(mid);
		if(middle > value || middle == -1){
			high = mid - 1;
		} else if(middle < value){
			low = mid + 1;
		} else {
			return mid;
		}
	}
	return -1;
}