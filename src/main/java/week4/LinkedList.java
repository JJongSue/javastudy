package week4;

public class LinkedList {
    ListNode add(ListNode head, ListNode nodeToAdd, int position){
        if(position == 0){
            nodeToAdd.next = head;
            return nodeToAdd;
        }

        ListNode now = head;
        for (int i = 1; i < position; i++) {
            // 다음이 없을 경우, 그 삽입
            if(now.next == null) {
                now.next = nodeToAdd;
                return head;
            }
            now = now.next;
        }
        nodeToAdd.next = now.next;
        now.next = nodeToAdd;
        return head;
    }
    ListNode remove(ListNode head, int positionToRemove){
        if(positionToRemove == 0){
            return head.next;
        }

        ListNode now = head;
        for (int i = 1; i < positionToRemove; i++) {
            // 다음이 없을 경우, 그 삽입
            if(now.next.next == null) {
                now.next = null;
                return head;
            }
            now = now.next;
        }
        now.next = now.next.next;


        return head;
    }
    boolean contains(ListNode head, ListNode nodeTocheck){
        ListNode now = head;
        while(now != null){
            if(now.val == nodeTocheck.val) return true;
        }
        return false;
    }

    void printNode(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
