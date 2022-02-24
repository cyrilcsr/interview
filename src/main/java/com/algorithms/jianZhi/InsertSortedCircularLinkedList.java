package com.algorithms.jianZhi;
/*
JianZhi Offer 2-029
Leeetcode 0708
 */
public class InsertSortedCircularLinkedList {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node smallest = new Node(Integer.MAX_VALUE);
        Node biggest = new Node(Integer.MIN_VALUE);

        Node curr = head;
        int circleNum = -1;
        while(circleNum!=1){
            if(curr==head){
                circleNum++;
            }
            if(curr.val>=biggest.val){
                biggest = curr;
            }
            if(curr.val<smallest.val){
                smallest = curr;
            }
            curr = curr.next;
        }
        if(insertVal>= biggest.val||insertVal<= smallest.val){
            Node next = biggest.next;
            biggest.next = new Node(insertVal,next);
            return head;
        }

        curr = head;
        circleNum = -1;
        while(circleNum!=1){
            if(curr==head){
                circleNum++;
            }
            if(curr.val<=insertVal&&curr.next.val>insertVal){
                Node next = curr.next;
                curr.next = new Node(insertVal,next);
                return head;
            }
            curr = curr.next;
        }

        Node next = curr.next;
        curr.next = new Node(insertVal,next);
        return head;
    }
}
