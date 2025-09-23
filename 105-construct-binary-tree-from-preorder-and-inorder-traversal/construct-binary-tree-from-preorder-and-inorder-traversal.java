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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        TreeNode root= buildTreeHelper(preorder,inorder);
        return root;
        
    }


    public TreeNode buildTreeHelper( int[] preorder, int [] inorder)
    {
        if(inorder.length==0 )
        return null;
        TreeNode root= new TreeNode(preorder[i]);
        List<Integer> left =extractLeftPart(root.val,inorder);
        int leftA[]=new int[left.size()];
        for(int i=0; i<leftA.length; i++)
        {
            leftA[i]=left.get(i);
        }
        List<Integer> right=extractRightPart(root.val,inorder); 
        int rightA[]=new int[right.size()];
        for(int i=0; i<rightA.length; i++)
        {
            rightA[i]=right.get(i);
        }

       
        i++;
        root.left=buildTreeHelper(preorder,leftA);
        root.right=buildTreeHelper(preorder,rightA);

        return root;
    }
public List<Integer> extractLeftPart(int num,int [] inorder){
    int rootIndex=ls(num,inorder);
    List<Integer> left= new ArrayList<>();
    for(int i=0; i<rootIndex; i++)
    {
        left.add(inorder[i]);
    }
    return left;
}
public List<Integer> extractRightPart(int num,int [] inorder){
    int rootIndex=ls(num,inorder);
    List<Integer> right= new ArrayList<>();
    for(int i=rootIndex+1; i<inorder.length; i++)
    {
        right.add(inorder[i]);
    }
    return right;
}

    public static int ls(int num, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) {
                return i;  // found
            }
        }
        return -1; // not foun
}
}