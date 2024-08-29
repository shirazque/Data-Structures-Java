/*
 * -------------------------------------------------------
 * Testing the Doubly Linked List ADT
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-29"
 * -------------------------------------------------------
 */

package data_structures;

import java.util.ArrayList;

public class doublyLinkedListTest {
    public static void main(String[] args) {
    	doubleList testDoublyList = new doubleList();
    	
    	
    	// Prepending, Appending, and Inserting into the Linked List
    	System.out.println("Appended, Prepended, Inserted");
    	System.out.println("");
    	testDoublyList.append(5);
    	testDoublyList.insert(0, 100);
    	testDoublyList.insert(2, 100);
    	testDoublyList.insert(1, 100);
    	testDoublyList.insert(3, 500);
    	testDoublyList.insert(-1, -1);
    	testDoublyList.insert(-2, -102);
    	testDoublyList.prepend(3);
    	System.out.println("Traversing the contents of the List");
    	testDoublyList.iter();
    	System.out.println("");
    	
    	// Removing values from the List
    	Integer valueFront = testDoublyList.removeFront();
    	Integer valueRear = testDoublyList.removeRear();
    	Integer valueMiddle = testDoublyList.remove(5);
    	System.out.println("Removed front: " + valueFront);
    	System.out.println("Removed rear: " + valueRear);
    	System.out.println("Removed: " + valueMiddle);
    	System.out.println("");
    	System.out.println("Traversing the contents of the List");
    	testDoublyList.iter();
    	System.out.println("");
    	
    	// Setting items and reversing the contents of the List
    	System.out.println("Reversed the contents of the List and setting item @ index -1 to 5: ");
    	testDoublyList.setitem(-1, 5);
    	testDoublyList.reverse();
    	testDoublyList.iter();
    	System.out.println("");
    	Integer getValue = testDoublyList.getitem(3);
    	System.out.println("Getting item at index 3: " + getValue);
    	System.out.println("");
    	System.out.println("Splitting the contents of the List into alternating target Lists appended to an ArrayList:");
    	System.out.println("");
    	ArrayList splitTest = testDoublyList.splitAlt();
    	System.out.println("target1:");
    	((doubleList)splitTest.get(0)).iter();
    	System.out.println("");
    	System.out.println("target2");
    	((doubleList)splitTest.get(1)).iter();
    	System.out.println("");

    }
}
