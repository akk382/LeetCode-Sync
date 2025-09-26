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
    ListNode resultHead = null;
    ListNode resultTail = null;
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node;
        int res;
        if (l1 != null && l2 != null) {
            res = carry + l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        } else if (l1 != null) {
            res = carry + l1.val;
            l1 = l1.next;
        } else if (l2 != null) {
            res = carry + l2.val;
            l2 = l2.next;
        } else {
            if (carry != 0) {
                resultTail.next = new ListNode(carry);
            }
            return resultHead;
        }
        carry = res / 10;
        res = res % 10;
        node = new ListNode(res);
        if (resultHead == null) {
            resultHead = resultTail = node;
        } else {
            resultTail.next = node;
            resultTail = resultTail.next;
        }
        return addTwoNumbers(l1, l2);
    }
}
