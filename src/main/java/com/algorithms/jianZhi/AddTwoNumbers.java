package com.algorithms.jianZhi;
/*
JianZhi Offer 2-025
Leeetcode 0445
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry =0;
        while(l1!=null||l2!=null){
            int sum = 0;
            ListNode node = null;
            if(l1==null){
                sum = l2.val+carry;
                node = new ListNode((int)sum%10);
                l2 = l2.next;
            }else if(l2==null){
                sum = l1.val+carry;
                node = new ListNode((int)sum%10);
                l1 = l1.next;
            }else{
                sum = l1.val + l2.val + carry;
                node = new ListNode(sum%10);
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum/10;
            curr.next = node;
            curr = curr.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        if(dummy.next==null){
            return null;
        }else{
            return reverseList(dummy.next);
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
