/*
	Merge Sort:
	Runtime: O(n log(n)) for average and worst case
	Memory: Depends (mostly O(n))

	Merge sort divides the array in half, sorts each of those halves, and then merges them back
	together. Each of those halves has the same sorting algorithm applied to it. Eventually, you
	are merging just two single-element arrays. It is the "merge" part that does all the heavy lifting.

	The merge method operates by copying all the elements from the target array segment into a helper
	array, keeping track of where the start of the left and right halves should be (helperLeft and
	helperRight). We then iterate through helper, copying the smaller element from each half into the
	array. At the end, we copy any remaining elements into the target array.
*/

void mergesort(int[] array){
	int[] helper = new int[array.length];
	mergesort(array, helper, 0, array.length - 1);
}

void mergesort(int[] array, int[] helper, int low, int high){
	if(low < high){
		int middle = (low + high)/2;
		mergesort(array, helper, low, middle); // Sort left half
		mergesort(array, helper, middle+1, high); // Sort right half
		merge(array, helper, low, middle, high); // Merge them
	}
}

void merge(int[] array, int[] helper, int low, int middle, int high){
	/* Copy both halves into a helper array */
	for(int i=low; i <= high; i++){
		helper[i] = array[i];
	}

	int helperLeft = low;
	int helperRight = middle + 1;
	int current = low;

	/* Iterate through the helper array. Compare the left and right half, copying back the smaller
	element from the two halves into the original array */
	while(helperLeft <= middle && helperRight <= high){
		if(helper[helperLeft] <= helper[helperRight]){
			array[current] = helper[helperLeft];
			helperLeft++;
		} else { // if right element is smaller than left element
			array[current] = helper[helperRight];
			helperRight++;
		}
		current++;
	}

	/* Copy the rest of the left side of the array into the target array */
	int remaining = middle - helperLeft;
	for(int i = 0; i <= remaining; i++){
		array[current + i] = helper[helperLeft + i];
	}
}