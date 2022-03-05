package boj;

import java.io.*;
import java.util.*;

public class BOJ_2805_나무자르기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		String firstRow = br.readLine();
		st = new StringTokenizer(firstRow," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>max) max = arr[i];
		}
		
		int left = 0;
		int right = max;
		while(left<right) {
			int length = 0;
			int mid = (left+right)/2;
			for(int j=0; j<N; j++) {
				if(mid<arr[j]) {
					length += arr[j]-mid;
				}
			}
			if(length >= M) {
				right = mid-1;
			}else {
				left = mid +1;
			}
		}
		System.out.println(right);
		
	}
}
