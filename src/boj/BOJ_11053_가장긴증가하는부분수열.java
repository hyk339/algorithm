package boj;

import java.io.*;
import java.util.*;

public class BOJ_11053_가장긴증가하는부분수열 {
	
	// https://st-lab.tistory.com/137 블로그를 참고하여 풀었습니다.
	
	static int N; //수열의 크기
	static int[] arr;
	static Integer dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			fun(i);
		}
		int result = dp[0];
		for(int i=0; i<N; i++) {
			result = Math.max(dp[i],result);
		}
		System.out.println(result);
	}
	
	public static int fun(int num) {
		if(dp[num] == null) {
			dp[num] = 1;
			
			for(int i=num-1; i>=0; i--) {
				if(arr[i] < arr[num]) {
					dp[num] = Math.max(dp[num], fun(i)+1);
				}
			}
		}
		
		return dp[num];
	}
}
