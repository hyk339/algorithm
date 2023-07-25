package boj;

import java.io.*;
import java.util.*;

public class BOJ_2156_포도주시식 {
	//잔의 개수
	static int n;
	static int[] arr;
	static Integer dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new Integer[n+1];
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		dp[1] = arr[1];
		if(n>1) {
			dp[2] = arr[1]+arr[2];
		}
		int result = fun(n);
		System.out.println(result);
	}
	
	public static int fun(int num) {
		if(dp[num] == null) {
			dp[num] = Math.max(Math.max(fun(num-3)+arr[num-1], fun(num-2))+arr[num],fun(num-1));
		}
		return dp[num];
	}
}
