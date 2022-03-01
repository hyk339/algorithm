import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] c1 = {1,2,3,4,5};
        int[] c2 = {2,1,2,3,2,4,2,5};
        int[] c3 = {3,3,1,1,2,2,4,4,5,5};
        
        int n = answers.length;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for(int i=0; i<answers.length; i++){
            
            if(answers[i]==c1[i%c1.length]){
                count1++;
            }
            if(answers[i]==c2[i%c2.length]){
                count2++;
            }
            if(answers[i]==c3[i%c3.length]){
                count3++;
            }
        }
        
        
        if(count1 > count2 && count1 > count3){
            return new int[]{1};
        }else if(count2 > count1 && count2 > count3){
            return new int[]{2};
        }else if(count3 > count1 && count3 > count2){
            return new int[]{3};
        }else if(count1 == count2 && count2== count3){
            return new int[]{1,2,3};
        }else if(count1 == count2){
            return new int[]{1,2};
        }else if(count2 == count3){
            return new int[]{2,3};
        }else {
            return new int[]{1,3};
        }
    }
}