package boj;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로_재 {
		
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<Edge1753재> pq = new PriorityQueue<Edge1753재>();
	
	static int V; //정점의 개수
	static int E; //간선의 개수
	static int K; //시작 정점의 번호
	static int INF = Integer.MAX_VALUE;
	
	static ArrayList<ArrayList<Edge1753재>> arr = new ArrayList<ArrayList<Edge1753재>>(); //입력받은 가중치를 담을 배열
	static int[] dist; //시작지점부터 해당 지점까지 가중치를 확인하며 담을 배열

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dist = new int[V+1];
		//V개수만큼 ArrayList를 만든다.
		
		for(int i=0; i<=V; i++) { 
			arr.add(new ArrayList<Edge1753재>());
			dist[i] = INF;
		}
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from   = Integer.parseInt(st.nextToken());
			int to     = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			arr.get(from).add(new Edge1753재(to, weight));
		}
		
		func(K);
	}
	
	static void func(int start){
		
		pq.offer(new Edge1753재(start,0));
		
		while(!pq.isEmpty()) {
			
			Edge1753재 currNode = pq.poll();
			int curr = currNode.to;
			
			if(currNode.weight > dist[curr]) continue;
			
			for(int j = 0; j<arr.get(curr).size(); j++) {
				
				if(dist[arr.get(curr).get(j).to] > dist[curr] + arr.get(curr).get(j).weight) {
					dist[arr.get(curr).get(j).to] = dist[curr] + arr.get(curr).get(j).weight;
				}
			}
		}
	}
}

class Edge1753재 implements Comparable<Edge1753재> {
	int to;     //도착점
	int weight; //가중치
	
	Edge1753재(int to, int weight){
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge1753재 object) {
		return this.weight - object.weight;
	}
	
}


