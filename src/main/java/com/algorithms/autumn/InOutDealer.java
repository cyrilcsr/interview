package com.algorithms.autumn;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class InOutDealer {
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

    void outputFormat(){
        double x = 0, y = 0;
        // 一般方式
        System.out.println("x = " + x + ", y = " + y);
        // printf()方式
        System.out.printf("x = %d, y = %f\n", x, y);
        // format()方式
        System.out.format("x = %d, y = %f\n", x, y);

        DecimalFormat fd = new DecimalFormat("#.00#");
        DecimalFormat gd = new DecimalFormat("0.000");
        System.out.println("x =" + fd.format(x));
        System.out.println("x =" + gd.format(x));

        NumberFormat formatter = new DecimalFormat( "000000");
        String s = formatter.format(-1234.567); // -001235
        System.out.println(s);
        formatter = new DecimalFormat( "##");
        s = formatter.format(-1234.567); // -1235
        System.out.println(s);
        s = formatter.format(0); // 0
        System.out.println(s);
        formatter = new DecimalFormat( "##00");
        s = formatter.format(0); // 00
        System.out.println(s);
        formatter = new DecimalFormat( ".00");
        s = formatter.format(-.567); // -.57
        System.out.println(s);
        formatter = new DecimalFormat( "0.00");
        s = formatter.format(-.567); // -0.57
        System.out.println(s);
        formatter = new DecimalFormat( "#.#");
        s = formatter.format(-1234.567); // -1234.6
        System.out.println(s);
        formatter = new DecimalFormat( "#.######");
        s = formatter.format(-1234.567); // -1234.567
        System.out.println(s);
        formatter = new DecimalFormat( ".######");
        s = formatter.format(-1234.567); // -1234.567
        System.out.println(s);
        formatter = new DecimalFormat( "#.000000");
        s = formatter.format(-1234.567); // -1234.567000
        System.out.println(s);
        formatter = new DecimalFormat( "#,###,###");
        s = formatter.format(-1234.567); // -1,235
        System.out.println(s);
        s = formatter.format(-1234567.890); // -1,234,568
        System.out.println(s);
// The ; symbol is used to specify an alternate pattern for negative values
        formatter = new DecimalFormat( "#;(#) ");
        s = formatter.format(-1234.567); // (1235)
        System.out.println(s);
// The ' symbol is used to quote literal symbols
        formatter = new DecimalFormat( " '# '# ");
        s = formatter.format(-1234.567); // -#1235
        System.out.println(s);
        formatter = new DecimalFormat( " 'abc '# ");
        s = formatter.format(-1234.567); // - abc 1235
        System.out.println(s);
        formatter = new DecimalFormat( "#.##%");
        s = formatter.format(-12.5678987);
        System.out.println(s);
    }

    void bigInteger(){
        int a = 123, b = 456, c = 7890;
        BigInteger x, y, z, ans;
        x = BigInteger.valueOf(a);
        y = BigInteger.valueOf(b);
        z = BigInteger.valueOf(c);
        ans = x.add(y); System.out.println(ans);
        ans = z.divide(y); System.out.println(ans);
        ans = x.mod(z); System.out.println(ans);
        if (ans.compareTo(x) == 0) System.out.println("1");

    }

    void baseConversion(){
        int base = 2;
        int num = 10;
        String st = Integer.toString(num, base); // 把num当做10进制的数转成base进制的st(base <= 35).
        num = Integer.parseInt(st, base); // 把st当做base进制，转成10进制的int(parseInt有两个参数,第一个为要转的字符串,第二个为说明是什么进制).
        BigInteger m = new BigInteger(st, base); // st是字符串，base是st的进制.

    }

    public static void main(String[] args) {
        int[] test = new int[]{2,5,1,6,3};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));

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


}
