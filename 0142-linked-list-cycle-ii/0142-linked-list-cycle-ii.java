/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode slow = head;
        int lengthh = 0;
        while (first != null && first.next != null) {
            first = first.next.next;
            slow = slow.next;
            if (slow == first) {
                lengthh = lengthCycle(slow);
                break;
            }
        }
        if (lengthh == 0) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (lengthh > 0) {
            s = s.next;
            lengthh--;
        }
        while (f != s) {
            s = s.next;
            f = f.next;
        }
        return s;
    }

    private int lengthCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        int length = 1;
        while (fast != slow) {
            fast = fast.next;
            length++;
        }
        return length;
    }
}