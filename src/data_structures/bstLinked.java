/*
 * -------------------------------------------------------
 * Binary Search Tree ADT
 * -------------------------------------------------------
 * Author: Shiraz Qasmi
 * ID: 169036233
 * Email: qasm6233@mylaurier.ca
 * __updated__ = "2024-08-28"
 * -------------------------------------------------------
 */

package data_structures;

import java.util.ArrayList;

class treeNode {
	int value;
	treeNode left;
	treeNode right;
	int height = 0;

	// Constructor
	treeNode(int newData, treeNode left, treeNode right) {
		/*
		 * ----------------------------------------------------------
		 * Initializes a BST node
		 * ----------------------------------------------------------
		 * O(1) Time Complexity, i.e., constant time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		this.value = newData;
		this.left = left;
		this.right = right;
	}
	
	void updateHeight() { // While the outside world is not to to have access to the node class internally, I have not declared it private, nor public, 
						   // so that it can be used during the insertion process in a BST.
		/*
		 * ----------------------------------------------------------
		 * Updates the height of a BST node. Height is 1 plus the maximum
		 * of the node's (up to) two child heights. 
		 * ----------------------------------------------------------
		 * O(1) Time Complexity, i.e., constant time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
		
		int leftHeight = 0;
		int rightHeight = 0;
		
		// Grabbing the height of the left node
		if (this.left != null) {
			leftHeight = this.left.height;
		}
		if (this.right != null) {
			rightHeight = this.right.height;
		}
		
		// Updates the maximum height of the node
		this.height = Math.max(leftHeight, rightHeight) + 1;
	}
}

class BST {
		
	treeNode root;
	int count;

    BST() {
    	// Constructor of the BST
        this.root = null;
        this.count = 0;
    }

	public boolean isEmpty() {
		/*
		 * ----------------------------------------------------------
		 * Checks if the BST is empty
		 * ----------------------------------------------------------
		 * O(1) Time Complexity, i.e., constant time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        True if empty, False otherwise (boolean)
		 * ----------------------------------------------------------
		 */

		boolean boolEmpty = (this.root == null);
		return boolEmpty;
	}
	
	public int len() {
		/*
		 * ----------------------------------------------------------
		 * Returns the number of items in the BST
		 * ----------------------------------------------------------
		 * O(1) Time Complexity, i.e., constant time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        count - The number of nodes in the BST (int)
		 * ----------------------------------------------------------
		 */
		
		return this.count; 
		
	}

	public void insert (int value) {
		/*
		 * ----------------------------------------------------------
		 * Inserts data into the BST
		 * ----------------------------------------------------------
		 * O(log(n)) Time Complexity, i.e., logarithmic time complexity 
		 * with O(n) Time Complexity, i.e., linear time complexity if BST
		 * resembles Linked List (Recursive Algorithm)
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */
				
		this.root = this.insertAux(this.root, value);
		
	}
	
	private treeNode insertAux (treeNode node, int value) {
		/*
		 * ----------------------------------------------------------
		 * Auxiliary function that inserts a value into a BST.
		 * ----------------------------------------------------------
		 * O(log(n)) Time Complexity, i.e., logarithmic time complexity 
		 * with O(n) Time Complexity, i.e., linear time complexity if BST
		 * resembles Linked List
		 * ----------------------------------------------------------
		 * Returns:
		 *        null
		 * ----------------------------------------------------------
		 */		
		
		boolean inserted = false;

		if (node == null) {
			// Base Case: Adding new node to the BST
			node = new treeNode(value, null, null);
			this.count = this.count + 1;
			inserted = true;
		}
		
		else if (value < node.value) {
			// The General Case: Recursively traverse to the left of the BST
			node.left = insertAux(node.left, value);
		}
		
		else if (value > node.value) {
			// The General Case: Recursively traverse to the right of the BST
			node.right = insertAux(node.right, value);
		}
		
		else {
			// Base Case: node already exists in the BST
			System.out.println("Error: Value " + value + " already exists in the BST");
		}
		
		node.updateHeight();
				
		return node;
	}
	
	private boolean retrieveBoolean(int key) {
		/*
		 * ----------------------------------------------------------
		 * Checks if a value matching key exists in the BST.
		 * Private Helper Method
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        in_bst - True if a value exists in a BST, False
		 *        otherwise (boolean)
		 * ----------------------------------------------------------
		 */		
		
		treeNode node = root;
		boolean inBst = false;
		
		while (node != null) {
			
			if (node.value > key) {
				node = node.left;
			}
			
			else if (node.value < key) {
				node = node.right;
			}
			
			else {
				inBst = true;
			}
			
		}
	
		return inBst; 
	}
	

	public ArrayList preorderTraversal() {
		/*
		 * ----------------------------------------------------------
		 * function that performs an pre order traversal and appends all
		 * values into an ArrayList (Recursive Algorithm).
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        pre order - List of values from the BST pre order (ArrayList)
		 * ----------------------------------------------------------
		 */		
		
		ArrayList preorder = new ArrayList(); // Declares an ArrayList (much easier to work with as a standard Array in Java is of fixed size)		
		
		if (this.root != null) {
			preorder = preorderTraversalAux(this.root, preorder); // Auxiliary Function			
		}
		
		return preorder;
	}
	
	private ArrayList preorderTraversalAux(treeNode node, ArrayList preorder) {
		/*
		 * ----------------------------------------------------------
		 * Auxiliary function that performs a preorder traversal and
		 * appends all values into an ArrayList.
		 * ----------------------------------------------------------
		 * O(n) Time Complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        preorder - List of values from the BST preorder (ArrayList) 
		 * ----------------------------------------------------------
		 */	
		
		
		if (node != null) {
			preorder.add(node.value); // Append the current value to the list
			preorderTraversalAux(node.left, preorder); // Recursively traverse to the left of the BST
			preorderTraversalAux(node.right, preorder); // Recursively traverses to the right of the BST
		}
			
		return preorder;
	}
	
	public ArrayList inorderTraversal() {
		/*
		 * ----------------------------------------------------------
		 * function that performs an inorder traversal and appends all
		 * values into an ArrayList (Recursive Algorithm).
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        inorder - List of values from the BST inorder (ArrayList)
		 * ----------------------------------------------------------
		 */		
		
		ArrayList inorder = new ArrayList(); // Declares an ArrayList (much easier to work with as a standard Array in Java is of fixed size)		
		
		if (this.root != null) {
			inorder = inorderTraversalAux(this.root, inorder); // Auxiliary Function			
		}

		return inorder;
	}
	
	private ArrayList inorderTraversalAux(treeNode node, ArrayList inorder) {
		/*
		 * ----------------------------------------------------------
		 * Auxiliary function that performs an inorder traversal and
		 * appends all values into an ArrayList.
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        inorder - List of values from the BST inorder (ArrayList) 
		 * ----------------------------------------------------------
		 */	
		
		
		if (node != null) {
			inorderTraversalAux(node.left, inorder); // Recursively traverse to the left of the BST
			inorder.add(node.value); // Append the current value to the list
			inorderTraversalAux(node.right, inorder); // Recursively traverses to the right of the BST
		}
			
		return inorder;
	}
	
	public ArrayList postorderTraversal() {
		/*
		 * ----------------------------------------------------------
		 * function that performs an postorder traversal and appends all
		 * values into an ArrayList  (Recursive Algorithm).
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        postorder - List of values from the BST postorder (ArrayList)
		 * ----------------------------------------------------------
		 */		
		
		ArrayList postorder = new ArrayList(); // Declares an ArrayList (much easier to work with as a standard Array in Java is of fixed size)		
		
		if (this.root != null) {
			postorder = postorderTraversalAux(this.root, postorder); // Auxiliary Function			
		}
		
		return postorder;
	}
	
	private ArrayList postorderTraversalAux(treeNode node, ArrayList postorder) {
		/*
		 * ----------------------------------------------------------
		 * Auxiliary function that performs an postorder traversal and
		 * appends all values into an ArrayList.
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        postorder - List of values from the BST postorder (ArrayList) 
		 * ----------------------------------------------------------
		 */	
		
		
		if (node != null) {
			postorderTraversalAux(node.left, postorder); // Recursively traverse to the left of the BST
			postorderTraversalAux(node.right, postorder); // Recursively traverses to the right of the BST
			postorder.add(node.value); // Append the current value to the list
		}
			
		return postorder;
	}
	
	public Integer totalHeight() {
		/*
		 * ----------------------------------------------------------
		 * Calculates the total heights of a BST.
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        total - The sum of all node heights in the BST, else null (Integer) 
		 * ----------------------------------------------------------
		 */	
		
		Integer total = 0;
		
		if (this.count > 0) {
			total = this.totalHeightAux(this.root, total);
		}
		
		return total;
	}
	
	
	private int totalHeightAux(treeNode node, int total) {
		/*
		 * ----------------------------------------------------------
		 * Auxiliary function that calculates the total heights of a BST.
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        total - The sum of all node heights in the BST (int) 
		 * ----------------------------------------------------------
		 */	
		
		
		if (node != null) {
			total = node.height + this.totalHeightAux(node.left, total) + this.totalHeightAux(node.right, total); 
		}
		
		return total;
	}
	
	public ArrayList flip() {
		/*
		 * ----------------------------------------------------------
		 * Flips the contents of the BST. Returns a list of the BST inorder.
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        flipped - An ArrayList consisting of the contents of the BST flipped (Integer) 
		 * ----------------------------------------------------------
		 */	
		
		ArrayList flipped = new ArrayList();
		
		// If BST is not empty, perform flip
		if (this.count > 0) {
			this.flip(this.root);
			flipped = this.inorderTraversalAux(this.root, flipped);
		}
		
		return flipped;
		
	}
	
	private void flip(treeNode node) {
		/*
		 * ----------------------------------------------------------
		 * Flips the contents of the BST. 
		 * ----------------------------------------------------------
		 * O(n) Time Complexity, i.e., linear time complexity
		 * ----------------------------------------------------------
		 * Returns:
		 *        null 
		 * ----------------------------------------------------------
		 */	
		
		if (node != null) {
			// Perform a simple swap
			treeNode flip = node.left;
			node.left = node.right;
			node.right = flip;
			
			// Recursively traverse to the left and right subtree
	        this.flip(node.left);
	        this.flip(node.right);
			
		}			
	}
	
}

//Testing the BST for errors 
public class bstLinked {
    public static void main(String[] args) {
        // Create an instance of BST
        BST myBST = new BST();

        // Test 1: Check if the BST is initially empty
        System.out.println("Test 1: Is Empty (expected: true): " + myBST.isEmpty());

        // Test 2: Insert values into the BST
        myBST.insert(15);
        myBST.insert(10);
        myBST.insert(20);
        myBST.insert(8);
        myBST.insert(12);
        myBST.insert(17);
        myBST.insert(25);
        System.out.println("Test 2: Length after inserting 7 items (expected: 7): " + myBST.len());

        // Test 3: Perform Inorder Traversal (expected output: 8, 10, 12, 15, 17, 20, 25)
        ArrayList<Integer> inorder = myBST.inorderTraversal();
        System.out.print("Test 3: Inorder Traversal (expected: [8, 10, 12, 15, 17, 20, 25]): ");
        System.out.println(inorder);

        // Test 4: Perform Preorder Traversal (expected output: 15, 10, 8, 12, 20, 17, 25)
        ArrayList<Integer> preorder = myBST.preorderTraversal();
        System.out.print("Test 4: Preorder Traversal (expected: [15, 10, 8, 12, 20, 17, 25]): ");
        System.out.println(preorder);

        // Test 5: Perform Postorder Traversal (expected output: 8, 12, 10, 17, 25, 20, 15)
        ArrayList<Integer> postorder = myBST.postorderTraversal();
        System.out.print("Test 5: Postorder Traversal (expected: [8, 12, 10, 17, 25, 20, 15]): ");
        System.out.println(postorder);

        // Test 6: Insert a duplicate value (expected: error message)
        myBST.insert(15); // Trying to insert a value that already exists

        // Test 7: Perform all traversals after inserting duplicates
        System.out.print("Test 7: Inorder Traversal after duplicate insert (expected: [8, 10, 12, 15, 17, 20, 25]): ");
        System.out.println(myBST.inorderTraversal());

        System.out.print("Test 7: Preorder Traversal after duplicate insert (expected: [15, 10, 8, 12, 20, 17, 25]): ");
        System.out.println(myBST.preorderTraversal());

        System.out.print("Test 7: Postorder Traversal after duplicate insert (expected: [8, 12, 10, 17, 25, 20, 15]): ");
        System.out.println(myBST.postorderTraversal());

        // Test 9: Length after all operations
        System.out.println("Test 8: Length after all operations (expected: 7): " + myBST.len());
        
        // Test 8: Test totalHeight (expected height for root node is 3)
        System.out.println("Test 8: Total height of the BST (expected: 3): " + myBST.totalHeight());

        // Test 9: Perform flip (mirroring the tree)
        myBST.flip();
        System.out.print("Test 9: Inorder Traversal after flip (expected: [25, 20, 17, 15, 12, 10, 8]): ");
        System.out.println(myBST.inorderTraversal());

        System.out.print("Test 9: Preorder Traversal after flip (expected: [15, 20, 25, 17, 10, 12, 8]): ");
        System.out.println(myBST.preorderTraversal());

        System.out.print("Test 9: Postorder Traversal after flip (expected: [25, 17, 20, 12, 8, 10, 15]): ");
        System.out.println(myBST.postorderTraversal());

        // Test 10: Test totalHeight after flip (height should remain unchanged, expected: 3)
        System.out.println("Test 10: Total height of the BST after flip (expected: 3): " + myBST.totalHeight());
    }
}
