package boj;

import java.io.*;
import java.util.*;

public class BOJ_1912_연속합_230718 {
	
	static int n;
	static int[] arr;
	static Integer[] dp;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		result = dp[0];
		fun(n-1);
		
		System.out.println(result);
		
	}
	
	static int fun(int num) {
		if(dp[num] == null) {
			dp[num] = Math.max(arr[num], fun(num-1)+arr[num]);
			if(dp[num] > result) {
				result = dp[num]; 
			}
		}
		
		return dp[num];
	}
}
