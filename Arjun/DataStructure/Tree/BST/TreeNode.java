package Tree.BST;

public class TreeNode{
    private Integer value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(){

    }
    public TreeNode(Integer value){
        this.setValue(value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value){
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
