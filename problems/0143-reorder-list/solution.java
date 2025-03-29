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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int i = 0, j = list.size() - 1;
        while (i != j && i != j - 1) {
            list.get(i).next = list.get(j);
            list.get(j).next = list.get(i + 1);
            i += 1;
            j -= 1;
        }

        if (i == j) {
            list.get(i).next = null;
        } else {
            list.get(j).next = null;
        }
    }
}
