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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        } else if (head != null && head.val == val) {
            head = removeElements(head.next, val);
        } else {
            removeEls(head, head.next, val);
        }
        return head;
    }

    private ListNode removeEls(ListNode prev, ListNode cur, int val) {
        if (cur == null) {
            return null;
        }
        if (cur.val == val) {
            prev.next = cur.next;
            cur.next = null;
            cur = prev.next;
        } else {
            prev = cur;
            cur = cur.next;
        }
        return removeEls(prev, cur, val);
    }
}

