package seven;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
 * 从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer22 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        Offer22 offer22 = new Offer22();
        ListNode kthFromEnd = offer22.getKthFromEnd(one, 1);
        System.out.println(kthFromEnd);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int node = 0;
        while (fast != null && node < k) {
            fast = fast.next;
            node++;
        }
        if (fast == null && node != k) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}