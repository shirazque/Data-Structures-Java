/*
 * -------------------------------------------------------
 * Testing the Queue ADT
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-28"
 * -------------------------------------------------------
 */

package data_structures;

public class queueTest {
    public static void main(String[] args) {
    	queue test_queue = new queue();
    	
    	// Checking if queue is empty
    	boolean empty = test_queue.isEmpty();
    	System.out.println("The queue is empty: " + empty);
    	
    	// Inserting numbers
    	System.out.println();
    	System.out.println("Inserted the following numbers: 7, 9, 3, 1, 5");    	
    	test_queue.insert(7);
    	test_queue.insert(9);
    	test_queue.insert(3);
    	test_queue.insert(1);
    	test_queue.insert(5);
    	System.out.println();
    	
    	// Printing the contents of the queue
    	test_queue.iter();
    	System.out.println();
    	
    	// Checking if queue is empty
    	boolean empty_after = test_queue.isEmpty();
    	System.out.println("The queue is empty: " + empty_after);
    	
    	// Removing from queue
    	int value = test_queue.remove();
    	System.out.println();
    	System.out.println("Removed value: " + value);
    	System.out.println();
    	
    	// Printing the contents of the queue
    	test_queue.iter();
    	System.out.println();
    	
    	// Peeking from the Queue:
    	int value_peek = test_queue.peek();
    	System.out.println("Peeked value: " + value_peek);
    	
    }
}
