package boj;

import java.io.*;
import java.util.*;

public class BOJ_2470_두용액 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N; //전체 용액의 수
	static int[] arr; //용액을 담아둘 배열
	static int leftIdx; //왼쪽 인덱스
	static int rightIdx; //오른쪽 인덱스
	static int gap = Integer.MAX_VALUE; // 두수의 차이를 담을 곳(절대값)
	static int sum = Integer.MAX_VALUE; // 두수의 합을 담을 곳
	static int leftAns; //결과 값을 담을 곳
	static int rightAns; // 결과 값을 담을 곳 
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 배열을 오름차순으로 정렬
		
		leftIdx = 0;
		rightIdx = N-1;
		
		while(leftIdx < rightIdx) { // 왼쪽 index가 오른쪽 index보다 작을때까지 반복
			sum = arr[leftIdx] + arr[rightIdx];
			
			if(Math.abs(sum) < gap) { 
				gap = Math.abs(sum);
				leftAns = arr[leftIdx];
				rightAns = arr[rightIdx];
				
			}
			
			if(sum > 0) {
				rightIdx--;
			} else {
				leftIdx++;
			}
		}
		
		sb.append(leftAns).append(" ").append(rightAns);
		System.out.println(sb);
	}
}
