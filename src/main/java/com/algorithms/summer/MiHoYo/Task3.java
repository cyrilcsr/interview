package com.algorithms.summer.MiHoYo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    static char[][] map;
    static int rowNum;
    static int colNum;
    static int[][] tempMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rowNum = sc.nextInt();
        colNum = sc.nextInt();
        sc.nextLine();
        map = new char[rowNum][colNum];
        tempMap = new int[rowNum][colNum];

        for(int i=0;i<rowNum;i++){
            map[i] = sc.nextLine().trim().toCharArray();
        }

        int[] startPos = findStartPoint();
        List<int[]> flower = new ArrayList<>();
        List<int[]> meat = new ArrayList<>();
        List<int[]> campfire = new ArrayList<>();
        assert startPos != null;
        System.out.println(startPos.toString());
        bfs(startPos,0);

        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++) {
                if(map[i][j]=='#'&&tempMap[i][j]!=0){
                    flower.add(getPos(i,j));
                }
                if(map[i][j]=='$'&&tempMap[i][j]!=0){
                    meat.add(getPos(i,j));
                }
                if(map[i][j]=='^'&&tempMap[i][j]!=0){
                    campfire.add(getPos(i,j));
                }
            }
        }

        if(flower.isEmpty()||meat.isEmpty()||campfire.isEmpty()){
            System.out.println(-1);
            return;
        }
    }

    private static int[] findStartPoint(){
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                if(map[i][j]=='m'){
                    int[] pos =new int[2];
                    pos[0]=i;
                    pos[i]=j;
                    return pos;
                }
            }
        }
        return null;
    }

    private static int[] getPos(int i, int j){
        int[] pos =new int[2];
        pos[0]=i;
        pos[i]=j;
        return pos;
    }

    public static void bfs(int[] pos, int steps){
        tempMap[pos[0]][pos[1]] = Math.min(steps,tempMap[pos[0]][pos[1]]);
        if(pos[0]-1>=0&&map[pos[0]-1][pos[1]]!='B'){
            bfs(getPos(pos[0]-1,pos[1]),steps+1);
        }else if(pos[1]-1>=0&&map[pos[0]][pos[1]-1]!='B'){
            bfs(getPos(pos[0],pos[1]-1),steps+1);
        }else if(pos[0]+1<rowNum&&map[pos[0]+1][pos[1]]!='B'){
            bfs(getPos(pos[0]+1,pos[1]),steps+1);
        }else if(pos[1]+1<colNum&&map[pos[0]][pos[1]+1]!='B'){
            bfs(getPos(pos[0],pos[1]+1),steps+1);
        }else{
            return;
        }
    }

}
