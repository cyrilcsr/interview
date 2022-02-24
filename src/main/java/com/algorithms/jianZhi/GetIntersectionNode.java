package com.algorithms.jianZhi;

/*
JianZhi Offer 2-023
Leeetcode 0160
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = listLength(headA);
        int lenB = listLength(headB);

        ListNode currA = headA;
        ListNode currB = headB;

        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                currA = currA.next;
            }
        }else{
            for(int i=0;i<lenB-lenA;i++){
                currB = currB.next;
            }
        }

        while(currA!=null && currB!=null){
            if(currA.equals(currB)){
                return currA;
            }else{
                currA = currA.next;
                currB = currB.next;
            }
        }
        return null;
    }

    private int listLength(ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            count++;
        }

        return count;
    }

}
