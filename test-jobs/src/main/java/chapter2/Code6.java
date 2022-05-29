package chapter2;

/**
 * 从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头发过来打印出每个节点的值
 */
public class Code6 {
    public static void main(String[] args) {
        LinkNode linkNode = buildNode();
//        LinkNode newNode = reverseNode(linkNode);
//        printNode(newNode);
        recursion(linkNode);
    }

    static LinkNode buildNode() {
        LinkNode one = new LinkNode(1);
        LinkNode two = new LinkNode(2);
        LinkNode three = new LinkNode(3);
        LinkNode four = new LinkNode(4);
        LinkNode five = new LinkNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        return one;
    }

    //递归方式打印链表
    static void recursion(LinkNode node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            recursion(node.next);
        }
        System.out.println(node.node);
    }

    static void printNode(LinkNode linkNode) {
        while (linkNode != null) {
            System.out.println(linkNode.node);
            linkNode = linkNode.next;
        }
    }

    //翻转单链表进行打印
    static LinkNode reverseNode(LinkNode node) {
        if (node == null) {
            return null;
        }
        LinkNode pre = null;
        while (node != null) {
            LinkNode temp = node.next;
            //重置指针
            node.next = pre;

            //后序下一个节点
            pre = node;
            node = temp;
        }
        return pre;
    }
}
