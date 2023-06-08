package boj;

import java.io.*;
import java.util.*;

public class BOJ_4803_트리 {
	
	static int n; //정점의 개수
	static int m; //간선의 개순
	static StringTokenizer st;
	static ArrayList<Integer>[] arr;
	static boolean[] visitCheck;
	static int count;
	static boolean flag;
	static boolean flag2;
	static StringBuilder sb = new StringBuilder();
	static int caseCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			
			caseCount++;
			count = 0;
			visitCheck = new boolean[n+1];
			arr = new ArrayList[n+1];
			
			for(int i=1; i<=n; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			
			for(int i=1; i<=n; i++) {
				flag = true;
				flag2 = false;
				if(!visitCheck[i]) dfs(0,i);
			}
			
			if(count ==0) {
				sb.append("Case "+caseCount+": ").append("No trees.\n");
			}else if(count == 1) {
				sb.append("Case "+caseCount+": ").append("There is one tree.\n");
			}else {
				sb.append("Case "+caseCount+": ").append("A forest of "+count+" trees.\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void dfs(int from, int to) {
		visitCheck[to] = true;
		
		
		for(Integer next : arr[to]) {
			if(next == from) {
				continue;
			}
			else if(!visitCheck[next]) {
				dfs(to, next);
			}else {
				flag = false;//싸이클을 형성하는지 확인
			}
		}
		
		if(flag && from == 0) count++;
	}
}
