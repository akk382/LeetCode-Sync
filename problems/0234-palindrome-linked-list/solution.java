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
    public boolean isPalindrome(ListNode head) {

        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len == 1) {
            return true;
        }

        int stackSizeLimit = len % 2 == 0 ? len / 2 : len / 2 + 1;
        int[] stack = new int[stackSizeLimit];

        temp = head;
        ListNode prev = temp;
        int i = 0;
        while (temp != null && i < stackSizeLimit) {
            stack[i] = temp.val;
            prev = temp;
            temp = temp.next;
            i++;
        }

        if (len % 2 != 0) {
            temp = prev;
        }

        while (temp != null) {
            i--;
            if (temp.val != stack[i]) {
                return false;
            }
            temp = temp.next;
        }
        if (i == 0 && temp == null) {
            return true;
        }
        return false;
        
    }
}
