package foundation.video5;

import beans.TreeNode;
import utils.BinaryTree;

/**
 * 二叉树递归遍历
 */
public class BinaryTreeErgodicRecursion {


    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.buildTree();
//        pre(treeNode);
//        middle(treeNode);
//        after(treeNode);
    }

    public static void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.i + "\t");
        pre(treeNode.left);
        pre(treeNode.right);
    }

    public static void middle(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        middle(treeNode.left);
        System.out.print(treeNode.i + "\t");
        middle(treeNode.right);
    }

    public static void after(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        after(treeNode.left);
        after(treeNode.right);
        System.out.print(treeNode.i + "\t");
    }
}
