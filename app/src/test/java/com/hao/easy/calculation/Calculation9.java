package com.hao.easy.calculation;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import javax.xml.transform.Source;

/**
 * @author Yang Shihao
 * <p>
 * 给定一个二叉树的根节点，请按行从上到下Z字形（即如果第n行是从左至右打印的，则从右至左打印第n+1行），
 * 打印出该二叉树所有节点的值
 */
public class Calculation9 {

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

        printIntZ(t1);

    }

    private void printIntZ(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(root);
        boolean left2Right = true;
        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                Iterator<TreeNode> iterator;
                if (left2Right) {
                    iterator = queue.iterator();
                } else {
                    iterator = queue.descendingIterator();
                }
                left2Right = !left2Right;
                while (iterator.hasNext()) {
                    TreeNode temp = iterator.next();
                    System.out.println(temp.value);
                }
                System.out.println();
                queue.addLast(null);
                continue;
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
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
