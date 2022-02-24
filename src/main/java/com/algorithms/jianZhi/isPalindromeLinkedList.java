package com.algorithms.jianZhi;
/*
JianZhi Offer 2-027
Leeetcode 0143
 */
public class isPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(0,head);

        ListNode fast = dummy;
        ListNode slow = dummy;


        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverseList(slow.next);

        while(head!=null&&head2!=null){
            if(head.val!=head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
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
