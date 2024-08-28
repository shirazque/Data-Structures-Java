/*
 * -------------------------------------------------------
 * Linked version of the Priority Queue ADT (Rudimentary)
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-28"
 * -------------------------------------------------------
 */

package data_structures;

class pqNode {
	int value;
	pqNode next;

	// Constructor
	pqNode(int newData, pqNode pointer) {
		/*
		 * ----------------------------------------------------------
		 * Initializes a pq_node 
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

class priorityQueue {
	pqNode front;
	pqNode rear;
	int count;
    
	priorityQueue() {
    	// Constructor of the Priority Queue
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

		boolean boolEmpty = (this.front == null);
		return boolEmpty;
	}
	
	public int len() {
		/*
		 * ----------------------------------------------------------
		 * Returns the number of items in the Priority Queue
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        count - The number of nodes in the Priority Queue (int)
		 * ----------------------------------------------------------
		 */
		
		return this.count; 
	}

	public void insert(Integer value) {
		/*
		 * ----------------------------------------------------------
		 * Inserts data into the Priority Queue
		 * ----------------------------------------------------------
		 * O(n) Time Complexity with O(1) Special Cases
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		pqNode node = new pqNode(value, null);
		
		// Special Case: Queue is empty
		if (this.count == 0) {
			this.front = this.rear = node;
		}
		
		// Special Case: Value is smaller than the front value of the Queue
		else if (value < this.front.value) {
			node.next = this.front;
			this.front = node;
		}
		
		// Special Case: Value is greater than the rear value of the Queue
		else if (value > this.rear.value) {
			this.rear.next = node;
			this.rear = node;
		}
		
		else {
			// The General Case: Value is to be placed somewhere within the Queue (i.e., excludes special cases)
			pqNode prev = null;
			pqNode curr = this.front;
		
			while (value >= curr.value) {
				prev = curr;
				curr = curr.next;
			}
			
			node.next = curr;
			prev.next = node;			
		}

		this.count = this.count + 1;
		
		return;
	}

	public int remove() {
		/*
		 * ----------------------------------------------------------
		 * Pops from the Priority Queue
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value - The value from the front of the Priority Queue (int)
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
		 * Peeks from the Priority Queue; null return indicates Priority Queue is empty, otherwise int
		 * ----------------------------------------------------------
		 * O(1) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        Value - the value from the front of the Priority Queue (int)
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
		 * A simple iterator that walks through the contents of the Priority Queue (FOR TESTING PURPOSES ONLY)
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */

		pqNode curr = this.front;
		
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;

		}
	}
	
}

//Testing the Priority Queue for errors
public class priorityQueueLinked {
    public static void main(String[] args) {
        // Create an instance of priorityQueue
        priorityQueue myPQ = new priorityQueue();

        // Test 1: Check if the priority queue is initially empty
        System.out.println("Test 1: Is Empty (expected: true): " + myPQ.isEmpty());

        // Test 2: Insert values into the priority queue
        myPQ.insert(15);
        myPQ.insert(10);
        myPQ.insert(20);
        myPQ.insert(5);
        System.out.println("Test 2: Length after inserting 4 items (expected: 4): " + myPQ.len());

        // Safely peek the front item only if the priority queue is not empty
        if (!myPQ.isEmpty()) {
            System.out.println("Test 2: Peek front item (expected: 5): " + myPQ.peek());
        } else {
            System.out.println("Test 2: Peek on empty priority queue (expected: N/A)");
        }

        // Test 3: Remove values from the priority queue
        if (!myPQ.isEmpty()) {
            System.out.println("Test 3: Remove front item (expected: 5): " + myPQ.remove());
        } else {
            System.out.println("Test 3: Remove on empty priority queue (expected: N/A)");
        }

        System.out.println("Test 3: Length after removing 1 item (expected: 3): " + myPQ.len());

        // Safely peek the front item only if the priority queue is not empty
        if (!myPQ.isEmpty()) {
            System.out.println("Test 3: Peek front item (expected: 10): " + myPQ.peek());
        } else {
            System.out.println("Test 3: Peek on empty priority queue (expected: N/A)");
        }

        // Test 4: Continue removing to empty the priority queue
        if (!myPQ.isEmpty()) {
            System.out.println("Test 4: Remove front item (expected: 10): " + myPQ.remove());
        } else {
            System.out.println("Test 4: Remove on empty priority queue (expected: N/A)");
        }

        if (!myPQ.isEmpty()) {
            System.out.println("Test 4: Remove front item (expected: 15): " + myPQ.remove());
        } else {
            System.out.println("Test 4: Remove on empty priority queue (expected: N/A)");
        }

        if (!myPQ.isEmpty()) {
            System.out.println("Test 4: Remove front item (expected: 20): " + myPQ.remove());
        } else {
            System.out.println("Test 4: Remove on empty priority queue (expected: N/A)");
        }

        System.out.println("Test 4: Length after removing all items (expected: 0): " + myPQ.len());
        System.out.println("Test 4: Is Empty (expected: true): " + myPQ.isEmpty());

        // Test 5: Peek and Remove on an empty priority queue
        if (!myPQ.isEmpty()) {
            System.out.println("Test 5: Peek on empty priority queue (expected: N/A): " + myPQ.peek());
        } else {
            System.out.println("Test 5: Peek on empty priority queue (expected: Priority queue is empty)");
        }

        if (!myPQ.isEmpty()) {
            System.out.println("Test 5: Remove on empty priority queue (expected: N/A): " + myPQ.remove());
        } else {
            System.out.println("Test 5: Remove on empty priority queue (expected: Priority queue is empty)");
        }

        // Test 6: Insert and iterate through the priority queue
        myPQ.insert(25);
        myPQ.insert(35);
        myPQ.insert(30);
        System.out.println("Test 6: Iterating through priority queue (expected: 25, 30, 35):");
        myPQ.iter(); // Should print 25, 30, 35

        // Test 7: Length after multiple operations
        System.out.println("Test 7: Length after multiple operations (expected: 3): " + myPQ.len());
    }
}
