package boj;

import java.io.*;
import java.util.*;


public class BOJ_2630_색종이만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			st = new StringTokenizer(temp);
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(N);
	}
	
	public static void func(int m) {
		int first = 0;
		for(int y=0; y<m; y++) {
			for(int x=0; x<m; x++) {
				if(y==0 && x==0) {first = arr[y][x];}
				if(first != arr[y][x]) {
					func(m/2);
					
				}
			}
		}
		
	}
}
