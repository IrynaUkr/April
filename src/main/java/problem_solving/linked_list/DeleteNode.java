package problem_solving.linked_list;

public class DeleteNode {
    public static void deleteNode(ListNode node) {
       // Copy the value of the next node to the current node
        node.val = node.next.val;
        // Bypass the next node
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        deleteNode(node2);


        ListNode current = node1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

}
