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
	static boolean[] minusVisitCheck; //음수로 갈 수 있는 도시를 다시 방문하는 경우 check 
	static int[] dist;
	static ArrayList<BOJ11657>[] arr;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		//음의 경로로 갈 수 있는 경로를 방문하면 true로 바꾼다.
		minusVisitCheck = new boolean[N+1]; 
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
		int result = djkstra(1);
		
		if(result == -1) {
			sb.append("-1");
		}else {
			for(int i=2; i<=N; i++) {
				if(dist[i] != INF) {
					sb.append(dist[i]).append("\n");
				}else{
					sb.append("-1").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static int djkstra(int start) {
		PriorityQueue<BOJ11657> pq = new PriorityQueue<BOJ11657>();
		pq.offer(new BOJ11657(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			BOJ11657 curr = pq.poll();
			int now = curr.to;
			int accumWeight = curr.weight;
			
			for(BOJ11657 node : arr[now]) {
				if(dist[node.to] > node.weight + accumWeight) {
					if(!minusVisitCheck[node.to] && node.weight<0) {
						minusVisitCheck[node.to] = true;
					}else if(minusVisitCheck[node.to] && node.weight<0) {
						//음의 경로를 2번 타는 경우
						return -1;
					}
					dist[node.to] = node.weight + accumWeight;
					pq.offer(new BOJ11657(node.to,dist[node.to]));
				}
			}
		}
		return 0;
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
