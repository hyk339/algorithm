package boj;

import java.io.*;
import java.util.*;

public class BOJ_1504_특정한최단경로 {
	
	static int N; //정점의 개수
	static int E; //간선의 개수
	static ArrayList<Edge1504>[] arr;  
	
	static int point1; //거쳐야 하는 첫번째 정점
	static int point2; //거쳐야 하는 두번째 정점
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int INF = Integer.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<Edge1504>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[from].add(new Edge1504(to, weight));
			arr[to].add(new Edge1504(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		point1 = Integer.parseInt(st.nextToken());
		point2 = Integer.parseInt(st.nextToken());
		
		
		int result1 = func(1,point1);
		int result2 = func(point1,point2);
		int result3 = func(point2,N);
		
		int finalResult = -1;
		if(result1 != INF && result2 != INF && result3 != INF) {
			finalResult = result1+result2+result3;
		}
		
		int result4 = func(1,point2);
		int result5 = func(point2,point1);
		int result6 = func(point1,N);
		
		if(result4 != INF && result5 != INF && result6 != INF) {
			if(finalResult == -1) {
				finalResult = result4+result5+result6;
			}else {
				if(finalResult > result4+result5+result6) {
					finalResult = result4+result5+result6;
				}
			}
		}
		
		System.out.println(finalResult);
		
	}
	
	public static int func(int start, int end) {
		int INF = Integer.MAX_VALUE; 
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Edge1504> pq = new PriorityQueue<Edge1504>();
		pq.add(new Edge1504(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge1504 curr = pq.poll();
			if(curr.getLoc() == end) {
				return dist[end];
			}
			
			ArrayList<Edge1504> temp = arr[curr.getLoc()];
			for(int i=0; i<temp.size(); i++) {
				if( dist[temp.get(i).getLoc()] > curr.getWeight()+temp.get(i).getWeight()) {
					dist[temp.get(i).getLoc()] = curr.getWeight()+temp.get(i).getWeight();
					pq.offer(new Edge1504(temp.get(i).getLoc(),dist[temp.get(i).getLoc()]));
				}
			}
		}
		
		
		
		return 0;
	}
}

class Edge1504 implements Comparable<Edge1504> {
	private int loc;
	private int weight;
	
	Edge1504(int loc, int weight){
		this.loc = loc;
		this.weight = weight;
	}
	
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int compareTo(Edge1504 o) {
		return this.weight-o.weight;
	}
	
}
