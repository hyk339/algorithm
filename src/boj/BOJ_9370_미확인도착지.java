package boj;

import java.io.*;
import java.util.*;

public class BOJ_9370_미확인도착지 {
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int T; //테스트 케이스 수
	static int n; //교차로 수
	static int m; //도로 수
	static int t; //목적지 수
	static int s; //예술가들의 출발지
	static int g; //지나는 한점
	static int h; //지나는 다른 한점
	static int essentialCost; //반드시 지나야하는 도로 길이
	static int INF = Integer.MAX_VALUE;
	
	static ArrayList<BOJ9370>[] arr; 
	static ArrayList<Integer> destCandid; //목적지 후보를 담을 배열
	static int[] dist; //최단거리를 체크 할 배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) { //테스트 케이스 횟수만큼 반복
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			// 노드간 연결과 거리를 담기 전 배열 생성
			arr = new ArrayList[n+1];
			for(int k=1; k<=n; k++) { 
				arr[k] = new ArrayList<BOJ9370>();
			}
			
			//목적지 후보 배열 초기화
			destCandid = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());			
			 	int b = Integer.parseInt(st.nextToken());
			 	int d = Integer.parseInt(st.nextToken());
			 	
			 	arr[a].add(new BOJ9370(b,d));
			 	arr[b].add(new BOJ9370(a,d));
			 	
			 	//반드시 지나야하는 도로 길이 찾기
			 	if((a == g || a == h ) && (b == g || b == h )) {
			 		essentialCost = d;
			 	}
			}
			
			for(int k=0; k<t; k++) {
				destCandid.add(Integer.parseInt(br.readLine()));
			}
			
			func(); //메인 메서드
			sb.append("\n");
		}
		
		System.out.println(sb); //결과 출력
	}
	
	public static void func() {
		
		ArrayList<Integer> tempArr = new ArrayList<Integer>();
		
		for(int i=0; i<destCandid.size(); i++) {
			
			int result = INF;
			
			int dest = destCandid.get(i);
			//CASE1 - g를 갔다가 h를 가는 경우
			int res1 = dijkstra(s, g);
			int res2 = dijkstra(h, dest);
			
			if(res1 != INF && res2 != INF) {
				result = result > res1+res2+essentialCost ? res1+res2+essentialCost : result;
			}
			//CASE2 - h를 갔다가 g를 가는 경우
			int res3 = dijkstra(s, h);
			int res4 = dijkstra(g, dest);
			
			if(res3 != INF && res4 != INF) {
				result = result > res3+res4+essentialCost ? res3+res4+essentialCost : result;
			}
			
			//g,h를 무조건 거치는 경우와 g,h를 고려하지 않는 최단거리 비교 
			if(result != INF && dijkstra(s, dest) == result) {
				tempArr.add(dest);
			}
		}
		
		//결과를 내림차순으로 정렬한다.
		Collections.sort(tempArr);
		for(Integer num  : tempArr) {
			sb.append(num).append(" ");
		}
	}
	
	public static int dijkstra(int start, int end) {
		//교차로 초기화
		dist = new int[n+1]; 
		Arrays.fill(dist,INF);
		
		PriorityQueue<BOJ9370> pq = new PriorityQueue<BOJ9370>();
		pq.offer(new BOJ9370(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			BOJ9370 curr = pq.poll();
			int now = curr.to;
			int accumWeight = curr.weight;
			
			if(now == end) { //찾고자하는 종료지점을 찾았으면 종료
				return dist[end]; 
			}
			
			for(BOJ9370 node : arr[now]) {
				if(dist[node.to] > accumWeight + node.weight) {
					dist[node.to] = accumWeight + node.weight;
					pq.offer(new BOJ9370(node.to, dist[node.to]));
				}
			}
		}
		return INF;
	} 
}

class BOJ9370 implements Comparable<BOJ9370>{
	int to;
	int weight;
	
	BOJ9370(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
	
	public int compareTo(BOJ9370 obj) {
		return this.weight -obj.weight;
	}  
}
