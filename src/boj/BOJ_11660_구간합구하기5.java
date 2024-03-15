package boj;

import java.io.*;
import java.util.*;

public class BOJ_11660_구간합구하기5 {
	
	static StringBuilder sb = new StringBuilder();
	static int N; //표의 크기 N
	static int M; //합을 구해야하는 횟수
	static int[][] dp;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 1; k <= m; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = x1; i <= x2; i++) {
                sum = sum + (dp[i][y2] - dp[i][y1-1]);
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}
