package com.algorithms.jianZhi;

import java.util.HashMap;

/*
JianZhi Offer 2-022
Leeetcode 0142
 */


public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        HashMap<ListNode,Integer> hash = new HashMap<>();

        ListNode temp = head;
        while(true){
            if(temp==null){
                return null;
            }
            if(hash.containsKey(temp)){
                return temp;
            }else{
                hash.put(temp,1);
                temp = temp.next;
            }
        }
    }

    public ListNode detectCycle2(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next==null){
                break;
            }
            fast = fast.next.next;

            if(slow.equals(fast)){
                ListNode ptr = head;
                while(!ptr.equals(slow)){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
