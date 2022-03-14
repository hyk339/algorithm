package boj;

import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int K;
	static int[] visited = new int[100001];
	public static void main(String[] args) throws IOException{
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		K = Integer.parseInt(arr[1]);
		
		int result = bfs(N);
		System.out.println(result);
	}
	
	public static int bfs(int loc) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(loc);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp == K) {
				return visited[temp];
			}

			
			if(temp-1>=0 && visited[temp-1] == 0 && temp-1 != N) { // visited[-1]은 outofbound이다.
				
				visited[temp-1] = visited[temp]+1;
				q.offer(temp-1);
			}
			if(temp+1 <= 100000 && visited[temp+1] == 0 && temp+1 != N) {
			
				visited[temp+1] = visited[temp]+1;
				q.offer(temp+1);
			}
			if(temp*2 <= 100000 && visited[temp*2] == 0 && temp*2 != N) {
				
				visited[temp*2] = visited[temp]+1;
				q.offer(temp*2);
			}
		}
		return -1;
	}
}
