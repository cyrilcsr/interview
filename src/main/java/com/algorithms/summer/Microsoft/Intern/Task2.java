package com.algorithms.summer.Microsoft.Intern;

public class Task2 {
    public int solution(String[] R) {
        // write your code in Java SE 8

        boolean[][] cleaned = new boolean[R.length][R[0].length()];
        boolean[][][] directions = new boolean[R.length][R[0].length()][4];
        int[] result = new int[1];

        next(0,0,0,cleaned,directions,R,result);
        return result[0];
    }

    private void next(int posX, int posY, int direction, boolean[][] cleaned,
                      boolean[][][] directions,String[] R,int[] result){
        if(!cleaned[posX][posY]){
            cleaned[posX][posY]=true;
            result[0]++;
        }
        if(directions[posX][posY][direction]){
            return;
        }
        directions[posX][posY][direction]=true;

        int nextPosX=posX;
        int nextPosY=posY;
        if(direction==0){
            nextPosY++;
        }else if(direction==1){
            nextPosX++;
        }else if(direction==2){
            nextPosY--;
        }else{
            nextPosX--;
        }

        boolean validateNext = false;
        if(0<=nextPosX&&nextPosX<R.length&&0<=nextPosY&&nextPosY<R[0].length()){
            if(R[nextPosX].charAt(nextPosY)=='.'){
                validateNext=true;
            }
        }

        if(validateNext){
            next(nextPosX,nextPosY,direction,cleaned,directions,R,result);
        }else{
            next(posX,posY,(direction+1)%4,cleaned,directions,R,result);
        }

    }
}
