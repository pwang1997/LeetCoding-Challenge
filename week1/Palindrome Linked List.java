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
        if(head == null || head.next == null) {return true;}
        ListNode slow = head, fast = head;
        ListNode tempHead = head;
        // find mid point
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse slow-to-fast
        slow = reverseList(slow);

        while(tempHead != null && slow != null) {
            // System.out.println(tempHead.val + "|" + slow.val);
            if(tempHead.val != slow.val) {
                return false;
            }
            tempHead = tempHead.next;
            slow = slow.next;
        }

        return true;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}