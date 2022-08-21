package com.algorithms.summer.Microsoft.Intern;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    List<Integer>[] children;
    int maxLen;
    public int solution(String S, int[] A) {
        // write your code in Java SE 8
        children= new ArrayList[A.length];
        for(int i=0;i<children.length;i++){
            children[i] = new ArrayList<Integer>();
        }
        int root=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==-1){
                root = i;
            }else{
                children[A[i]].add(i);
            }
        }

        maxLen = 0;
        dfs(0,-1,0,S);

        return maxLen;
    }

    private void dfs(int node, int parent,int length,String S){
//        if(children[node].size()==0){
//            maxLen = Math.max(maxLen,length);
//            return;
//        }
        if(parent!=-1&&S.charAt(parent)!=S.charAt(node)){
            length++;
        }else{
            length=1;
        }
        maxLen = Math.max(maxLen,length);
        for(int child:children[node]){
            dfs(child,node,length,S);
        }
    }
}
