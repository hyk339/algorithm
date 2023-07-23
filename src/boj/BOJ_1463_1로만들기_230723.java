package boj;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기_230723 {
	
	
	/*
	 * 2023.07.23 시간초과..
	 * 2023.07.23 최소의 횟수를 구한 것을 따로 저장해주지 않으면 
	 * 		      다시 최소 횟수를 찾기위해 다시 계산해야한다.
	 *            그래서 시간초과가 발생한다. 
	 */
	
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		dp = new Integer[num+1];
		dp[1] = 0;
		int result = fun(num);
		System.out.println(result);
	}
	
	static int fun(int n) {
		
		if(dp[n] == null){
			if(n%6 == 0) {
				dp[n] = Math.min(Math.min(fun(n/3), fun(n/2)),fun(n-1))+1;
			}else if(n%3 == 0) {
				dp[n] = Math.min(fun(n/3), fun(n-1))+1;				
			}else if(n%2 == 0) {
				dp[n] = Math.min(fun(n/2), fun(n-1))+1;				
			}else {
				dp[n] = fun(n-1)+1;
			}
		}
		return dp[n];	
	}
}
