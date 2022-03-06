package boj;

import java.io.*;
import java.util.*;

public class BOJ_2110_공유기설치 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String[]  tempArr = br.readLine().split(" ");
		int N = Integer.parseInt(tempArr[0]); //집의 개수
		int C = Integer.parseInt(tempArr[1]); //공유기 개수
		int arr[] = new int[N]; //집의 위치가 들어있는 배열
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); //정렬
		
		int left = 1; //부조건 최단거리는 1이다.
		int right = arr[N-1];
		
		System.out.println("left : "+left);
		System.out.println("right : "+right);
		
		int count = 1;
		int mid = 0;
		while(left < right) {
			mid = (right+left)/2;
			int nowLoc = left;
			for(int i=1; i<N; i++) { //첫번째는 무조건 설치해서 1부터 시작
				if(nowLoc+mid<=arr[i]) {
					nowLoc = arr[i];
					count++;
				}
			}
			if(count >= C) {
				left = mid+1;
			}else if(count < C) {
				right = mid-1;
			}
		}
		System.out.println(mid);
	}
}
