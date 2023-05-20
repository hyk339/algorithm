package boj;

import java.io.*;
import java.util.*;

public class BOJ_1956_운동 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static int V; //마을 갯수
	static int E; //도로 갯수
	static int[][] arr;
	static int minDistance = Integer.MAX_VALUE;
	static boolean[] visitCheck;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		arr = new int[V+1][V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int fromPoint = Integer.parseInt(st.nextToken());
			int ToPoint = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			arr[fromPoint][ToPoint] = distance;
		}
		
		for(int i=1; i<V; i++) {
			visitCheck = new boolean[V+1];
			dfs(i,0,i);
		}
		
		System.out.println(minDistance);
	}
	
	public static void dfs(int from, int curr, int destination){
		
		// 계산도중 거리가 최소거리보다 길어도 멈춤
		if(minDistance < curr) {
			return;
		}
		
		// 다시 시작점으로 돌아왔을때 지금까지 확인한 거리와 비교
		if(curr !=0 && from == destination) {
			if(minDistance > curr) {
				minDistance = curr;
				return;
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(arr[from][i] != 0 && !visitCheck[i]) {
				visitCheck[i] = true; 
				dfs(i, curr+arr[from][i], destination);
				visitCheck[i] = false;
			}
		}
	}
}
