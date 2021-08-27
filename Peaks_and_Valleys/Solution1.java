/* 
	Solution 1 
	
	1. Sort the array in ascending order.
	2. Iterate through the elements, jumping two at a time.
	3. Swap with the previous element.
*/


/* 
	Time Complexity: O(n log(n))
	Space Complexity: 
*/

void sortValleyPeak(int[] array){
	Arrays.sort(array);
	for(int i = 1; i < array.length; i += 2){
		swap(array, i - 1, i);
	}
}

void swap(int[] array, int left, int right){
	int temp = array[left];
	array[left] = array[right];
	array[right] = temp;
}