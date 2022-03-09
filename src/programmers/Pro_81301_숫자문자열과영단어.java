class Solution {
    public int solution(String s) {
        int answer = 0;
        if(s.indexOf("zero") != -1) s = s.replace("zero","0");
        if(s.indexOf("one") != -1) s = s.replace("one","1");
        if(s.indexOf("two") != -1) s = s.replace("two","2");
        if(s.indexOf("three") != -1) s = s.replace("three","3");
        if(s.indexOf("four") != -1) s = s.replace("four","4");
        if(s.indexOf("five") != -1) s = s.replace("five","5");
        if(s.indexOf("six") != -1) s = s.replace("six","6");
        if(s.indexOf("seven") != -1) s = s.replace("seven","7");
        if(s.indexOf("eight") != -1) s = s.replace("eight","8");
        if(s.indexOf("nine") != -1) s = s.replace("nine","9");
        answer = Integer.parseInt(s);
        return answer;
    }
}