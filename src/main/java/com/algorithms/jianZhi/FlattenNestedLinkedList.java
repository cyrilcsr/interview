package com.algorithms.jianZhi;
/*
JianZhi Offer 2-028
Leeetcode 0430
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class FlattenNestedLinkedList {
    public Node flatten(Node head) {
        flattenRecursive(head);
        return head;
    }

    private Node flattenRecursive(Node head){
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                Node next = curr.next;
                Node child = curr.child;
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                curr = flattenRecursive(child);
                if(next!=null){
                    next.prev = curr;
                }
                curr.next = next;

            }
            if(curr.next!=null){
                curr = curr.next;
            }else{
                break;
            }
        }
        return curr;
    }
}
