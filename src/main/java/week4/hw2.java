package week4;

public class hw2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        LinkedList ll = new LinkedList();
        ll.add(head, new ListNode(0), 3);
        ll.printNode(head);

        ll.add(head, new ListNode(4), 1);
        ll.printNode(head);

        ll.add(head, new ListNode(3), 9);
        ll.add(head, new ListNode(2), 9);
        ll.add(head, new ListNode(1), 9);
        ll.printNode(head);

        ll.remove(head,1);
        ll.printNode(head);

        ll.remove(head,3);
        ll.printNode(head);

    }
}
