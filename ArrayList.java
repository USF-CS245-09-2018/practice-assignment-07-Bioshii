public class ArrayList implements List {
	// The array for the data
	public Object[] arr;
	// Size of the array
	public int size;

	// Constructor for class
	public ArrayList() {
		// Start the array off with 10 elements
		this.arr = new Object[10];
		// Size is 0 since there are no elements in the array yet
		this.size = 0;
	}
	
	public void add(Object obj) {
		// If size is greater than or equal to the length, array needs to be increased
		if (size >= arr.length) {
			grow_array();
		}

		// Set the next element (the size) and increment the size
		arr[size++] = obj;
	}

	public void add(int pos, Object obj) {
		// If we're adding to a specific position, the position can't be below 0 nor can it be greater than the length
		if (pos >= arr.length || pos < 0) {
			return;
		}
		
		// Make sure there's enough room to add another element
		// Increment size as well
		if (++size >= arr.length) {
			grow_array();
		}

		// Will need to store a temp variable to shift elements to the right
		Object temp;
		for(int i = pos; i < arr.length - 1; i++) {
			temp = arr[i+1];
			arr[i+1] = arr[i];
		}
		
		// Assign the variable
		arr[pos] = obj;
	}

	public Object get(int pos) {
		if (pos >= size || pos < 0) {
			// Would throw an exception here typically
			return null;
		}

		// Return value at position, if it's there
		return arr[pos];
	}

	public Object remove(int pos) {
		if (pos >= size || pos < 0) {
			// Would typically throw an exception
			return null;
		}

		Object temp = arr[pos];
		arr[pos] = null;
		--size;
		return temp;
	}

	public int size() {
		// Simply return size
		return this.size;
	}

	// Double the size of the array
	public void grow_array() {
		// Copy values over to larger array with double the space
		Object[] temp = new Object[arr.length*2];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		arr = temp;
	}
}
