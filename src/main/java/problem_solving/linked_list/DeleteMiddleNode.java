package problem_solving.linked_list;

public class DeleteMiddleNode {
    public static ListNode deleteMiddle(ListNode head) {
        //define dummy node to have a pointer to the head
        ListNode dummy = new ListNode(0, head);
        // move to pointers one two times faster
        ListNode right = head;
        ListNode left = dummy;
        while (right != null && right.next != null) {
            right = right.next.next;
            left = left.next;
        }
        //delete
        left.next = left.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node11 = deleteMiddle(node5);


        ListNode current = node11;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

}
