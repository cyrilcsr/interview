package com.algorithms.leetcode.DynamicProgramming.Path;

import java.util.List;

/*
Leeetcode 1301
*/
public class PathsWithMaxScore {
    int len;
    int mod = 1000000007;
    char[][] boardArray;
    public int[] pathsWithMaxScore(List<String> board) {
        len = board.size();
        int dp[][] = new int[len*len][2];
        dp[dp.length-1][1]=1;
        boardArray = new char[len][len];

        for(int i=0;i<len;i++){
            boardArray[i] = board.get(i).toCharArray();
        }

        int prev = 0;
        for(int i=len-2;i>=0;i--){
            if(boardArray[len-1][i]=='X'){
                break;
            }
            dp[getIndex(len-1,i)][0] = boardArray[len-1][i]-'0'+prev;
            dp[getIndex(len-1,i)][1] = 1;
            prev = dp[getIndex(len-1,i)][0];
        }

        prev = 0;
        for(int i=len-2;i>=0;i--){
            if(boardArray[i][len-1]=='X'){
                break;
            }
            dp[getIndex(i,len-1)][0] = boardArray[i][len-1]-'0'+prev;
            dp[getIndex(i,len-1)][1] = 1;
            prev = dp[getIndex(i,len-1)][0];
        }

        for(int i=len-2;i>=0;i--){
            for(int j=len-2;j>=0;j--){
                if(boardArray[i][j]=='X'){
                    continue;
                }
                int[] right = dp[getIndex(i,j+1)];
                int[] down = dp[getIndex(i+1,j)];
                int[] rightDown = dp[getIndex(i+1,j+1)];

                int max = Math.max(Math.max(right[0],down[0]),rightDown[0]);
                if(max==0){
                    if(boardArray[i+1][j+1]=='S'){
                        dp[getIndex(i, j)][1] += rightDown[1];
                        dp[getIndex(i,j)][0] =
                                boardArray[i][j]=='E'?max:max +(boardArray[i][j]-'0');
                        dp[getIndex(i, j)][0] %= mod;

                    }
                    continue;
                }
                dp[getIndex(i,j)][0] =
                        boardArray[i][j]=='E'?max:max +(boardArray[i][j]-'0');
                dp[getIndex(i, j)][0] %= mod;
                if(right[0]==max){
                    dp[getIndex(i,j)][1] += right[1];
                }
                if(down[0]==max){
                    dp[getIndex(i,j)][1] += down[1];
                }
                if(rightDown[0]==max) {
                    dp[getIndex(i, j)][1] += rightDown[1];
                }
                dp[getIndex(i, j)][1] %= mod;

            }
        }
        return dp[0];
    }

    private int getIndex(int x,int y){
        return x*len+y;
    }

    private int[] getPosition(int index){
        int[] position = new int[2];
        return new int[]{index/len,index%len};
    }
}
