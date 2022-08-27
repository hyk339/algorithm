package boj;

import java.io.*;
import java.util.*;

public class BOJ_2798_블랙잭 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; //카드의 수
	static int M; //딜러가 부른 카드의 숫자
	static int[] arr;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		
	    st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j=0; j<N-2; j++) {
			for(int k=j+1; k<N-1; k++) {
				for(int l=k+1; l< N; l++) {
					int sum = arr[j]+arr[k]+arr[l];
					if(sum > M) continue;
					if(sum > result) result = sum;
				}
			}
		}
		System.out.println(result);
		
	}
}
