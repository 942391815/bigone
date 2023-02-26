package middle.video2;

/**
 * 给定一个非负整数n,代表二叉树的节点个数。返回能形成多少种不同的二叉树
 */
public class NumOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(getNumOfBinaryTree(3));
        System.out.println(getNumOfBinaryTreeV2(3));

    }

    /**
     * 分析：假如有一个节点 则只有一种方式 就是头结点
     * 如果说有两个节点，则除了头结点 剩余的一个节点可以位于左子树也可以位于右子树，有两种方式
     * 如果有N个节点则f(n) = f(i)*f(n-i-1) 应为是左子树的数量*右子树的数量；因为子树任何节点的不同就是一种不同的树
     *
     * @param node 节点个数
     * @return
     */
    public static long getNumOfBinaryTree(long node) {
        if (node < 0) {
            return 0;
        }
        if (node == 0) {
            return 1;
        }
        if (node == 1) {
            return 1;
        }
        if (node == 2) {
            return 2;
        }
        long result = 0;
        //左树可以取到N-1个因为除了头结点还有N-1个，全部可以用于左子树
        for (long leftNumber = 0; leftNumber <= node - 1; leftNumber++) {
            long left = getNumOfBinaryTree(leftNumber);
            long right = getNumOfBinaryTree(node - leftNumber - 1);
            result = result + left * right;
        }
        return result;
    }

    public static long getNumOfBinaryTreeV2(int num) {
        int dp[] = new int[num + 1];
        dp[0] = 1;
        for (int i = 1; i <= num; i++) {
            for (int leftNode = 0; leftNode <= i - 1; leftNode++) {
                dp[i] = dp[i] + dp[leftNode] * dp[i - leftNode - 1];
            }
        }
        return dp[num];
    }
}
