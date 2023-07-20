package boj;

import java.io.*;
import java.util.*;

public class BOJ_1932_정수삼각형_230720 {
	
	static int n;
	static int[][] arr;
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		dp = new Integer[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i==n-1) {
					dp[i][j] = arr[i][j];
				}
			}
		}
		
		System.out.println(fun(0,0));
	}
	
	public static int fun(int depth, int loc) {
		if(dp[depth][loc] == null) {
			dp[depth][loc] = Math.max(fun(depth+1,loc),fun(depth+1,loc+1))+arr[depth][loc];
		}
		return dp[depth][loc];
	}
}
