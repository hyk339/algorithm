package boj;

import java.io.*;
import java.util.*;

public class BOJ_11404_플로이드 {
	
	static int n; //도시 개수
	static int m; //버스 개수
	static int INF = Integer.MAX_VALUE;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[a][b] > c ? c : arr[a][b];
		}
		
		for(int k=1; k<=n; k++) { //출발점
			for(int i=1; i<=n; i++) { //도착점
				//다른 점을 거쳐갈때를 확인
				for(int j=1; j<=n; j++) {
					if(i == j) continue;
					if(k!=i && k!=j 
					    && arr[i][k]!=INF && arr[k][j]!=INF
					    && arr[i][j] > arr[i][k] + arr[k][j]
					   ) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j] == INF) {
					sb.append("0").append(" ");
				}else{
					sb.append(arr[i][j]).append(" ");	
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
