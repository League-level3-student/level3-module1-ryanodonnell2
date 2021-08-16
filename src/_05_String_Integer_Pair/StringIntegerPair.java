package _05_String_Integer_Pair;

public class StringIntegerPair {
	//1. create a private array of Strings called keys. Don't initialize it.
	private String keys[];
	//2. create a private array of integers called values.
	private int values[];
	StringIntegerPair(){
		//3. initialize both member arrays to a length of 0
		keys = new String[0];
		values = new int[0];
	}
	
	// 4. Complete the steps in the put method
	public void put(String key, int value) {
		boolean foundString = false;
		//A. iterate through the keys. If you find a key that matches
		//   the passed in String, set the value at that location to the
		//   passed in value and return from the method.
		for (int i = 0; i < keys.length; i++) {
			System.out.println(i);
			if(key == keys[i]) {
				values[i] = value;
				foundString = true;
			}
		}
		
		//B. create a String array that is one element longer than the keys
		if(foundString == false) {
			System.out.println("Didn't find");
			String[] strings = new String[keys.length+1];
			int[] ints = new int[values.length+1];
			strings[strings.length-1] = key;
			ints[ints.length-1] = value;
			for (int i = 0; i < keys.length; i++) {
				strings[i] = keys[i];
				ints[i] = values[i];
			}
			keys = strings;
			values = ints;
		}
		//C. create an integer array that is one element longer than values
		
		//D. set the last element of the new String array to the passed in key
		
		//E. set the last element of the new int array to the passed in value
		
		//F. iterate through the keys and values and copy the elements to the new arrays
		
		//G. Set the keys and values arrays equal to the new arrays created in steps B and C.
		System.out.println(key);
		System.out.println(value);
	}
	
	//5. Complete the method so it returns the value located at the passed in key.
	//   If the key does not exist, return Integer.MIN_VALUE.
	public int get(String key) {
		for (int i = 0; i < keys.length; i++) {
			if(keys[i] == key) {
				return values[i];
			}
		}
		return Integer.MIN_VALUE;
	}
	
	//6. Complete the containsKey method so that it returns true if the
	//   passed in keys is contained in the keys array
	public boolean containsKey(String key) {
		for (int i = 0; i < keys.length; i++) {
			if(keys[i] == key) {
				return true;
			}
		}
		return false;
	}
	
	//7. Complete the containsValue method so that it returns true if the
	//   passed in value is contained in the values array
	public boolean containsValue(int value) {
		for (int i = 0; i < values.length; i++) {
			if(values[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	//8. Complete the getKeysMethod so it returns the keys as an array
	public String[] getKeys() {
		return keys;
	}
	
	//9. Complete the getValues so it returns the values as an array
	public int[] getValues() {
		return values;
	}
}
