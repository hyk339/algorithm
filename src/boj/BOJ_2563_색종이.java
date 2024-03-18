package boj;

import java.io.*;
import java.util.*;

public class BOJ_2563_색종이 {
	public static boolean[][] check = new boolean[101][101]; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			func(x,y);
		}
		
		int count = 0;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100; j++) {
				if(check[i][j]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		
	}
	private static void func(int x, int y){
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				check[i][j] = true;
			}
		}
	}
}
