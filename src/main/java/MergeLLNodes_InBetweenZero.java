public class MergeLLNodes_InBetweenZero {

    public static ListNode mergeNodes(ListNode head) {
        ListNode newHead = head;
        ListNode newLL = newHead;
        ListNode current = head;
        while (current != null) {
            int sumTillNextZero = 0;
            if (current.val == 0) {
                current = current.next;
                while (current != null && current.val != 0) {
                    sumTillNextZero = sumTillNextZero + current.val;
                    current = current.next;
                }
            }
            if (sumTillNextZero != 0) {
                newLL.next = new ListNode(sumTillNextZero);
                newLL = newLL.next;
            }
        }
        return newHead.next;
    }

    public static void main(String args[]) {
        // [0,3,1,0,4,5,2,0]
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode.printLL(mergeNodes(head));
    }


}
