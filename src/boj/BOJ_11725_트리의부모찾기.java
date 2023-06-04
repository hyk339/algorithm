package boj;

import java.io.*;
import java.util.*;

public class BOJ_11725_트리의부모찾기 {
	
	static int N; //노드의 개수
	static ArrayList<Integer>[] arr;
	static boolean[] visitCheck;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visitCheck = new boolean[N+1];
		arr = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfs(1);
		
		for(int i=2; i<=N; i++) {
			sb.append(parent[i]+"\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int from) {
		for(int to : arr[from]) {
			if(!visitCheck[to]) {
				parent[to] = from;
				visitCheck[to] = true;
				dfs(to);
			}
		}
	}
}
