package boj;

import java.io.*;
import java.util.*;

public class BOJ_11279_최대힙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		PriorityQueue pq = new PriorityQueue(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1-o2);
			}
		});
		
		int n = Integer.parseInt(br.readLine()); //입력받는 숫자 갯수
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0 && pq.isEmpty()) {
				System.out.println("0");
			}else if(num == 0 && !pq.isEmpty()){
				System.out.println(pq.poll());
			}else {
				pq.offer(num);
			}
		}
	}
}
