package boj;

import java.io.*;
import java.util.*;

public class BOJ_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<int[]> strEnd = new ArrayList<int[]>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			strEnd.add(temp);
		}
		
		for(int i=0; i<M; i++) {
			int[] temp = strEnd.get(i);
			int sum = 0;
			for(int j=temp[0]-1; j<=temp[1]-1; j++ ) {
				sum = sum + arr.get(j);
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
