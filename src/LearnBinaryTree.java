public class LearnBinaryTree {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Level 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Level 3
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);

        // Level 4
        root.left.left.right.left = new TreeNode(13);

        System.out.print("In order traversal: ");
        inorderTraversal(root);
        System.out.println();

        System.out.print("Pre order traversal: ");
        preorderTraversal(root);
        System.out.println();

        System.out.print("Post order traversal: ");
        postorderTraversal(root);
        System.out.println();

        System.out.println("Tree sum = " + treeSum(root));

        System.out.println("Tree max = " + treeMax(root));

        System.out.println("Tree height = " + treeHeight(root));

        int val = 2;
        System.out.println("Is number " + val + " exists in tree? " + existsInTree(root, val));

        int val2 = 100;
        System.out.println("Is number " + val2 + " exists in tree? " + existsInTree(root, val2));

        System.out.print("Reverse tree:");
        reverseTree(root);
        System.out.println();
        System.out.print("(Reversed tree) In order traversal: ");
        inorderTraversal(root);
        System.out.println();

        System.out.print("(Reversed tree) Pre order traversal: ");
        preorderTraversal(root);
        System.out.println();

        System.out.print("(Reversed tree) Post order traversal: ");
        postorderTraversal(root);
        System.out.println();
    }

    static void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    static void preorderTraversal(TreeNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    static void postorderTraversal(TreeNode node) {
        if (node == null) return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    static int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftSum = treeSum(root.left);
            int rightSum = treeSum(root.right);
            return root.value + leftSum + rightSum;
        }
    }

    static int treeMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            int leftMax = treeMax(root.left);
            int rightMax = treeMax(root.right);
            return Math.max(root.value, Math.max(leftMax, rightMax));
        }
    }

    static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    static boolean existsInTree(TreeNode root, int val) {
        if (root == null) {
            return false;
        } else {
            boolean existsInLeft = existsInTree(root.left, val);
            boolean existsInRight = existsInTree(root.right, val);
            return root.value == val || existsInLeft || existsInRight;
        }
    }

    static void reverseTree(TreeNode root) {
        if (root == null) return;

        reverseTree(root.left);
        reverseTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
