/* 
	Solution 1 
	
	Implement a simple modification to binary search. Do a fixed comparison against mid, in case mid
	is an empty string. If so, move mid to the closest non-empty string.
*/


/* 
	Time Complexity: O(n)
	Space Complexity: 
*/

int search(String[] strings, String str, int first, int last){
	if(first > last) return -1;
	/* Move mid to the middle */
	int mid = (last + first) / 2;

	/* If mid is empty, find closest non-empty string. */
	if(strings[mid].isEmpty()){
		int left = mid - 1;
		int right = mid + 1;
		while(true){
			if(left < first && right > last){
				return -1;
			} else if(right <= last && !strings[right].isEmpty()){
				mid = right;
				break;
			} else if(left >= first && !strings[left].isEmpty()){
				mid = left;
				break;
			}
			right++;
			left--;
		}
	}

	/* Check for string, and recurse if necessary */
	if(str.equals(strings[mid])){ // Found it
		return mid;
	} else if(strings[mid].compareTo(str) < 0){ // Search right
		return search(strings, str, mid + 1, last);
	} else { // Search left
		return search(strings, str, first, mid - 1);
	}
}

int search(String[] strings, String str){
	if(strings == null || str == null || str == ""){
		return -1;
	}
	return search(strings, str, 0, strings.length - 1);
}