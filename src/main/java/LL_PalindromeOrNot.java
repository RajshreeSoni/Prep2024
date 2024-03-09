public class LL_PalindromeOrNot {
        // find the middle of LL
        public static ListNode middleOfLL(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // reverse LL from the middle point till end
        public static ListNode reverseLL(ListNode head) {
            ListNode current = head;
            ListNode prev = null;
            while (current != null) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }

        // compare both the LL
        public static boolean compareTwoLL(ListNode head1, ListNode head2) {
            if (head1 == null && head2 == null) return true;
            if (head1 == null || head2 == null) return false;
            boolean result = true;
            while(result && head2 != null) {
                if (head1.val != head2.val) result = false;
                head1 = head1.next;
                head2 = head2.next;
            }
            return result;
        }
        public static boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode middle = middleOfLL(head);

            ListNode head1 = reverseLL(middle);
            return compareTwoLL(head, head1);

        }

        public static void main(String args[]) {
            ListNode head1 = new ListNode(1);
            head1.next = new ListNode(0);
            head1.next.next = new ListNode(1);

            System.out.println(isPalindrome(head1));
        }
}
