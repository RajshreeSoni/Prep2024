public class PartitionLL {
    public static ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode list1 = head1;
        ListNode list2 = head2;
        ListNode current = head;
        while(current != null) {
            if (current.val < x) {
                list1.next = current;
                list1 = list1.next;
            } else {
                list2.next = current;
                list2 = list2.next;
            }
            current = current.next;
        }
        list1.next = head2.next;
        list2.next = null;
        return head1.next;
    }

    public static void main(String args[]) {
        // [1,4,3,2,5,2]
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode.printLL(partition(head, 3));
    }
}
