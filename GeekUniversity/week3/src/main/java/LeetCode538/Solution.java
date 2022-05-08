package LeetCode538;

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
public class Solution {
    //原中序遍历单调递增，反中序遍历单调递减
    //题目要求node.val(new) = node.val(old)+sum(node.rightchild(new));

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root!=null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
