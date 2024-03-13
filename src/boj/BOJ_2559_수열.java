package boj;

import java.io.*;
import java.util.*;

public class BOJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N+1];
		int sum = 0;
		int maxVal = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
			
			if(i>=K) {
				int result = arr[i]-arr[i-K]; 
				if(result>maxVal) maxVal = result;
			}
		}
		System.out.println(maxVal);
		
	}
}
