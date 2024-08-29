/*
 * -------------------------------------------------------
 * Testing the Stack ADT
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-29"
 * -------------------------------------------------------
 */

package data_structures;

public class stackTest {
    public static void main(String[] args) {
        stack testStack = new stack();
        stack additionalStack = new stack();
        
        // Pushing elements onto the Stack
        testStack.push(0);
        testStack.push(4);
        testStack.push(9);
        testStack.push(18);
        testStack.push(12);

        // Printing out the contents of the Stack
        System.out.println("Printing out the contents of the Stack:");
        System.out.println("");
        testStack.iter();
        System.out.println("");

        // Popping from the Stack
        Integer val = testStack.pop();
        System.out.println();
        System.out.println("Popped value from Stack: " + val);

        // Peeking from the Stack
        Integer peek_val = testStack.peek();
        System.out.println("Peeked value from the Stack: " + peek_val);

        // Printing out the contents of the Stack
        System.out.println();
        System.out.println("Printing out the contents of the Stack:");
        System.out.println("");
        testStack.iter();
        System.out.println("");
    }
}
