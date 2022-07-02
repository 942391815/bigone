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
        System.out.println(palindromeByArray(node));
    }

    public static Node buildNode() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        return one;
    }

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
