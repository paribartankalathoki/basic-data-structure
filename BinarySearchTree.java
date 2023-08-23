/**
 * @author:- Paribartan Kalathoki
 * @created on:- 22 Aug, 2023 at 08:52 PM
 */

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    public TreeNode search(TreeNode root, int item) {
        if (root == null || item == root.data) {
            return root;
        } else if (item < root.data) {
            return search(root.left, item);
        } else {
            return search(root.right, item);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(50);

        int itemToSearch = 25;
        TreeNode resultNode = bst.search(root, itemToSearch);

        if (resultNode != null) {
            System.out.println("Item " + itemToSearch + " found in the BST.");
        } else {
            System.out.println("Item " + itemToSearch + " not found in the BST.");
        }
    }
}
