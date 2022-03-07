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
		
		int low = 1; //부조건 최단거리는 1이다.
		int high = arr[N-1] - arr[0] + 1;
		
		
		
		while(low < high) {
			int count = 1;
			int lastLocate = arr[0];
			int mid = (high+low)/2;
			for(int i=1; i<N; i++) { //첫번째는 무조건 설치해서 1부터 시작
				if(arr[i]-lastLocate>=mid) {
					lastLocate = arr[i];
					count++;
				}
			}
			if(count < C) {
				high = mid;
			}else if(count >= C) {
				low = mid+1;
			}
		}
		System.out.println(low-1);
	}
}
