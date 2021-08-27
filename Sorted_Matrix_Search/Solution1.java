/* 
	Solution 1 
	
	Perform a binary search on each row
	-If the start of a column is greater than x, then x is to the left of the column.
	-If the end of a column is less than x, then x is to the right of the column.
	-If the start of a row is greater than x, then x is above that row.
	-If the end of a row is less than x, then x is below that row.

	A better algorithm involves partitioning the matrix into quadrants and searching the lower left
	and the upper right (a more efficient binary search). Page 409.
*/


/* 
	Time Complexity: O(M log(N))
	Space Complexity: 
*/

boolean findElement(int[][] matrix, int elem){
	int row = 0;
	int col = matrix[0].length - 1;
	while(row < matrix.length && col >= 0){
		if(matrix[row][col] == elem){
			return true;
		} else if(matrix[row][col] > elem){
			col--;
		} else {
			row++;
		}
	}
	return false;
}