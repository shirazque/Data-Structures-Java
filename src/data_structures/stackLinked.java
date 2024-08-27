/*
 * -------------------------------------------------------
 * Linked version of the Stack ADT (Rudimentary)
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-19"
 * -------------------------------------------------------
 */

package data_structures;

class stackNode {
	int value;
	stackNode next;

	// Constructor
	stackNode(int new_data, stackNode pointer) {
		/*
		 * ----------------------------------------------------------
		 * Initializes a Stack node
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		this.value = new_data;
		this.next = pointer;
	}
}

class stack {
	stackNode top;
	int count;
    
	stack() {
    	// Constructor of the BST
        this.top = null;
        this.count = 0;
    }
	
	public boolean isEmpty() {
		/*
		 * ----------------------------------------------------------
		 * Checks if the Stack is empty
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        True if empty, False otherwise (boolean)
		 * ----------------------------------------------------------
		 */

		boolean boolEmpty = this.top == null;
		return boolEmpty;
	}
	
	public int len() {
		/*
		 * ----------------------------------------------------------
		 * Returns the number of items in the Stack
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        count - The number of nodes in the Stack (int)
		 * ----------------------------------------------------------
		 */
		
		return this.count; 
	}

	public void push(Integer value) {
		/*
		 * ----------------------------------------------------------
		 * Pushes data onto the Stack
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		// Declares a new node, then links it to the top, then updates top
		this.top = new stackNode(value, this.top);
		this.count = this.count + 1;
		
		return;
	}

	public int pop() {
		/*
		 * ----------------------------------------------------------
		 * Pops from the Stack
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value - The value from the top of the Stack (int)
		 * ----------------------------------------------------------
		 */

		Integer value = null;
		
		// Extracting the data and updating top
		if (this.top != null) {
			value = this.top.value;
			this.top = this.top.next;
			this.count = this.count - 1;			
		}

		return value;
	}

	public int peek() {
		/*
		 * ----------------------------------------------------------
		 * Peeks from the Stack; null return indicates Stack is empty, otherwise int
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value - the value from the top of the Stack (int)
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		if (this.top != null) {
			value = this.top.value;
			
		}
		
		return value;
	
	}

	public void iter() {
		/*
		 * ----------------------------------------------------------
		 * A simple iterator that walks through the contents of the Stack (FOR TESTING PURPOSES ONLY)
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		stackNode curr = this.top;
		
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;

		}
	}

}

// Testing the Stack for errors (Written by GPT-4o)
public class stackLinked {
    public static void main(String[] args) {
        // Create an instance of stack
        stack myStack = new stack();

        // Test 1: Check if the stack is initially empty
        System.out.println("Test 1: Is Empty (expected: true): " + myStack.isEmpty());

        // Test 2: Push values onto the stack
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println("Test 2: Length after pushing 3 items (expected: 3): " + myStack.len());
        
        // Safely peek the top item only if the stack is not empty
        if (!myStack.isEmpty()) {
            System.out.println("Test 2: Peek top item (expected: 30): " + myStack.peek());
        } else {
            System.out.println("Test 2: Peek on empty stack (expected: N/A)");
        }

        // Test 3: Pop values from the stack
        if (!myStack.isEmpty()) {
            System.out.println("Test 3: Pop top item (expected: 30): " + myStack.pop());
        } else {
            System.out.println("Test 3: Pop on empty stack (expected: N/A)");
        }

        System.out.println("Test 3: Length after popping 1 item (expected: 2): " + myStack.len());
        
        // Safely peek the top item only if the stack is not empty
        if (!myStack.isEmpty()) {
            System.out.println("Test 3: Peek top item (expected: 20): " + myStack.peek());
        } else {
            System.out.println("Test 3: Peek on empty stack (expected: N/A)");
        }

        // Test 4: Continue popping to empty the stack
        if (!myStack.isEmpty()) {
            System.out.println("Test 4: Pop top item (expected: 20): " + myStack.pop());
        } else {
            System.out.println("Test 4: Pop on empty stack (expected: N/A)");
        }
        
        if (!myStack.isEmpty()) {
            System.out.println("Test 4: Pop top item (expected: 10): " + myStack.pop());
        } else {
            System.out.println("Test 4: Pop on empty stack (expected: N/A)");
        }

        System.out.println("Test 4: Length after popping all items (expected: 0): " + myStack.len());
        System.out.println("Test 4: Is Empty (expected: true): " + myStack.isEmpty());

        // Test 5: Peek and Pop on an empty stack
        if (!myStack.isEmpty()) {
            System.out.println("Test 5: Peek on empty stack (expected: N/A): " + myStack.peek());
        } else {
            System.out.println("Test 5: Peek on empty stack (expected: Stack is empty)");
        }
        
        if (!myStack.isEmpty()) {
            System.out.println("Test 5: Pop on empty stack (expected: N/A): " + myStack.pop());
        } else {
            System.out.println("Test 5: Pop on empty stack (expected: Stack is empty)");
        }

        // Test 6: Push and iterate through stack
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        System.out.println("Test 6: Iterating through stack (expected: 60, 50, 40):");
        myStack.iter(); // Should print 60, 50, 40

        // Test 7: Length after multiple operations
        System.out.println("Test 7: Length after multiple operations (expected: 3): " + myStack.len());
        
    }
}
