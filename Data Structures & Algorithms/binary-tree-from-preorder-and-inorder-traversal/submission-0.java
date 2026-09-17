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
    HashMap<Integer, Integer> inorderIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int j=0;j<inorder.length;j++){
            inorderIndex.put(inorder[j],j);
        }
        return build(preorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int left, int right){
        if(left>right){
            return null;
        }
        int rootValue = preorder[i++];
        TreeNode root = new TreeNode(rootValue);
        int middle = inorderIndex.get(rootValue);
        root.left = build(preorder,left, middle-1);
        root.right = build(preorder, middle+1, right);
        return root;
    }
}
