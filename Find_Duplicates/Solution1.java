/* 
	Solution 1 
	
	We have 4 kilobytes of memory which means we can address up to 8 * 4 * 2^10 bits. Note that
	32 * 2^10 bits is greater than 32000. We can create a bit vector with 32000 bits, where each bit
	represents one integer.

	Using this bit vector, we can then iterate through the array, flagging each element v by setting 
	bit v to 1. When we come across a duplicate element, we print it.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

void checkDuplicates(int[] array){
	BitSet bs = new BitSet(32000);
	for(int i=0; i < array.length; i++){
		int num = array[i];
		int num0 = num - 1; // bitset starts at 0, numbers start at 1
		if(bs.get(num0)){
			System.out.println(num);
		} else {
			bs.set(num0);
		}
	}
}

class BitSet {
	int[] bitset;

	public BitSet(int size){
		bitset = new int[(size >> 5) + 1]; // divide by 32
	}

	boolean get(int pos){
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		return (bitset[wordNumber] & (1 << bitNumber)) != 0;
	}

	void set(int pos){
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		bitset[wordNumber] |= 1 << bitNumber;
	}
}