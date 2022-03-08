class Solution {
    public int solution(int[] numbers) {
        
        int sum = 0;
        
        boolean[] arr = new boolean[10];
        for(int i=0; i<numbers.length; i++){
            arr[numbers[i]] = true;
        }
        for(int i=0; i<10; i++){
            if(!arr[i]) sum += i;
        }

        return sum;
    }
}