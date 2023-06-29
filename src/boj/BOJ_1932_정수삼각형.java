package boj;

import java.io.*;
import java.util.*;

public class BOJ_1932_정수삼각형 {

	static int n; //삼각형의 크기
	static int[][] arr;
	static Integer[][] dp;
 	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new Integer[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == n-1) {
					dp[i][j] = arr[i][j];
				}
			}
		}
		System.out.println(find(0,0));
 	}
	
	public static int find(int depth, int index) {
		if(depth == n-1) {
			return dp[depth][index];
		}
		
		if(dp[depth][index] == null) {
			dp[depth][index] = Math.max(find(depth+1,index), find(depth+1,index+1))+arr[depth][index];
		}
		
		return dp[depth][index];
	}
}
