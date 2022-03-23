package com.algorithms.leetcode.Tree.Tire;

/*
Leeetcode 0440
*/
public class FindKthNumber {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        int count = 1;
        while(count<k){
            int tempCount = getCount(prefix,n);
            if(count+tempCount<=k){
                prefix++;
                count+=tempCount;
            }else if(count+tempCount>k){
                count++;
                prefix*=10;
            }
        }
        return prefix;
    }

    private static int getCount(long prefix, int n){
        int ans = 0;
        long curr = prefix, next = prefix+1;
        while(curr<=n){
            ans+=Math.min(n+1,next)-curr;
            curr*=10;
            next*=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getCount(1,10));
    }
}
