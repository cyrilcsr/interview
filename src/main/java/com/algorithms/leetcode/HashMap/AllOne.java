package com.algorithms.leetcode.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Leeetcode 0432
*/
public class AllOne {
    HashMap<String,ListNode> hashMap;
    static class ListNode {
        int val;
        Set<String> keys;
        ListNode prev;
        ListNode next;
        ListNode(int val,Set<String> keys, ListNode prev,ListNode next){
            this.val = val;
            this.keys = keys;
            this.prev = prev;
            this.next = next;
        }
        private void insertNode(ListNode newNode){
            newNode.prev = this;
            newNode.next = this.next;
            this.next.prev = newNode;
            this.next = newNode;
        }

        private void removeNode(){
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }
    ListNode head;
    ListNode tail;
    public AllOne() {
        hashMap = new HashMap<>();
        head = new ListNode(0, null,null, null);
        tail = new ListNode(Integer.MAX_VALUE, null,null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if(hashMap.containsKey(key)){
            ListNode node = hashMap.get(key);
            if(node.next.val== node.val+1){
                node.next.keys.add(key);
            }else{
                ListNode newNode = new ListNode(node.val+1,new HashSet<String>(), null, null);
                newNode.keys.add(key);
                node.insertNode(newNode);
            }
            node.keys.remove(key);
            hashMap.put(key,node.next);
            if(node.keys.isEmpty()){
                node.removeNode();
            }
        }else{
            if(head.next.val==1){
                head.next.keys.add(key);
            }else{
                ListNode newNode = new ListNode(1, new HashSet<String>(), null, null);
                newNode.keys.add(key);
                head.insertNode(newNode);
            }
            hashMap.put(key,head.next);
        }
    }

    public void dec(String key) {
        if(hashMap.containsKey(key)){
            ListNode node = hashMap.get(key);
            if(node.val==1){
                node.keys.remove(key);
                hashMap.remove(key);
                if(node.keys.isEmpty()){
                    node.removeNode();
                }
            }else{
                if(node.prev.val == node.val-1){
                    node.prev.keys.add(key);
                    node.keys.remove(key);
                    hashMap.put(key,node.prev);
                    if(node.keys.isEmpty()){
                        node.removeNode();
                    }
                }else{
                    ListNode newNode = new ListNode(node.val-1, new HashSet<String>(), null, null);
                    newNode.keys.add(key);
                    node.prev.insertNode(newNode);
                    hashMap.put(key,newNode);
                    node.keys.remove(key);
                    if(node.keys.isEmpty()){
                        node.removeNode();
                    }
                }
            }
        }
    }

    public String getMaxKey() {
        return tail.prev.equals(head)?"":tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next.equals(tail)?"":head.next.keys.iterator().next();
    }


}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */