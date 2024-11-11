/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // Result linked list
        ListNode current = head; // Pointer for the current position
        int carry = 0; // Initialize carry

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Start with carry

            if (l1 != null) {
                sum += l1.val; // Add l1 value
                l1 = l1.next; // Move to the next node
            }

            if (l2 != null) {
                sum += l2.val; // Add l2 value
                l2 = l2.next; // Move to the next node
            }

            carry = sum / 10; // Calculate new carry
            current.next = new ListNode(sum % 10); // Create new node for the digit
            current = current.next; // Move to next position
        }

        return head.next; // Return the result list (skipping dummy node)
    }
}
