package com.hao.easy.calculation;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Yang Shihao
 * <p>
 * 给定一个二叉树的根节点，请写一个函数判断该二叉树是否是平衡二叉树
 * （平衡二叉树的定义是一颗二叉树，其任意节点的左右子树的深度相差不超过1）
 */
public class Calculation10 {

    @Test
    public void calculation() {
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);

        TreeNode t4 = new TreeNode(4, t8, t9);
        TreeNode t5 = new TreeNode(5, t10, t11);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(isBalanced(t1));
        //System.out.println(isBalanced2(t1));

    }

    /**
     * 这个方法效率不高，因为从上往下，下层的节点会被遍历多次
     *
     * @param treeNode
     * @return
     */
    private boolean isBalanced(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        System.out.println();
        int leftDepth = treeDepth(treeNode.left);
        int rightDepth = treeDepth(treeNode.right);
        int diff = leftDepth - rightDepth;
        if (diff < -1 || diff > 1) {
            return false;
        }

        return isBalanced(treeNode.left) && isBalanced(treeNode.right);
    }

    private int treeDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftDepth = treeDepth(treeNode.left);
        int rightDepth = treeDepth(treeNode.right);
        System.out.println(treeNode.value + ":" + leftDepth + "---" + rightDepth);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    /**
     * 从下往上遍历
     *
     * @param treeNode
     * @return
     */
    public boolean isBalanced2(TreeNode treeNode) {
        return isBalancedInner(treeNode, new Depth());
    }

    int i = 0;

    private boolean isBalancedInner(TreeNode treeNode, Depth depth) {
        System.out.println(i++);
        if (treeNode == null) {
            depth.depth = 0;
            return true;
        }

        Depth leftDepth = new Depth();
        Depth rightDepth = new Depth();

        if (isBalancedInner(treeNode.left, leftDepth) && isBalancedInner(treeNode.right, rightDepth)) {
            //System.out.println(treeNode.value + ":" + leftDepth.depth + "---" + rightDepth.depth);
            int diff = leftDepth.depth - rightDepth.depth;
            if (diff >= -1 && diff <= 1) {
                depth.depth = 1 + (leftDepth.depth > rightDepth.depth ? leftDepth.depth : rightDepth.depth);
                return true;
            }
        }

        return false;
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        int depth;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    class Depth {
        int depth;
    }
}
