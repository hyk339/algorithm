package boj;

import java.io.*;
import java.util.*;

public class BOJ_1956_운동_재 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int V; //마을 갯수
	static int E; //도로 갯수
	static int[][] arr;
	static int minDistance = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int INF = Integer.MAX_VALUE;
		
		arr = new int[V+1][V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int fromPoint = Integer.parseInt(st.nextToken());
			int ToPoint = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			arr[fromPoint][ToPoint] = distance;
		}
		
		//길이가 주어지지 않은 값은 10000000(큰값)으로 초기화
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(arr[i][j]==0) {
					arr[i][j] = INF;
				}
			}
		}
		
		for(int a=1; a<=V; a++) { // a는 시작점
			for(int b=1; b<=V; b++) { //b는 도착점
				
				//시작점과 도착점이 같다면 넘어간다.
				if(a == b) continue; 
				
				//k는 거쳐가는 지점
				for(int k=1; k<=V; k++) { 
					if(a != k && b != k && INF != arr[a][k] && INF != arr[k][b]) {
						arr[a][b] = Math.min(arr[a][b], arr[a][k]+arr[k][b]);
					}
				}
			}
		}
		
		for(int a=1; a<=V; a++) { // a는 시작점
			for(int b=1; b<=V; b++) { //b는 도착점
				if(a != b && arr[a][b]!=INF && arr[b][a]!=INF) { 
					minDistance = Math.min(arr[a][b]+arr[b][a],minDistance);
				}
			}
		}
		
		if(minDistance == Integer.MAX_VALUE) {
			minDistance = -1;
		}
		
		System.out.println(minDistance);
	}
}
