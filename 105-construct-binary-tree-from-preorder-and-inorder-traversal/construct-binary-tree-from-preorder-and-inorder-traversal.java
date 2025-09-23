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
    int i=0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

         for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        TreeNode root= buildTreeHelper(preorder,0,inorder.length-1);
        return root;
        
    }


    public TreeNode buildTreeHelper( int[] preorder, int start, int end)
    {
        if(start>end)
        return null;
        
        TreeNode root= new TreeNode(preorder[i]);
        int rootIndex=map.get(root.val);
        i++;
        root.left=buildTreeHelper(preorder,start,rootIndex-1);
        root.right=buildTreeHelper(preorder,rootIndex+1,end);

        return root;
    }
}
