package foundation.video5;

import beans.Node;

/**
 * 两条链表是否相交
 * 原理：查看链表的长度
 */
public class LinkedIntersect {
    public static void main(String[] args) {
        //单链表相交肯定是Y字型
    }

    public static boolean intersect(Node one, Node two) {
        if (one == null || two == null) {
            return false;
        }
        int oneLen = 0;
        int twoLen = 0;
        while (one != null) {
            oneLen++;
            one = one.next;
        }
        while (two != null) {
            twoLen++;
            two = two.next;
        }

        if (oneLen > twoLen) {
            while (oneLen - twoLen > 0) {
                one = one.next;
                oneLen--;
            }
        } else {
            while (twoLen - oneLen > 0) {
                one = one.next;
                twoLen--;
            }
        }

        while (one != null && two != null) {
            if (one != two) {
                one = one.next;
                two = two.next;
            } else {
                return true;
            }
        }
        return false;
    }
}
