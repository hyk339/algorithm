package boj;

import java.io.*;
import java.util.*;

public class BOJ_1992_쿼드트리 {
	
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		quardTree(0,0,N);
		System.out.println(sb);
	}
	
	static void quardTree(int rowStart, int colStart, int num) {
		
		int val = arr[rowStart][colStart];
		
		for(int row=rowStart; row<rowStart+num; row++) {
			for(int col=colStart; col<colStart+num; col++) {
				if(val != arr[row][col]) {
					sb.append("(");
					quardTree(rowStart, colStart, num/2);
					quardTree(rowStart, colStart+num/2, num/2);
					quardTree(rowStart+num/2, colStart, num/2);
					quardTree(rowStart+num/2, colStart+num/2, num/2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(val);
	}
}
