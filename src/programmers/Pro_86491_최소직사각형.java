import java.io.*;
import java.util.*;

class Solution {
    
    static int minSize = Integer.MAX_VALUE;
    static int answer = 0;
        
    public int solution(int[][] sizes) {
        
        //첫번째 명함을 가로,세로를 뒤집을 필요가 없다.
        function(sizes[0][0],sizes[0][1],0,sizes);
        
        answer = minSize;
        return answer;
    }
    
    void function(int row, int col, int nowIdx, int[][] sizes){
        //만약 이미 모든 명함을 비교를 한상태라면
        if(nowIdx == sizes.length-1){
            if(row*col < minSize){ 
                minSize = row*col;
            }
            return;
        }
        //앞서 확인한 가로 최대의 길이와, 세로의 최대 길이가 이후 비교하는 명함의 가로,세로 길이보다 클때
        if((row > sizes[nowIdx+1][0] && col > sizes[nowIdx+1][1]) 
                  || (row > sizes[nowIdx+1][1] && col > sizes[nowIdx+1][0])){
            function(row, col, nowIdx+1,sizes);
        //
        } else if(Math.max(row, sizes[nowIdx+1][0]) == Math.max(row, sizes[nowIdx+1][1]) 
           && Math.max(col, sizes[nowIdx+1][1]) == Math.max(col, sizes[nowIdx+1][0])){ 
            function(Math.max(row, sizes[nowIdx+1][0]), Math.max(col, sizes[nowIdx+1][1]), nowIdx+1,sizes);
        }
        // 이외의 경우에는 가로,세로 뒤집은 것을 계속 비교
        else{
            function(Math.max(row, sizes[nowIdx+1][0]), Math.max(col, sizes[nowIdx+1][1]), nowIdx+1,sizes);
            function(Math.max(row, sizes[nowIdx+1][1]), Math.max(col, sizes[nowIdx+1][0]), nowIdx+1,sizes); 
        }
    }
}
