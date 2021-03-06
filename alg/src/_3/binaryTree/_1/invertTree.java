package _3.binaryTree._1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226.翻转二叉树
 *
 * 翻转一棵二叉树。
 */
public class invertTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    //层次遍历翻转左右子树
    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }


}
