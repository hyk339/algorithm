package boj;

import java.io.*;
import java.util.*;

public class BOJ_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		/* 
		 * 시간 초과로 실패하였다. 다른 분들의 풀이를 확인해보았다.
		 * 처음 N개의 수가 주어졌을때, 배열에 N개의 수를 그대로 담는것이 아니라
		 * 합한 수를 배열에 담고 M개의 시작점과 끝의 합을 계산할때 
		 * 합을 담아둔 배열의 끝에서 시작점을 빼는 식으로 풀었다. 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		int tempSum = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tempSum += Integer.parseInt(st.nextToken());
			arr.add(tempSum);
		}
		
		ArrayList<int[]> strEnd = new ArrayList<int[]>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			strEnd.add(temp);
		}
		
		for(int i=0; i<M; i++) {
			int[] temp = strEnd.get(i);
			int endSum = arr.get(temp[1]-1);
			int startSum = temp[0]-2 >= 0 ? arr.get(temp[0]-2): 0;
			System.out.println(endSum-startSum);
			
		}
		
		
	}
}
