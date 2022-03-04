package boj;

import java.io.*;
import java.util.*;

public class BOJ_1927_√÷º“»¸ {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		PriorityQueue pq = new PriorityQueue<Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(temp);
			}
		}
	}
}
