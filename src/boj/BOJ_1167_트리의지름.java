package boj;

import java.io.*;
import java.util.*;

public class BOJ_1167_트리의지름 {
	
	static int V; //정점의 개수
	static ArrayList<BOJ_1167>[] arr;
	static boolean[] visitedCheck; 
	static int result = 0;
	static int lastNode;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());	
		
		arr = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			arr[i] = new ArrayList<BOJ_1167>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				if(a==-1) {
					break;
				}
				int b = Integer.parseInt(st.nextToken());
				arr[from].add(new BOJ_1167(a,b));
			}
		}
		

		visitedCheck = new boolean[V+1];
		visitedCheck[1] = true;
		dfs(1,0);
		
		visitedCheck = new boolean[V+1];
		visitedCheck[lastNode] = true;
		dfs(lastNode,0);
		
		System.out.println(result);
	}
	
	static void dfs(int start, int totalDistance) {
		
		if(totalDistance > result) {
			result = totalDistance;
			lastNode = start;
		}
		
		for(BOJ_1167 curr : arr[start]) {
			if(!visitedCheck[curr.to]) {
				visitedCheck[curr.to] = true;
				dfs(curr.to,totalDistance+curr.dist);
				visitedCheck[curr.to] = false;
			}
		}
	}
}

class BOJ_1167{
	int to;
	int dist;
	
	BOJ_1167(int to, int dist){
		this.to = to;
		this.dist = dist;
	}
}
