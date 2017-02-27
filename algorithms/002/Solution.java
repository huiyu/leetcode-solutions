/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = null;

        int carry = 0;
        ListNode node = null;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int val = sum % 10;

            if (root == null) {
                root = node = new ListNode(val);
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return root;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
