package video5;

import beans.TreeNode;
import utils.BinaryTree;

import java.util.Stack;

/**
 * 二叉树非递归遍历
 * 二叉树的非递归遍历都是借助栈实现
 */
public class BinaryTreeErgodic {


    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.buildTree();
//        pre(treeNode);
//        middle(treeNode);
        after(treeNode);
    }

    //后序为双栈法 先左后右
    public static void after(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> printStack = new Stack<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            printStack.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!printStack.isEmpty()) {
            TreeNode pop = printStack.pop();
            System.out.print(pop.i + "\t");
        }
    }

    //中序遍历，先到达最左边位置
    public static void middle(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> temp = new Stack<>();
        while (!temp.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                temp.push(treeNode);
                treeNode = treeNode.left;
            } else if (!temp.isEmpty()) {
                treeNode = temp.pop();
                System.out.print(treeNode.i + "\t");
                treeNode = treeNode.right;
            }
        }
    }

    //先右后左
    public static void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> temp = new Stack<>();
        temp.push(treeNode);
        while (!temp.isEmpty()) {
            TreeNode pop = temp.pop();
            System.out.print(pop.i + "\t");
            if (pop.right != null) {
                temp.push(pop.right);
            }
            if (pop.left != null) {
                temp.push(pop.left);
            }
        }
    }
}
