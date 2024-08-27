package data_structures;

import java.util.ArrayList;

public class bstTest {
    public static void main(String[] args) {
    	BST test_bst = new BST();
    	BST empty_bst = new BST();
    	
    	ArrayList preorder_empty = empty_bst.preorderTraversal();
    	// Inserting elements into the BST
    	System.out.println("Inserted the following numbers to the BST: 11, 7, 15, 6, 9, 12, 18, 8, 8");
    	test_bst.insert(11);
    	test_bst.insert(7);
    	test_bst.insert(15);
    	test_bst.insert(6);
    	test_bst.insert(9);
    	test_bst.insert(12);
    	test_bst.insert(18);
    	test_bst.insert(8);
    	test_bst.insert(8);

    	System.out.println();
    	System.out.println("-------------------------------------------------------");
    	System.out.println();

    	// Testing out different traversal methods that utilize Recursion
    	System.out.println("Preorder Traversal:");
    	ArrayList preorder = test_bst.preorderTraversal();
    	System.out.println(preorder);
    	System.out.println();
    	
    	System.out.println("Inorder Traversal:");
    	ArrayList inorder = test_bst.inorderTraversal();
    	System.out.println(inorder);
    	System.out.println();
    	
    	System.out.println("Postorder Traversal:");
    	ArrayList postorder = test_bst.postorderTraversal();
    	System.out.println(postorder);
    	System.out.println();
    	System.out.println("-------------------------------------------------------");

    }
}
