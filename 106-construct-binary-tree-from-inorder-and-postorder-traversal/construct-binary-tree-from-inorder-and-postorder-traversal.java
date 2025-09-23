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
    int i;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i=postorder.length-1;

         for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        TreeNode root= buildTreeHelper(postorder,0,inorder.length-1);
        return root;
        
    }


    public TreeNode buildTreeHelper( int[] preorder, int start, int end)
    {
        if(start>end)
        return null;
        
        TreeNode root= new TreeNode(preorder[i]);
        int rootIndex=map.get(root.val);
        i--;
        root.right=buildTreeHelper(preorder,rootIndex+1,end);
        root.left=buildTreeHelper(preorder,start,rootIndex-1);
        

        return root;
    }
}
