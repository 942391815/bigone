package video3;

import beans.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表是否回文
 */
public class LinkedPalindrome {
    public static void main(String[] args) {
        Node node = buildNode();
//        System.out.println(palindromeByArray(node));
        System.out.println(palindrome(node));
    }

    public static Node buildNode() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(2);
        Node four = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        return one;
    }

    /**
     * 不借助空间处理
     *
     * @param node
     * @return
     */
    public static boolean palindrome(Node node) {
        if (node == null) {
            return false;
        }
        //1.获取链表的中间节点
        Node middleNode = getMiddleNode(node);
        //2.以中间节点为轴心翻转后半部分节点
        Node reverseNode = reverseNode(middleNode);
        while (node != null && reverseNode != null) {
            if (node.i != reverseNode.i) {
                return false;
            }
            node = node.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    public static Node reverseNode(Node node) {
        Node pre = null;
        if (node == null) {
            return null;
        }

        while (node != null) {
            Node temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

    /**
     * 获取链表的中间节点
     *
     * @param node
     * @return
     */
    public static Node getMiddleNode(Node node) {
        Node slow = node;

        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = slow.next.next;
        }
        return slow;
    }

    /**
     * 借助数组空间
     *
     * @param node
     * @return
     */
    public static boolean palindromeByArray(Node node) {
        if (node == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.i);
            node = node.next;
        }
        int size = list.size();
        int loops = size / 2;
        int i = 0;
        while (i < loops) {
            if (list.get(i) != list.get(size - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
