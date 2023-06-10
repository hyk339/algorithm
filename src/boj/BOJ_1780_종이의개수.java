package boj;

import java.io.*;
import java.util.*;

public class BOJ_1780_종이의개수 {
	
	static int N;
	static int[][] arr;
	static StringTokenizer st;
	static int minusOneCount; //-1의 개수를 Count
	static int zeroCount;	  //0의 개수를 Count
	static int oneCount;      //1의 개수를 Count
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int row=0; row<N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<N; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		countPaper(0,0,N);
		sb.append(minusOneCount+"\n");
		sb.append(zeroCount+"\n");
		sb.append(oneCount+"\n");
		System.out.println(sb);
	}
	static void countPaper(int rowStart, int colStart, int num) {
		int val = arr[rowStart][colStart];
		for(int i=rowStart; i<rowStart+num; i++) {
			for(int j=colStart; j<colStart+num; j++) {
				if(val != arr[i][j]) {
					// 0, 4
					countPaper(rowStart, colStart, num/3); 
					countPaper(rowStart, colStart+num/3, num/3); 
					countPaper(rowStart, colStart+num/3*2, num/3); 
					countPaper(rowStart+num/3, colStart, num/3); 
					countPaper(rowStart+num/3, colStart+num/3, num/3); 
					countPaper(rowStart+num/3, colStart+num/3*2, num/3); 
					countPaper(rowStart+num/3*2, colStart, num/3); 
					countPaper(rowStart+num/3*2, colStart+num/3, num/3); 
					countPaper(rowStart+num/3*2, colStart+num/3*2, num/3); 
					return;
				}
			}
		}
		
		if(val == -1) {
			minusOneCount++;
		}else if(val == 0) {
			zeroCount++;
		}else if(val == 1) {
			oneCount++;
		}
	}
}
