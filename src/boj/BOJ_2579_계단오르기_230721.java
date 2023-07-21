package boj;

import java.io.*;
import java.util.*;

public class BOJ_2579_계단오르기_230721 {
	
	static int n;
	static int[] arr;
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new Integer[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		/* 2023-07-21
		 * 계단의 수가 1개일 수도 있으므로 if(n>=2) 조건이 필요하다.
		 */
		if(n>=2) {
			 dp[2] = arr[1]+arr[2];
		 }
		int result = fun(n);
		System.out.println(result);
	}
	
	public static int fun(int num) {
		if(dp[num] == null) {
			dp[num] = Math.max(fun(num-2), fun(num-3)+arr[num-1])+arr[num];
		}
		return dp[num];
	}
}
