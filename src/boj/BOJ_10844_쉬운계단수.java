package boj;

import java.io.*;
import java.util.*;

public class BOJ_10844_쉬운계단수 {
	
	static int N; 
	static Long[][] dp; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		
		long result = 0;
		
		for(int i=0; i<10; i++) {
			dp[1][i] = 1L;
		}
		
		for(int i=1; i<10; i++) {
			result += fun(N,i);
		}
		
		System.out.println(result%1000000000);
	}
	
	public static long fun(int digit, int val) {
		
		if(digit == 1) {
			return dp[digit][val];
		}
		
		if(dp[digit][val] == null) {
			if(val == 0) {
				dp[digit][val] = fun(digit-1,1);
			}else if(val == 9) {
				dp[digit][val] = fun(digit-1,8);
			}else {
				dp[digit][val] = fun(digit-1,val+1)+fun(digit-1,val-1);
			}
		}
		
		return dp[digit][val] % 1000000000;
	}
}
