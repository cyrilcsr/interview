package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Leeetcode 2049
 */
public class CountHighestScoreNodes {
    List<Integer>[] children;
    int nodeNum;
    long maxScore;
    int count;
    public int countHighestScoreNodes(int[] parents) {
        nodeNum = parents.length;
        children = new List[nodeNum];
        for(int i=0;i<nodeNum;i++){
            children[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<nodeNum;i++){
            int parent = parents[i];
            if(parent!=-1){
                children[parent].add(i);
            }
        }

        dfs(0);

        return count;
    }

    private int dfs(int node){
        int size = 1;
        long score = 1;
        for(int i:children[node]){
            int chilTreeSize = dfs(i);
            score *= chilTreeSize;
            size += chilTreeSize;
        }
        score *= nodeNum-size==0?1:nodeNum-size;
        if(score>maxScore){
            maxScore = score;
            count = 1;
        }else if(score == maxScore){
            count++;
        }
        return size;
    }
}
