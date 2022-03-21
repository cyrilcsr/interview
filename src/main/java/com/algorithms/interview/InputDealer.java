package com.algorithms.interview;
import java.util.*;

public class InputDealer {
    void continueInput(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

        }
    }

    void continueInputWithNum(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(num>0){
            num--;
        }
    }

    void multipleDataInOneRow(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String in = scanner.nextLine();
            String[] array = in.split(" ");
        }
    }

    class Node{
        Integer val;
        List<Node> children;
        Node(Integer i){
            this.val = i;
            children = new LinkedList<>();
        }
    }
    Node deserializeTree(String data){
        if (data.isEmpty()) {
            return null;
        }
        String[] strings = data.split(" ");
        Stack<Node> stack = new Stack<Node>();
        Node root = null;
        Node cur = null;

        for (String s : strings) {
            if (s.equals("[")) {
                stack.push(cur);
            } else if (s.equals("]")) {
                stack.pop();
            } else {
                Node node = new Node(Integer.valueOf(s));
                node.children = new LinkedList<Node>();
                if (root == null) {
                    root = node;
                } else {
                    Node parent = stack.peek();
                    parent.children.add(node);
                }
                cur = node;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,5,1,6,3};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));

    }
}
