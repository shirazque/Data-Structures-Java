/*
 * -------------------------------------------------------
 * Doubly Linked List ADT 
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-28"
 * -------------------------------------------------------
 */

package data_structures;

import java.util.ArrayList;

class dllNode {
	int value;
	dllNode previous;
	dllNode next;
	
	// Constructor
	dllNode(int newData, dllNode pointerPrev, dllNode pointer_next) {
		/*
		 * ----------------------------------------------------------
		 * Initializes a dll_node 
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		this.value = newData;
		this.previous = pointerPrev;
		this.next = pointer_next;
		
	}
}

class doubleList {
	private dllNode front;
	private dllNode rear;
	private int count;
	
	doubleList() {
		// Constructor
		this.front = null;
		this.rear = null;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		/*
		 * ----------------------------------------------------------
		 * Checks if the List is empty
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        True if empty, False otherwise (boolean)
		 * ----------------------------------------------------------
		 */

		boolean boolEmpty = this.front == null;
		return boolEmpty;
	}
	
	public int len() {
		/*
		 * ----------------------------------------------------------
		 * Returns the number of items in the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        count - The number of nodes in the List (int)
		 * ----------------------------------------------------------
		 */
		
		return this.count; 
	}
	
	public Integer getitem(int i) {
		/*
		 * ----------------------------------------------------------
		 * Gets the item at index i
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        value - The value at index i, null otherwise.
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		if (-this.count <= i && i < this.count) {
			// If the index is negative, we will convert it to its "positive counterpart" to find its proper position
			if (i < 0) {
				i = this.count + i;
			}
			
			int counter = 0;
			dllNode curr = this.front;
			
			while (curr != null && counter < i) {
				curr = curr.next;
				counter = counter + 1;
			}
			
			value = curr.value;
		}
		
		return value;
	}

	public Integer setitem(int i, int value) {
		/*
		 * ----------------------------------------------------------
		 * Sets the item at index i to value
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        value - The value at index i, null otherwise.
		 * ----------------------------------------------------------
		 */
				
		if (-this.count <= i && i < this.count) {
			// If the index is negative, we will convert it to its "positive counterpart" to find its proper position
			if (i < 0) {
				i = this.count + i;
			}
			
			int counter = 0;
			dllNode curr = this.front;
			
			while (curr != null && counter < i) {
				curr = curr.next;
				counter = counter + 1;
			}
			
			curr.value = value;
		}
		
		return value;
	}
	
	public void prepend(int value) {
		/*
		 * ----------------------------------------------------------
		 * Prepends value into the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		dllNode node = new dllNode(value, null, null);
		
		// Special Case: If the List is empty
		if (this.count == 0) {
			this.front = this.rear = node;
		}
		
		// The General Case
		else {
			node.next = this.front;
			this.front.previous = node;
			this.front = node;
		}
		
		// Incrementing the count, i.e. the number of nodes in the List
		this.count = this.count + 1;
		
	}

	public void append(int value) { // I have allowed this to be called internally, even though it is a public method
		/*
		 * ----------------------------------------------------------
		 * Appends value into the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		dllNode node = new dllNode(value, null, null);
		
		// Special Case: If the List is empty
		if (this.count == 0) {
			this.front = this.rear = node;
		}
		
		// The General Case
		else {
			this.rear.next = node;
			node.previous = this.rear;
			this.rear = node;
		}

		// Incrementing the count, i.e. the number of nodes in the List
		this.count = this.count + 1;
		
	}
	
	public void insert(int i, int value) {
		/*
		 * ----------------------------------------------------------
		 * Inserts value into the List
		 * ----------------------------------------------------------
		 * O(n) Time Complexity with O(1) Special Cases
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		dllNode node = new dllNode(value, null, null);
		
		// If i is negative, convert it to its positive counterpart
	    if (i < 0) {
	        i = this.count + i;
	    }
		
		// Special Case: List is empty
		if (this.front == null) {
			this.front = this.rear = node;
		}
		
		// Special Case: Value goes at the front of the List
		else if (i <= 0) {
			node.next = this.front;
			this.front.previous = node;
			this.front = node;
		}
		
		// Special Case: Value goes at the rear of the List
		else if (i >= this.count) {
			this.rear.next = node;
			node.previous = this.rear;
			this.rear = node;

		}
		
		// The General Case: Value goes elsewhere in the List
		else {			
			// Initializing a counter, prev node and curr node to locate the proper position of the new node
			int counter = 0;
			dllNode prev = null;
			dllNode curr = this.front;
			
			while (counter < i) {
				prev = curr;
				curr = curr.next;
				counter = counter + 1;	
	
			}
			
			// Setting the pointers
			node.next = curr;
			node.previous = prev;
			curr.previous = node;
			prev.next = node;
					
		}
		
		// Incrementing the count, i.e. the number of nodes in the List
		this.count = this.count + 1;
					
	}
	
	public Integer removeFront () {
		/*
		 * ----------------------------------------------------------
		 * Removes explicitly from the front of the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value at the front of the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		// If the List is not empty, grab the value at the front, then update the list
		if (this.front != null) {
			value = this.front.value; // Grab front value
		
			// Update the front attribute to the next node
			if (this.count > 1) {
				this.front = this.front.next;
				this.front.previous = null;
				
			}
			
			// Set front and rear to null
			else {
				this.front = null;
				this.rear = null;
				
			}
		}
		
		this.count = this.count - 1; 
		
		return value;
	
	}
	
	public Integer remove (int key) {
		/*
		 * ----------------------------------------------------------
		 * Removes node containing key from the List (if key is repeated, first
		 * occurrence is removed)
		 * ----------------------------------------------------------
		 * O(n) Time Complexity with O(1) Special Cases
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value at index i of the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		// If the List is not empty, grab the value at the front, then update the list
		if (this.front != null) {
			dllNode curr = this.linearSearchLr(key); // Perform a Linear Search to find the node we want to remove
			
			// Checks if node with key value exists in the List
			if (curr != null) {
				value = curr.value; // Grab value
				
				// Special case: Only one item in the list exists
				if (this.count == 1) {
					this.front = null;
					this.rear = null;
				}
				
				// Special Case: curr is front node
				else if (curr == this.front){
					this.front = this.front.next;
					this.front.previous = null;
				}
				
				// Special Case: curr is rear node
				else if (curr == this.rear) {
					this.rear = this.rear.previous;
					this.rear.next = null;
				}
				
				// The General Case: Curr is elsewhere in the List
				else {
					dllNode prev = curr.previous;
					dllNode next = curr.next;
					prev.next = next;
					next.previous = prev;
					
				}
				
			this.count = this.count - 1;
			
			}
			
		}
		
		return value;
	
	}

	public Integer removeRear () {
		/*
		 * ----------------------------------------------------------
		 * Removes explicitly from the rear of the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value at the rear of the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		// If the List is not empty, grab the value at the front, then update the list
		if (this.rear != null) {
			value = this.rear.value; // Grab front value
		
			// Update the rear attribute to the previous node
			if (this.count > 1) {
				this.rear = this.rear.previous;
				this.rear.next = null;
				
			}
			
			// Set front and rear to null
			else {
				this.front = null;
				this.rear = null;
				
			}
			
		}
		
		this.count = this.count - 1; 
		
		return value;
	
	}
	
	public Integer peekFront() {
		/*
		 * ----------------------------------------------------------
		 * Peeks from the front of the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value at the front of the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		if (this.front != null){
			value = this.front.value;
		}
		
		return value;
	}
	
	public Integer peekRear() {
		/*
		 * ----------------------------------------------------------
		 * Peeks from the front of the List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value at the front of the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		if (this.rear != null){
			value = this.rear.value;
		}
		
		return value;
	}
	
	public Integer max() {
		/*
		 * ----------------------------------------------------------
		 * Finds the maximum value in the List
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Maximum value in the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer max = null;
		
		if (this.count >= 1) {
			dllNode curr = this.front;
			max = this.front.value;
			
			while (curr != null) {
				if (curr.value > max) {
					max = curr.value;
				}
				
				curr = curr.next;
			}
		}
	
		return max;
		
	}
	
	public Integer min() {
		/*
		 * ----------------------------------------------------------
		 * Finds the minimum value in the List
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Minimum value in the List, otherwise null.
		 * ----------------------------------------------------------
		 */
		
		Integer min = null;
		
		if (this.count >= 1) {
			dllNode curr = this.front;
			min = this.front.value;
			
			while (curr != null) {
				if (curr.value < min) {
					min = curr.value;
				}
				
				curr = curr.next;
			}
		}
		
		return min;
		
	}
	
	private dllNode linearSearchLr (int key) {
	    /*
	     * ----------------------------------------------------------
	     * Helper Method
	     * Performs a linear search on the List from left to right
	     * ----------------------------------------------------------
	     * O(n) Time Complexity
	     * ----------------------------------------------------------
	     * Returns:
	     *        The node containing key, null if not found
	     * ----------------------------------------------------------
	     */
	    
		dllNode prev = null;
	    dllNode curr = this.front;
	    boolean notFound = true;

	    // Searches the entire list for the node containing key; one node at a time.
	    while (curr != null && notFound == true) {
	    	if (curr.value == key) {
	    		// We found it; stop the loop by setting the boolean notFound to false.
	    		notFound = false;
	    	}
	    	
	    	else {
	    		// Traverse to the right.
	    		prev = curr;
	    		curr = curr.next;
	    	}
	    }
	    
	    // If boolean notFound is true, we've hit the end of the list and the node containing key is not in the list.
	    if (notFound == true) {
	    	curr = null;
	    }
	    	
	    return curr;

	}

	private dllNode linearSearchRl (int key) {
	    /*
	     * ----------------------------------------------------------
	     * Helper Method
	     * Performs a linear search on the List from right to left
	     * ----------------------------------------------------------
	     * O(n) Time Complexity
	     * ----------------------------------------------------------
	     * Returns:
	     *        The node containing key, null if not found
	     * ----------------------------------------------------------
	     */
	    
		dllNode prev = null;
	    dllNode curr = this.rear;
	    boolean notFound = true;
	    
	    // Searches the entire list for the node containing key; one node at a time.
	    while (curr != null && notFound == true) {
	    	if (curr.value == key) {
	    		// We found it; stop the loop by setting the boolean notFound to false.
	    		notFound = false;
	    	}
	    	
	    	else {
	    		// Traverse to the left.
	    		prev = curr;
	    		curr = curr.previous;
	    	}
	    }
	    
	    // If boolean notFound is true, we've hit the end of the list and the node containing key is not in the list.
	    if (notFound == true) {
	    	curr = null;
	    }
	    	
	    return curr;

	}
	
	private void swap (dllNode l, dllNode r) {
	    /*
	     * ----------------------------------------------------------
	     * Helper Method
	     * Swaps two nodes within the List. l takes place of r.
	     * r takes place of l. front and rear are updated as 
	     * appropriate. Data is not to be moved.
	     * ----------------------------------------------------------
	     * Only handles for the following cases:
	     *      1. Left and right are the same node.
	     *      2. Left is front, right is rear (and the reverse).
	     *      3. Left is front, right is not rear (and the reverse).
	     *      4. Right is rear, left is not front (and the reverse).
	     *      5. Neither left nor right is front or rear (general case).
	     *      6. Left is immediately beside right (and the reverse).
	     * ----------------------------------------------------------
	     * O(1) Time Complexity
	     * ----------------------------------------------------------
	     * Returns:
	     *        null
	     * ----------------------------------------------------------
	     */
	

		// Ensures that method is eligible to even swap nodes
		if (this.front != null && l != r && l != null && r != null) {
			dllNode lPrev = l.previous;
			dllNode lNext = l.next;
			dllNode rPrev = r.previous;
			dllNode rNext = r.next;
			
			// Special Case: If l is front and r is rear
			if (l == this.front && r == this.rear) {
				// Disconnecting l and r from the main list
				this.front = lNext;
				lNext.previous = null;
				
				this.rear = rPrev;
				rPrev.next = null;
				
				// Reattaching left on the rear
				this.rear.next = l;
				l.previous = this.rear;
				l.next = null;
				this.rear = l;
				
				// Reattaching right on the front
				this.front.previous = r;
				r.next = this.front;
				r.previous = null;
				this.front = r;
			}
			
			// Special Case: If r is front and l is rear
			else if (r == this.front && l == this.rear) {
				// Disconnecting l and r from the main list
				this.front = rNext;
				rNext.previous = null;
				
				this.rear = lPrev;
				lPrev.next = null;
				
				// Reattaching right on the rear
				this.rear.next = r;
				r.previous = this.rear;
				r.next = null;
				this.rear = r;
				
				// Reattaching left on the front
				this.front.previous = l;
				l.next = this.front;
				l.previous = null;
				this.front = l;
	
			}
			
			// Special Case: If l is front and r is not rear
			else if (l == this.front && r != this.rear) {
				// Disconnecting l and r from the main list
				this.front = lNext;
				lNext.previous = null;
				
				rPrev.next = r.next;
				rNext.previous = rPrev;
				
				// Reattaching left on where r was
				l.previous = rPrev;
				l.next = rNext;
				
				rPrev.next = l;
				rNext.previous = l;
				
				// Reattaching r on the front
				r.next = this.front;
				this.front.previous = r;
				this.front = r;
				
			}
			
			// Special Case: If r is front and l is not rear
			else if (r == this.front && l != this.rear) {
				// Disconnecting l and r from the main list
				this.front = rNext;
				rNext.previous = null;
				
				lPrev.next = l.next;
				lNext.previous = lPrev;
				
				// Reattaching right on where l was
				r.previous = lPrev;
				r.next = lNext;
				
				lPrev.next = r;
				lNext.previous = r;
				
				// Reattaching l on the front
				l.next = this.front;
				this.front.previous = l;
				this.front = l;
				
			}


			// Special Case: If next node to l is r
			else if (l.next == r) {
				// Disconnecting l and r from the main list
				lPrev.next = rNext;
				rNext.previous = lPrev;
				
				// Reattaching the nodes
				r.previous = lPrev;
				r.next = l;
				l.previous = r;
				l.next = rNext;
				lPrev.next = r;
				rNext.previous = l;
					
			}
			
			// Special Case: If next node to r is l
			else if (r.next == l) {
				// Disconnecting r and l from the main list
				rPrev.next = lNext;
				lNext.previous = rPrev;
				
				// Reattaching the nodes
				l.previous = rPrev;
				l.next = r;
				r.previous = l;
				r.next = lNext;
				rPrev.next = l;
				lNext.previous = r;
				
			}
			
			// The General Case: Excludes all cases from above
			else {
				// Disconnecting l and r from the main list
				lPrev.next = lNext;
				lNext.previous = lPrev;
				
				rPrev.next = rNext;
				rNext.previous = lPrev;
				
				// Reattaching the nodes
				r.previous = lPrev;
				r.next = lNext;
				
				lPrev.next = r;
				lNext.previous = r;
				
				l.previous = rPrev;
				l.next = rNext;
				
				rPrev.next = l;
				rNext.previous = l;
				
			}
		}
	}
	
	public void reverse () {
	    /*
	     * ----------------------------------------------------------
	     * Reverses the contents of the List (Recursive Algorithm).
	     * ----------------------------------------------------------
	     * O(n) Time Complexity
	     * ----------------------------------------------------------
	     * Returns:
	     *        null
	     * ----------------------------------------------------------
	     */
				
		int counter = 0;

		if (this.count > 1) {
			this.reverse_aux(this.front, this.rear, counter);
		}
	
	}
	
	private void reverse_aux(dllNode nodeLeft, dllNode nodeRight, int counter) {
	    /*
	     * ----------------------------------------------------------
	     * Auxiliary Function for reversing the contents of the List.
	     * ----------------------------------------------------------
	     * O(n) Time Complexity
	     * ----------------------------------------------------------
	     * Returns:
	     *        null
	     * ----------------------------------------------------------
	     */
		
		int countHalved = this.count / 2;
		
		if (counter < countHalved && nodeLeft != nodeRight) {
			this.reverse_aux(nodeLeft.next, nodeRight.previous, counter + 1);
			this.swap(nodeLeft, nodeRight);	
		}
	}
	
	public ArrayList splitAlt() {
	    /*
	     * ----------------------------------------------------------
	     * Splits the source list into separate target lists with values
	     * alternating into the targets. 
	     * The Target lists will be appended an returned within an ArrayList.
	     * ----------------------------------------------------------
	     * O(n) Time Complexity
	     * ----------------------------------------------------------
	     * Returns:
	     *        targetLists, which contains target1 and target2 (ArrayList)
	     * ----------------------------------------------------------
	     */
		
		doubleList target1 = new doubleList();
		doubleList target2 = new doubleList();		
		ArrayList targetLists = new ArrayList(); // Declares an ArrayList (much easier to work with as a standard Array in Java is of fixed size)	
		int counter = 0;
		
		if (this.count > 0) {
			while (this.count > 0) {
				if (counter % 2 == 0) {
					target1.moveFrontToRear(this);
				}
				
				else {
					target2.moveFrontToRear(this);
				}
		
				counter = counter + 1;	
			}
		}
			
		targetLists.add(target1);
		targetLists.add(target2);
		
		return targetLists;
	}
	
	private void moveFrontToRear(doubleList target) {
		/*
		 * ----------------------------------------------------------
		 * Moves the front node of the target List to the rear of the
		 * source List
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		// If target List is not empty, grab node at front, then update front
		if (target.front != null) {
			dllNode nodeTarget = target.front;			
			
			if (target.count > 1) {				
				target.front = target.front.next;
			
				if (target.front != null) {
					target.front.previous = null;
				}
			}
			
			else {
				target.front = null;
				target.rear = null;
			}
			
			target.count = target.count - 1;
			nodeTarget.next = null;
			
			// Appending target node to the end of the source List
			if (this.front != null) {
				this.rear.next = nodeTarget;
				nodeTarget.previous = this.rear;
				this.rear = nodeTarget;
			}
			
			else {
				this.front = nodeTarget;
				this.rear = nodeTarget;
			}
			
			this.count = this.count + 1;
			
		}
		
	}
	
	public void iter() {
		/*
		 * ----------------------------------------------------------
		 * A simple iterator that walks through the contents of the List (FOR TESTING PURPOSES ONLY)
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		dllNode curr = this.front;
		
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;

		}
	}
	
}

// Testing the List for errors
public class doublyLinkedList {
    public static void main(String[] args) {
        // Create an instance of doubleList
        doubleList list = new doubleList();

        // Test 1: Test isEmpty on a new list
        System.out.println("Test 1: Is Empty (expected: true): " + list.isEmpty());

        // Test 2: Prepend values and check list properties
        list.prepend(10);
        list.prepend(20);
        list.prepend(30);
        System.out.println("Test 2: Length after prepending (expected: 3): " + list.len());
        System.out.println("Test 2: Peek Front (expected: 30): " + list.peekFront());
        System.out.println("Test 2: Peek Rear (expected: 10): " + list.peekRear());

        // Test 3: Append values and check list properties
        list.append(40);
        list.append(50);
        System.out.println("Test 3: Length after appending (expected: 5): " + list.len());
        System.out.println("Test 3: Peek Front (expected: 30): " + list.peekFront());
        System.out.println("Test 3: Peek Rear (expected: 50): " + list.peekRear());

        // Test 4: Get and set items
        System.out.println("Test 4: Get item at index 2 (expected: 10): " + list.getitem(2));
        list.setitem(2, 15);
        System.out.println("Test 4: Get item at index 2 after setting (expected: 15): " + list.getitem(2));

        // Test 5: Insert values
        list.insert(2, 25);
        System.out.println("Test 5: Length after inserting at index 2 (expected: 6): " + list.len());
        System.out.println("Test 5: Get item at index 2 (expected: 25): " + list.getitem(2));

        // Test 6: Remove from front and rear
        System.out.println("Test 6: Remove front (expected: 30): " + list.removeFront());
        System.out.println("Test 6: Remove rear (expected: 50): " + list.removeRear());
        System.out.println("Test 6: Length after removals (expected: 4): " + list.len());

        // Test 7: Remove a specific item
        System.out.println("Test 7: Remove item with value 25 (expected: 25): " + list.remove(25));
        System.out.println("Test 7: Length after removing item (expected: 3): " + list.len());

        // Test 8: Check max and min values
        System.out.println("Test 8: Max value in the list (expected: 40): " + list.max());
        System.out.println("Test 8: Min value in the list (expected: 10): " + list.min());

        // Test 9: Reverse the list
        list.reverse();
        System.out.println("Test 9: Peek Front after reversing (expected: 40): " + list.peekFront());
        System.out.println("Test 9: Peek Rear after reversing (expected: 20): " + list.peekRear());
    }
}
