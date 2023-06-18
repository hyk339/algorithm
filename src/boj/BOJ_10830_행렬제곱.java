package boj;

import java.io.*;
import java.util.*;

public class BOJ_10830_행렬제곱 {
	
	static int N; //행렬의 크기
	static long B;
	static final int MOD = 1000; 
	static int[][] originArr;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		// 2023.06.18 parse Long을 해야한다.
		B = Long.parseLong(st.nextToken());
		
		originArr = new int[N][N];
		//행
		for(int i=0; i<N; i++) { 
			st = new StringTokenizer(br.readLine());
			//열
			for(int j=0; j<N; j++) { 
				originArr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		
		int[][] result = func(originArr,B);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static int[][] func(int[][] arr1, long num) {
		
		if(num == 1L) {
			return arr1;
		}
		
		
		int[][] temp = func(arr1,num/2);

		temp = multiply(temp,temp); 
		
		if(num%2 == 1L) {
			temp = multiply(originArr,temp);
		}
		
		return temp;
	}
	
	//행렬의 곱과 나머지를 계산하는 메서드
	public static int[][] multiply(int[][] o1, int[][] o2) {
		
		int[][] ret = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
				}
			}
		}
		return ret;
	}
}
