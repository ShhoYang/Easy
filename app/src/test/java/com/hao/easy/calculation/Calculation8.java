package com.hao.easy.calculation;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Yang Shihao
 * <p>
 * 给定一个二叉树，请写一个函数输出该二叉树的镜像（最简单的镜像，就是根节点不变，其左右孩子互换位置），
 * 要求不得使用递归
 */
public class Calculation8 {

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
        TreeNode t6 = new TreeNode(6, t12, t13);
        TreeNode t7 = new TreeNode(7, t14, t15);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);

        TreeNode t1 = new TreeNode(1, t2, t3);


        print(t1);

        System.out.println();

        print(mirror(t1));
    }

    private void print(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.value);
            print(treeNode.left);
            print(treeNode.right);
        }
    }

    private TreeNode mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            while (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                stack.push(node);
                node = node.left;
            }

            if (stack.size() > 0) {
                node = stack.pop();
                node = node.right;
            }
        }
        return root;
    }


    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
