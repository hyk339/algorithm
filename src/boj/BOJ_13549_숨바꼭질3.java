package boj;

import java.io.*;
import java.util.*;

public class BOJ_13549_숨바꼭질3 {
	
	static int N; //수빈의 현재점
	static int K; //동생의 현재점
	static int[] dist= new int[100001];
	static int result = 0;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		Arrays.fill(dist, INF);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N>=K) {
			result = N-K;
		}else {
			djstra(N,K);
		}
		
		System.out.println(result);
		
	}
	
	static void djstra(int start, int end) {
		PriorityQueue<BOJ13549> pq = new PriorityQueue<BOJ13549>();
		
		pq.offer(new BOJ13549(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			BOJ13549 curr = pq.poll();
			
			if(curr.to == end) {
				result = dist[curr.to];
			}
			
			if(curr.to != 0 && curr.to*2 <=100000 && dist[curr.to*2] > curr.weight) {
				dist[curr.to*2] = curr.weight;
				pq.offer(new BOJ13549(curr.to*2, dist[curr.to*2]));
			}
			
			if(curr.to != 100000 && dist[curr.to+1] > curr.weight + 1) {
				dist[curr.to+1] = curr.weight+1;
				pq.offer(new BOJ13549(curr.to+1, dist[curr.to+1]));
			}
			
			if(curr.to != 0 && dist[curr.to-1] > curr.weight + 1) {
				dist[curr.to-1] = curr.weight+1;
				pq.offer(new BOJ13549(curr.to-1, dist[curr.to-1]));
			}
		}
	}
	
	
}

class BOJ13549 implements Comparable<BOJ13549>{
	
	int to;
	int weight;
	
	BOJ13549(int to, int weight){
		this.to = to;
		this.weight = weight;
	};
	
	public int compareTo(BOJ13549 obj) {
		return this.weight - obj.weight;
	}
}
