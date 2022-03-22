package com.algorithms.leetcode.Tree.BinarySearchTree;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
Leeetcode 0653
*/
public class TwoSum4 {
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashset = new HashSet<>();
        Queue<TreeNode> stack = new ArrayDeque<>();
        if(root==null){
            return false;
        }
        stack.offer(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.poll();
            hashset.add(node.val);
            if(node.left!=null){
                stack.offer(node.left);
            }
            if(node.right!=null){
                stack.offer(node.right);
            }
        }
        for (int curr : hashset) {
            if(k-curr == curr){
                continue;
            }
            if (hashset.contains(k - curr)) {
                return true;
            }
        }
        return false;
    }
}
