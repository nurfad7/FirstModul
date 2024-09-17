package structure;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int val) {
        this.root = insertBranch(this.root, val);
    }

    private TreeNode insertBranch(TreeNode root, int val) {
        if(isEmpty(root)) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.val) {
            root.left = insertBranch(root.left, val);
        } else if (val > root.val) {
            root.right = insertBranch(root.right, val);
        }
        return root;
    }

    public boolean search(int val) {
        return searchBranch(this.root, val);
    }

    private boolean searchBranch(TreeNode root, int val) {
        if(isEmpty(root)) {
            return false;
        }
        if(root.val == val) {
            return true;
        }
        if(val > root.val) {
            return searchBranch(root.right, val);
        }
        return searchBranch(root.left, val);
    }

    public boolean isEmpty(TreeNode root) {
        return root == null;
    }
}
