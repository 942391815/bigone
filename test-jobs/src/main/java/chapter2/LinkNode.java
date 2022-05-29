package chapter2;

public class LinkNode {
    int node;
    LinkNode next;

    public LinkNode(int node) {
        this.node = node;
    }

    public LinkNode(int node, LinkNode next) {
        this.next = next;
        this.node = node;
    }

}
