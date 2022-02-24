package com.algorithms.jianZhi;
/*
JianZhi Offer 2-026
Leeetcode 0143
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head.next==null) {
            return ;
        }

        ListNode dummy = new ListNode(0,head);

        ListNode fast = dummy;
        ListNode slow = dummy;


        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;

        ListNode curr = head;
        while(secondHalf!=null&&curr!=null){
            ListNode next = curr.next;
            curr.next = secondHalf;
            secondHalf = secondHalf.next;
            curr.next.next = next;
            curr = curr.next.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
