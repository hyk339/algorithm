package boj;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리_230719 {
	
	static int N;
	static int[][] arr;
	static Integer[][] dp;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<3; i++) {
			dp = new Integer[N][3];
			dp[N-1][0] = arr[N-1][0];
			dp[N-1][1] = arr[N-1][1];
			dp[N-1][2] = arr[N-1][2];
			int temp = fun(0,i);
			if(result == 0) {
				result = temp;
			}else {
				if(result > temp) {
					result = temp;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static int fun(int depth, int color) {
		if(dp[depth][color] == null) {
			if(color == 0) {
				dp[depth][color] = Math.min(fun(depth+1,1),fun(depth+1,2))+arr[depth][color];
			}else if(color == 1) {
				dp[depth][color] = Math.min(fun(depth+1,0),fun(depth+1,2))+arr[depth][color];
			}else {
				dp[depth][color] = Math.min(fun(depth+1,0),fun(depth+1,1))+arr[depth][color];
			}
		}
		
		return dp[depth][color]; 
		
	}
}
