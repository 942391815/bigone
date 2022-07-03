package video5;

import beans.TreeNode;
import utils.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层级遍历
 */
public class BinaryTreeLevelPrint {
    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.buildTree();
        levelPrint(treeNode);
    }

    public static void levelPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();

        list.add(treeNode);
        while (!list.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode each : list) {
                cur.add(each.i);
                if (each.left != null) {
                    next.add(each.left);
                }
                if (each.right != null) {
                    next.add(each.right);
                }
            }
            result.add(cur);
            list = next;
        }
        for (List<Integer> each : result) {
            System.out.println(each);
        }
    }
}
