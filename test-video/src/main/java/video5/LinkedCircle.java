package video5;

import beans.Node;

/**
 * 1.链表是否又换
 * 2.如果有环，则找出环节点
 */
public class LinkedCircle {
    public static void main(String[] args) {
        Node node = buildCycleNode();
        //1.链表是否有环
        System.out.println(hasCycle(node));

        Node firstCycleNode = getFirstCycleNode(node);
        if (firstCycleNode != null) {
            System.out.println(firstCycleNode.i);
        }
    }

    //获取环形链表的第一个节点
    public static Node getFirstCycleNode(Node node) {
        Node cycleNode = getCycleNode(node);
        if (cycleNode == null) {
            return null;
        }
        Node first = node;
        Node p = cycleNode;
        while (first != p) {
            first = first.next;
            p = p.next;
        }
        return p;
    }

    //是否有环
    public static boolean hasCycle(Node node) {
        Node cycleNode = getCycleNode(node);
        return cycleNode != null;
    }

    //原理：快慢指针
    public static Node getCycleNode(Node node) {
        if (node == null || node.next == null) {
            return null;
        }
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }


    public static Node buildCycleNode() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = six;
        return one;
    }
}
