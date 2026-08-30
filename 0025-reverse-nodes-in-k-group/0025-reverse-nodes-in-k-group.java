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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode temp = head;
        int c = 0;
        for (int i = 0; i < k && temp != null; i++) {
            temp = temp.next;
            c++;
        }
        if (c < k) {
            return head;
        }
        ListNode nh = null;
        nh = reverseKGroup(temp, k);
        ListNode past = null;
        ListNode present = head;
        ListNode future = present.next;
        while (c > 0) {
            future = present.next;
            present.next = past;
            past = present;
            present = future;
            c--;
        }
        head.next = nh;
        return past;
    }
}