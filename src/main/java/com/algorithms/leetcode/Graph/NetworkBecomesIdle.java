package com.algorithms.leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Leeetcode 2039
*/
public class NetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int num = patience.length;
        List<Integer>[] adjacent = new List[num];
        for(int i=0;i<num;i++){
            adjacent[i] = new ArrayList<>();
        }
        for(int[] e:edges){
            adjacent[e[0]].add(e[1]);
            adjacent[e[1]].add(e[0]);
        }
        boolean[] visit = new boolean[num];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit[0] = true;
        int dist = 0;
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int curr = queue.poll();
                if(visit[curr]) continue;
                for(Integer j:adjacent[curr]){
                    if(!visit[j]){
                        queue.offer(j);
                    }
                }
                if(dist!=0){
                    int time = patience[curr]>=dist*2?dist*2:dist*4-((dist*2-1)%patience[curr]+1);
                    ans = Math.max(ans,time);
                }
                visit[curr] = true;
            }
            dist++;
        }
        return ans+1;
    }
}
