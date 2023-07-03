package boj;

import java.io.*;
import java.util.*;

public class BOJ_1149_RGB거리 {
	
	static int N;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[N-1][0] = arr[N-1][0];
		dp[N-1][1] = arr[N-1][1];
		dp[N-1][2] = arr[N-1][2];
		
		System.out.println(Math.min(cost(0,0), (Math.min(cost(0,1),cost(0,2)))));
	}
	
	public static int cost(int depth, int color) {
		if(dp[depth][color] == 0) {
			if(color==0) { //RED
				dp[depth][0] = Math.min(cost(depth+1,1),cost(depth+1,2))+arr[depth][0];
			}else if(color==1) { //GREEN
				dp[depth][1] = Math.min(cost(depth+1,0),cost(depth+1,2))+arr[depth][1];
			}else { //BLUE
				dp[depth][2] = Math.min(cost(depth+1,0),cost(depth+1,1))+arr[depth][2];
			}
		}
		
		return dp[depth][color];
	}
}
