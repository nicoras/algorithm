package LeetCode106;

import java.util.HashMap;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //记录inorder中的node索引，方便查找
        ioIndex = new HashMap(inorder.length);
        for(int i=0;i<inorder.length;i++){
            ioIndex.put(inorder[i],i);
        }
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    //<inorder node value,inorder node index>
    public HashMap<Integer,Integer> ioIndex= null;
    //从中序和后序数组的指定范围生成树
    public TreeNode build(int[] inorder, int[] postorder,int iol,int ior,int pol,int por){
        //先序遍历根，左，右
        //中序遍历左，根，右
        //后序遍历左，右，根
        if(pol>por){
            return null;
        }
        //System.out.println(iol+"_"+ior+"_"+pol+"_"+por);
        //先根据postorder找到根节点，然后根据inorder找到左子树
        int poroot = postorder[por];
        //找到inorder中root的位置
        int iorootIdx = ioIndex.get(poroot);
        //System.out.println("porroot:"+poroot+"_index:"+iorootIdx);
        //左子树的元素个数
        int lccount = iorootIdx-iol;
        //右子树元素个数
        int rccount = ior-iorootIdx;
        //System.out.println("lccount:"+lccount+"rccount:"+rccount);
        TreeNode root = new TreeNode(poroot);
        //中序遍历左边界->根-1=后序遍历左边界->左边界+子树个数-1
        if(lccount>0){
            root.left = build(inorder,postorder,iol,iorootIdx-1,pol,pol+lccount-1);
        }
        if(rccount>0){
            //中序遍历根+1->右边界=后序遍历左边界+左子树个数->根(右边界)-1
            root.right = build(inorder,postorder,iorootIdx+1,ior,pol+lccount,por-1);
        }


        return root;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}