class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        if (leftDepth == rightDepth) {
            // It's a full binary tree
            return (1 << leftDepth) - 1; // 2^height - 1
        } else {
            // Not full, recurse
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getLeftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int getRightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}
