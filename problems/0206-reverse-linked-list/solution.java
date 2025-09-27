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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(null, head, head.next);
    }

    private ListNode reverse(ListNode prev, ListNode cur, ListNode next) {
        if (next != null) {
            ListNode tmp = next.next;
            next.next = cur;
            cur.next = prev;
            return reverse(cur, next, tmp);
        } else {
            return cur;
        }
    }
}
