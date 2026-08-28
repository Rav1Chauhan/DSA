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
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public ListNode reversList(ListNode head) {
        if (head == null)
            return head;
        ListNode past = null;
        ListNode present = head;
        ListNode future = present.next;
        while (present != null) {
            present.next = past;
            past = present;
            present = future;
            if (future != null)
                future = future.next;
        }
        return past;
    }

    public void reorderList(ListNode head) {
        ListNode middleNode = middleNode(head);
        ListNode hs = reversList(middleNode);
        ListNode hf = head;
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if (hf != null) {
            hf.next = null;
        }
    }
}