package com.algorithms.leetcode.Tree.Tarversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
Leeetcode 0606
*/
public class Tree2str {
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

    public String tree2str(TreeNode root) {
        if(root.left==null&&root.right==null){
            return String.valueOf(root.val);
        }else if(root.left==null){
            return String.valueOf(root.val)+"("+")"+"("+tree2str(root.right)+")";
        }else if(root.right==null){
            return String.valueOf(root.val)+"("+tree2str(root.left)+")";
        }else{
            return String.valueOf(root.val)+"("+tree2str(root.left)+")"
                    +"("+tree2str(root.right)+")";
        }
    }

    public String tree2str2(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (!visited.add(node)) {
                if (node != root) {
                    ans.append(")");
                }
                stack.pop();
            } else {
                if (node != root) {
                    ans.append("(");
                }
                ans.append(node.val);
                if (node.left == null && node.right != null) {
                    ans.append("()");
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return ans.toString();
    }
}
