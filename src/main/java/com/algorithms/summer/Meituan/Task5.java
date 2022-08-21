package com.algorithms.summer.Meituan;

import java.util.*;

public class Task5 {
    static int[] videos;
    static List<Integer>[] preRequests;
    static int[] allLength;
    static Set<Integer>[] finished;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        videos = new int[num];
        preRequests = new List[num];
        allLength = new int[num];

        for(int i=0;i<num;i++){
            videos[i] = sc.nextInt();
            int preRequestNum = sc.nextInt();
            preRequests[i] = new LinkedList<>();
            if(preRequestNum!=0){
                for(int j=0;j<preRequestNum;j++){
                    preRequests[i].add(sc.nextInt());
                }
            }
        }

//        for(int i=0;i<num;i++){
//            finished[i] = new HashSet<>();
//                setFinished(i,i);
//        }
        for(int i=0;i<num;i++){
            setAllLength(i);
        }
        for(int i=0;i<num;i++){
            System.out.println(allLength[i]);
            if(i!=num-1){
                System.out.println(" ");
            }
        }
    }

    private static void setFinished(int video,int index){
        finished[index].add(video);
        for(Integer i:preRequests[video]){
            setFinished(i,index);
        }
    }
    public static int setAllLength(int index){
        if(allLength[index]!=0){
            return allLength[index];
        }
        if(preRequests[index].size()==0){
            allLength[index] = videos[index];
            return allLength[index];
        }
        int preRequestLen = 0;
        for(int i:preRequests[index]){
            if(allLength[i]==0){
                setAllLength(i);
            }
            preRequestLen = Math.max(preRequestLen,allLength[i]);

        }
        allLength[index]+=preRequestLen;
        return allLength[index];
    }
}
