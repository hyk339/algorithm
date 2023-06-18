package boj;

import java.io.*;
import java.util.*;

public class BOJ_10830_행렬제곱 {
	static int N; //행렬의 크기
	static long B;
	static final int MOD = 1000; 
	static long[][] originArr;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		originArr = new long[N][N];
		//행
		for(int i=0; i<N; i++) { 
			st = new StringTokenizer(br.readLine());
			//열
			for(int j=0; j<N; j++) { 
				originArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] result = func(originArr,B);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static long[][] func(long[][] arr1, long num) {
		
		if(num == 1L) {
			return arr1;
		}
		
		if(num%2 == 1L) {
			return multiply(arr1,func(arr1,num-1));
		}
		
		long[][] temp = func(arr1,num/2);
		return multiply(temp,temp);
	}
	
	//행렬의 곱과 나머지를 계산하는 메서드
	public static long[][] multiply(long[][] arr2, long[][] arr3) {
		long[][] ret = new long[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					ret[i][j] += arr2[i][k]+arr3[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
}
