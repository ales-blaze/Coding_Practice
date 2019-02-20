package Tree.BST;

import java.util.Stack;

public class BST{
    private TreeNode root;
    private static Stack<TreeNode> stack;
//    void setRoot(TreeNode root){
//        this.root = root;
//    }
    public TreeNode getRoot(){
        return root;
    }

    //Todo : insertion , removal , traversal , min , max , searching

    public TreeNode searchNode(Integer value){
        return searchNodeWithValue(root , value);
    }

    private TreeNode searchNodeWithValue(TreeNode tempRoot  , Integer value){
        if(tempRoot != null){
            if(tempRoot.getValue() == value) return tempRoot;
            else if(tempRoot.getValue() > value){
                if(tempRoot.getLeftChild() != null){
                   return searchNodeWithValue(tempRoot.getLeftChild() ,value);
                }
                 else{ return null; }
            }
            else if(tempRoot.getValue() < value){
                if(tempRoot.getRightChild() != null){
                  return searchNodeWithValue(tempRoot.getRightChild(),value);
                }
                else{ return null; }
            }
        }
        return tempRoot;
    }

    //Insertion Operation
    public void insertNode(Integer value){
        insertNodeRecursively(root , value);
    }

    private void insertNodeRecursively(TreeNode root, Integer value) {
        if(root == null){
            root = new TreeNode(value);
            this.root = root;
            return;
        }
        else {
            if(root.getValue() > value){
                if(root.getLeftChild() != null){
                    insertNodeRecursively(root.getLeftChild() , value);
                }
                else{
                    //insert node
                    TreeNode newNode = new TreeNode(value);
                    root.setLeftChild(newNode);
                    return;
                }
            }
            else {
                if(root.getRightChild() != null){
                    insertNodeRecursively(root.getRightChild() , value);
                }
                else{
                    //insert a node at the right side
                    TreeNode newNode = new TreeNode(value);
                    root.setRightChild(newNode);
                    return;
                }
            }
        }
    }

    public void preOrder(){
        TreeNode treeNode = this.root;
        stack = new Stack<>();
        stack.push(null);

        while(treeNode != null) {
            System.out.print(treeNode.getValue() + " ");
            if (treeNode.getRightChild() != null) {
                stack.push(treeNode.getRightChild());
            }
            if (treeNode.getLeftChild() != null) {
                treeNode = treeNode.getLeftChild();
            } else{
                treeNode = stack.pop();
            }
        }
    }

    public void inOrder() {
        TreeNode treeNode = this.root;
        stack = new Stack<>();
        stack.push(null);

        treeNode = LeftTraverse(treeNode);
        while (treeNode != null) {
            System.out.print(treeNode.getValue() + " ");
            if (treeNode.getRightChild() != null) {
                treeNode = treeNode.getRightChild();
                treeNode = LeftTraverse(treeNode);
            } else {
                treeNode = stack.pop();
            }
        }
    }

    public void postOrder(){
        stack = new Stack<>();
        stack.push(null);
        TreeNode treeNode = this.root;
        while(treeNode != null || !stack.isEmpty()) {
            if(stack.peek() == null) stack.pop();
            while (treeNode != null) {
                //left side travesin'
                stack.push(treeNode);
                if (treeNode.getRightChild() != null) {
                    stack.push(treeNode);
                }
                treeNode = treeNode.getLeftChild();
            }
            //Backtrackin'
            treeNode = stack.pop();
            if (stack.peek() == treeNode) {
                treeNode = treeNode.getRightChild();
            } else {
                System.out.print(treeNode.getValue() + " ");
                treeNode = null;
            }
        }
        System.out.println();
    }

    private TreeNode LeftTraverse(TreeNode treeNode) {
        while (treeNode != null) {
            stack.push(treeNode);
            treeNode = treeNode.getLeftChild();
        }
        treeNode = stack.pop();
        return treeNode;
    }

    //return the maximum value in the tree
    public TreeNode max() {
        TreeNode tempRoot = root;
        while(tempRoot.getRightChild() != null){
            tempRoot = tempRoot.getRightChild();
        }
        return tempRoot;
    }
    //return the minimum value in the tree
    public TreeNode min(){
        TreeNode tempRoot = root;
        while(tempRoot.getLeftChild() != null){
            tempRoot = tempRoot.getLeftChild();
        }
        return tempRoot;
    }

    public TreeNode remove(Integer value){
         root = removeRecursively(root ,value);
         return root;
    }

    private TreeNode removeRecursively(TreeNode root, Integer value) {
        if (root == null) return root;
        else if (root.getValue() > value) {
            root.setLeftChild(removeRecursively(root.getLeftChild(), value));
        } else if (root.getValue() < value) {
            root.setRightChild(removeRecursively(root.getRightChild(), value));
        } else {
            //the desired value is found
            if (root.getRightChild() == null && root.getLeftChild() == null) {
                return null;
                //delete the root object
                //set root to null
                //return root
            } else if (root.getLeftChild() != null && root.getRightChild() != null) {
//                TreeNode tempRoot = root.getRightChild();
                TreeNode inOrderSuccessor = findInOrderSuccessor(root.getRightChild());             //Swappin' of values
                root.setValue(inOrderSuccessor.getValue());
                root.setRightChild(removeRecursively(root.getRightChild() , root.getValue()));
            } else if (root.getRightChild() != null) {
                return root.getRightChild();
                //make right child of root , the right child of parent of root
                //delete the root node
            } else if (root.getLeftChild() != null) {
                return root.getLeftChild();
                //make left child of root , the left child parent of the root
                //delete the root node
            }
        }
        return root;
    }

    private TreeNode findInOrderSuccessor(TreeNode temp) {
        while(temp.getLeftChild() != null){
            temp = temp.getLeftChild();
        }
        return temp;
    }
}