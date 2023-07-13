package boj;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기 {
	
	static int N;
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0] = 0;
		dp[1] = 0;
		
		int result = fun(N);
		System.out.println(result);
	}
	
	public static int fun(int k) {
		
		if(dp[k] == null) {
			if(k % 6 == 0) {
				dp[k] = Math.min(Math.min(fun(k/2), fun(k/3)),fun(k-1))+1;
			}else if(k % 3 == 0) {
				dp[k] = Math.min(fun(k/3),fun(k-1))+1;
			}else if(k % 2 == 0) {
				dp[k] = Math.min(fun(k/2),fun(k-1))+1;
			}else {
				dp[k] = fun(k-1)+1;
			}
		}
		return dp[k];
	}
}
