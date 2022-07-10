package boj;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
		
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int V; //정점의 개수
	static int E; //간선의 개수
	static int K; //시작 정점의 번호
	
	static int[] dist; //현재 지점까지 가중치를 담을 배열
	static ArrayList<Edge1753>[] arr;//그래프를 담을 곳 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		
		for(int i=1; i<=V; i++) { //각 정점 가중치값 초기화
			dist[i] = Integer.MAX_VALUE;
		}
		
		arr = new ArrayList[V+1];

		for(int i=1; i<=V; i++) { //먼저 ArrayList를 만들어서 넣는다.
			arr[i] = new ArrayList<Edge1753>();
		}
		
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			arr[from].add(new Edge1753(to, weight));
		}
		
		dijkstra(K);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else{
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		
		PriorityQueue<Edge1753> q = new PriorityQueue<Edge1753>();
		dist[start] = 0;
		q.offer(new Edge1753(start,0));
		
		while(!q.isEmpty()) {
			Edge1753 now = q.poll();
			
			if(now.cost > dist[now.loc]) continue;
			
			int arrSize = arr[now.loc].size();
			for(int i=0; i<arrSize; i++) {
				Edge1753 next = arr[now.loc].get(i);
	
				//현재지점의 비용 + 이동할 위치의 비용 < 다음이동할 위치의 현재 비용
				if(now.cost + next.cost < dist[next.loc]) { //가중치가 적어졌을때만 다음 것을 확인할 필요성이 생긴다.
					dist[next.loc] = now.cost + next.cost;
					q.offer(new Edge1753(next.loc, dist[next.loc]));
	
				}
			}
			
		}
	}
	
}

class Edge1753 implements Comparable<Edge1753> {
	int loc; //이동할지점
	int cost; //가중치
	
	Edge1753(int loc, int cost){
		this.loc = loc;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge1753 o) {
		return this.cost - o.cost;
	}
}


