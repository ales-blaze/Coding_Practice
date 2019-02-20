package Tree.BST;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
BST bst;
    @Before
    public void setUp() throws Exception {
        bst = new BST();
        bst.insertNode(50);
        bst.insertNode(100);
        bst.insertNode(25);
        bst.insertNode(15);
        bst.insertNode(30);
        bst.insertNode(150);
        bst.insertNode(90);
    }

    @Test
    public void searchNode() {
        TreeNode temp = bst.searchNode(15);
        int value = temp.getValue();
        assertEquals(15 , value);
    }

    @Test
    public void insertNode() {
        bst.inOrder();
        System.out.println();
        bst.preOrder();
        bst.postOrder();
    }

    @Test
    public void max() {
        int value = bst.max().getValue();
        assertEquals( 150 , value);
    }

    @Test
    public void min() {
        int value = bst.min().getValue();
        assertEquals( 15 , value);
    }

    @Test
    public void remove() {
        bst.remove(15);
        int value = bst.min().getValue();
        assertEquals(25 , value);

        bst.remove(25);
        int value1 = bst.min().getValue();
        assertEquals(30 , value1);

        bst.remove(100);
        int value2 = bst.max().getValue();
        assertEquals(150 , value2);
    }
}