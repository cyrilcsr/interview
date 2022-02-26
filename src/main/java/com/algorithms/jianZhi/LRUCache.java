package com.algorithms.jianZhi;

import java.util.HashMap;
import java.util.Map;

/*
JianZhi Offer 2-031
Leeetcode 0146
 */
public class LRUCache {
class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
    Node(int key, int val, Node next, Node prev) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addToTail(node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            node = addToTail(node);
            map.put(key,node);
        }else{
            Node node = new Node(key,value);
            if(size == capacity){
                Node first = head.next;
                removeNode(first);
                map.remove(first.key);
                node = addToTail(node);
                map.put(key,node);
            }else{
                node = addToTail(node);
                map.put(key,node);
                size++;
            }
        }
    }

    private Node addToTail(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        return node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
