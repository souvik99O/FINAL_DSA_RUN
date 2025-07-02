/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = inorderMap.get(root.val);

        

        int leftInorder[] = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftInorder[i] = inorder[i];
        }
        int leftPreorder[] = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftPreorder[i] = preorder[i + 1];
        }

        int rightInorder[] = new int[inorder.length - mid - 1];
        int j = 0;
        for (int i = mid + 1; i < inorder.length; i++) {
            rightInorder[j] = inorder[i];
            j++;
        }
        int rightPreorder[] = new int[inorder.length - mid - 1];
        int k = 0;
        for (int i = mid + 1; i < preorder.length; i++) {
            rightPreorder[k] = preorder[i];
            k++;
        }

        TreeNode left = buildTree(leftPreorder, leftInorder);
        TreeNode right = buildTree(rightPreorder, rightInorder);

        root.left = left;
        root.right = right;

        return root;

    }
}