package com.algorithms.jianZhi;

/*
JianZhi Offer 2-024
Leeetcode 0206
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
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
