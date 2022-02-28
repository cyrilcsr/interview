package com.algorithms.jianZhi;

import java.util.Stack;

/*
JianZhi Offer 2-036
Leeetcode 0150
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< tokens.length;i++){
            int num1, num2;
            switch (tokens[i]){
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2+num1);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2-num1);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2*num1);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2/num1);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
