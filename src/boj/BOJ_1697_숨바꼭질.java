package boj;

import java.io.*;
import java.util.*;

public class BOJ_1697_¼û¹Ù²ÀÁú {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int K;
	static int[] timeArr = new int[100001];
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
				return timeArr[temp];
			}

			
			if(timeArr[temp-1] == 0 && temp-1 != N && temp-1>=0) {
				
				timeArr[temp-1] = timeArr[temp]+1;
				q.offer(temp-1);
			}
			if(timeArr[temp+1] == 0 && temp+1 != N && temp+1 <= 100000) {
			
				timeArr[temp+1] = timeArr[temp]+1;
				q.offer(temp+1);
			}
			if(timeArr[temp*2] == 0 && temp*2 != N && temp*2 <= 100000) {
				
				timeArr[temp*2] = timeArr[temp]+1;
				q.offer(temp*2);
			}
		}
		return -1;
	}
}
