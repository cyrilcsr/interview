package com.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
Leeetcode 0589
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class NAryPreOrder {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> results = new ArrayList<>();

        preorder(root,results);

        return results;
    }

    public void preorder(Node root,ArrayList<Integer> results){
        if(root==null){
            return;
        }
        results.add(root.val);
        for(Node n:root.children){
            preorder(n,results);
        }
    }

    public List<Integer> preorder2(Node root) {
        ArrayList<Integer> results = new ArrayList<>();
        if(root==null){
            return results;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node n = stack.pop();
            results.add(n.val);
            if(n.children==null){
                continue;
            }
            for(int i=n.children.size()-1;i>=0;i--){
                stack.push(n.children.get(i));
            }
        }
        return results;
    }

}
