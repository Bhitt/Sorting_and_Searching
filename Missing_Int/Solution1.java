/* 
	Solution 1 
	
	There are a total of 2^32, or 4 billion, distinct integers possible and 2^31 non negative 
	integers. Therefore, we know the input file (assuming it is ints rather than longs) contains
	some duplicates.

	We have 1 GB of memory, or 8 billion bits. Thus, with 8 billion bits, we can map all possible
	integers to a distinct bit with the available memory. The logic is as follows:

	1. Create a bit vector (BV) with 4 billion bits. Recall that a bit vector is an array that
	compactly stores boolean values by using an array of ints(or another data type). Each int
	represents 32 boolean values.
	2. Initialize BV with all 0s.
	3. Scan all numbers (num) from the file and call BV.set(num, 1).
	4. Now scan again BV from the 0th index.
	5. Return the first index which has a value of 0.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
byte[] bitfield = new byte [(int) (numberOfInts / 8)];
String filename = ...

void findOpenNumber() throws FileNotFoundException {
	Scanner in = new Scanner(new FileReader(filename));
	while(in.hasNextInt()){
		int n = in.nextInt();
		/* Find the corresponding number in the bitfield by using the OR operator to set the nth bit
		of a byte (e.g., 10 would correspond to bit 2 of index 1 in the byte array) */
		bitfield[n/8] |= 1 << (n % 8);
	}

	for(int i=0; i < bitfield.length; i++){
		for(int j=0; j < 8; j++){
			/* Retrieves the individual bits of each byte. When 0 bit is found, print the
			corresponding value. */
			if((bitfield[i] & (1 << j)) == 0){
				System.out.println(i * 8 + j);
				return;
			}
		}
	}
}
