/*
 * -------------------------------------------------------
 * Linked version of the Queue ADT (Rudimentary)
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-27"
 * -------------------------------------------------------
 */

package data_structures;

class queueNode {
	int value;
	queueNode next;

	// Constructor
	queueNode(int newData, queueNode pointer) {
		/*
		 * ----------------------------------------------------------
		 * Initializes a Queue node
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		this.value = newData;
		this.next = pointer;
	}
}

class queue {
	queueNode front;
	queueNode rear;
	int count;
    
	queue() {
    	// Constructor of the Queue
        this.front = null;
        this.rear = null;
        this.count = 0;
    }
	
	public boolean isEmpty() {
		/*
		 * ----------------------------------------------------------
		 * Checks if the Queue is empty
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
		 * Returns the number of items in the Queue
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        count - The number of nodes in the Queue (int)
		 * ----------------------------------------------------------
		 */
		
		return this.count; 
	}

	public void insert(Integer value) {
		/*
		 * ----------------------------------------------------------
		 * Inserts data into the queue
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		queueNode node = new queueNode(value, null);
		
		if (this.count == 0) {
			this.front = this.rear = node;
		}
		
		else {
			this.rear.next = node;
			this.rear = this.rear.next;
		}
		
		this.count = this.count + 1;
		
		return;
	}

	public int remove() {
		/*
		 * ----------------------------------------------------------
		 * Pops from the Queue
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value - The value from the front of the Queue (int)
		 * ----------------------------------------------------------
		 */

		Integer value = null;
		
		if (this.front != null) {
			value = this.front.value;
			
			if (this.count > 1) {
				this.front = this.front.next;
			}
			
			else {
				this.front = this.rear = null;
			}
		
			this.count = this.count - 1;
		}
		
		return value;
	}

	public int peek() {
		/*
		 * ----------------------------------------------------------
		 * Peeks from the Queue; null return indicates Queue is empty, otherwise int
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value - the value from the front of the Queue (int)
		 * ----------------------------------------------------------
		 */
		
		Integer value = null;
		
		if (this.front != null) {
			value = this.front.value;
		}
		
		return value;
	
	}

	public void iter() {
		/*
		 * ----------------------------------------------------------
		 * A simple iterator that walks through the contents of the Queue (FOR TESTING PURPOSES ONLY)
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		queueNode curr = this.front;
		
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;

		}
	}
	
}

//Testing the Queue for errors (Written by GPT-4o)
public class queueLinked {
    public static void main(String[] args) {
        // Create an instance of queue
        queue myQueue = new queue();

        // Test 1: Check if the queue is initially empty
        System.out.println("Test 1: Is Empty (expected: true): " + myQueue.isEmpty());

        // Test 2: Insert values into the queue
        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);
        System.out.println("Test 2: Length after inserting 3 items (expected: 3): " + myQueue.len());

        // Safely peek the front item only if the queue is not empty
        if (!myQueue.isEmpty()) {
            System.out.println("Test 2: Peek front item (expected: 10): " + myQueue.peek());
        } else {
            System.out.println("Test 2: Peek on empty queue (expected: N/A)");
        }

        // Test 3: Remove values from the queue
        if (!myQueue.isEmpty()) {
            System.out.println("Test 3: Remove front item (expected: 10): " + myQueue.remove());
        } else {
            System.out.println("Test 3: Remove on empty queue (expected: N/A)");
        }

        System.out.println("Test 3: Length after removing 1 item (expected: 2): " + myQueue.len());

        // Safely peek the front item only if the queue is not empty
        if (!myQueue.isEmpty()) {
            System.out.println("Test 3: Peek front item (expected: 20): " + myQueue.peek());
        } else {
            System.out.println("Test 3: Peek on empty queue (expected: N/A)");
        }

        // Test 4: Continue removing to empty the queue
        if (!myQueue.isEmpty()) {
            System.out.println("Test 4: Remove front item (expected: 20): " + myQueue.remove());
        } else {
            System.out.println("Test 4: Remove on empty queue (expected: N/A)");
        }

        if (!myQueue.isEmpty()) {
            System.out.println("Test 4: Remove front item (expected: 30): " + myQueue.remove());
        } else {
            System.out.println("Test 4: Remove on empty queue (expected: N/A)");
        }

        System.out.println("Test 4: Length after removing all items (expected: 0): " + myQueue.len());
        System.out.println("Test 4: Is Empty (expected: true): " + myQueue.isEmpty());

        // Test 5: Peek and Remove on an empty queue
        if (!myQueue.isEmpty()) {
            System.out.println("Test 5: Peek on empty queue (expected: N/A): " + myQueue.peek());
        } else {
            System.out.println("Test 5: Peek on empty queue (expected: Queue is empty)");
        }

        if (!myQueue.isEmpty()) {
            System.out.println("Test 5: Remove on empty queue (expected: N/A): " + myQueue.remove());
        } else {
            System.out.println("Test 5: Remove on empty queue (expected: Queue is empty)");
        }

        // Test 6: Insert and iterate through the queue
        myQueue.insert(40);
        myQueue.insert(50);
        myQueue.insert(60);
        System.out.println("Test 6: Iterating through queue (expected: 40, 50, 60):");
        myQueue.iter(); // Should print 40, 50, 60

        // Test 7: Length after multiple operations
        System.out.println("Test 7: Length after multiple operations (expected: 3): " + myQueue.len());
    }
}

