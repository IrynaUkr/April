package problem_solving.linked_list;
//https://www.youtube.com/watch?v=XVuQxVej6y8&ab_channel=NeetCode

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //assign dummy to cover the case where we need to delete a head
        ListNode dummy = new ListNode(0, head);
        // define two pointers with the n distance  between them, to find the node we want to delete
        // the right pointer stops at the end of the node chain, and the left will stop at the distance of N
        ListNode left = dummy;
        // move right  to the  'head+n' node:
        ListNode right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }
        //move both pointers
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        //delete -> remove the pointer from prev to bypass it
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
        ListNode node11 = removeNthFromEnd(node1, 6);


        ListNode current = node11;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

}
