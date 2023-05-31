package boj;

import java.io.*;
import java.util.*;

public class BOJ_11657_타임머신 {
	/*
	 * 음수인 경로를 갈수있는 도시를 2번 가게 되면 무한히 반복한다.
	 * 0 또는 양수인 경로는 2번 탈 수 있다.
	 */
	static int N; //도시의 개수
	static int M; //버스 노선의 개수
	static long[] dist;
	static ArrayList<BOJ11657>[] arr;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		//음의 경로로 갈 수 있는 경로를 방문하면 true로 바꾼다.
		arr = new ArrayList[N+1];
	
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<BOJ11657>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[from].add(new BOJ11657(to,weight));
		}
		
		if(bell()) {
			for(int i=2; i<=N; i++) {
				if(dist[i] == INF) {
					sb.append(-1).append("\n");
				}else {
					sb.append(dist[i]).append("\n");
				}
			}
		}else {
			sb.append("-1");
		}
		
		System.out.println(sb);
	}
	
	static boolean bell() {
		dist[1] = 0;
	
		for(int i=1; i<N; i++) { //N-1회만 돈다
			for(int j=1; j<=N; j++) {
				//if(dist[j] == INF) break;
				for(int k=0; k<arr[j].size(); k++) {
					if(dist[j] == INF) break;
					BOJ11657 curr = arr[j].get(k);
					
					if(dist[curr.to] > dist[j]+curr.weight) {
						dist[curr.to] = dist[j]+curr.weight;
					}
				}
			}
		}
		
		for(int j=1; j<=N; j++) { 
			for(int k=0; k<arr[j].size(); k++) {
				if(dist[j] == INF) break;
				BOJ11657 curr = arr[j].get(k);
				if(dist[curr.to] > dist[j]+curr.weight) {
					return false;
				}
			}
		}
		
		return true;
	}
}

class BOJ11657 implements Comparable<BOJ11657>{
	int to;
	int weight;
	
	BOJ11657(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
	
	public int compareTo(BOJ11657 obj) {
		return this.weight-obj.weight;
	}
	
}
