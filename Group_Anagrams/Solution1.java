/* 
	Solution 1 
	
	Sort the strings and group them in a Hash Table. (sorted anagrams all have the same characters)
	Example:
		acre -> (maps to) strings {acre, race, care}
	After the strings are grouped in the hash table, send them back to the array.
*/


/* 
	Time Complexity: 
	Space Complexity: 
*/

void sort(String[] array){
	HashMapList<String, String> mapList = new HashMapList<String, String>();

	/* Group words by anagram */
	for(String s : array){
		String key = sortChars(s);
		mapList.put(key, s);
	}

	/* Convert hash table to array */
	int index = 0;
	for(String key : mapList.keySet()){
		ArrayList<String> list = mapList.get(key);
		for(String t : list){
			array[index] = t;
			index++;
		}
	}
}

String sortChars(String s){
	char[] content = s.toCharArray();
	Arrays.sort(content);
	return new String(content);
}

/* HashMapList<String, String> is a HashMap that maps from Strings to ArrayList<String> */
public class HashMapList<T, E> {
	private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

	/* Insert item into list at key */
	public void put(T key, E item){
		if(!map.contains(key)){
			map.put(key, new ArrayList<E>());
		}
		map.get(key).add(item);
	}

	/* Insert list of items at key */
	public void put(T key, ArrayList<E> items){
		map.put(key, items);
	}

	/* Get list of items at key */
	public ArrayList<E> get(T key){
		return map.get(key);
	}

	/* Check if hashmaplist contains key */
	public boolean containsKey(T key){
		return map.containsKey(key);
	}

	/* Check if list at key contains value */
	public boolean containsKeyValue(T key, E value){
		ArrayList<E> list = get(key);
		if(list == null) return false;
		return list.contains(value);
	}

	/* Get the list of keys */
	public Set<T> keySet(){
		return map.keySet();
	}

	@Override
	public String toString(){
		return map.toString();
	}
}