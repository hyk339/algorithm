package boj;

import java.io.*;
import java.util.*;

// 2022.03.05 unsolved
// 2022.03.06 solved 
//  1. 자르고 난 나무들의 길이의 합이 내가 필요한 길이보다 크거나 같으면 left를 키워야한다.
//  2. 문제를 잘 읽자. 문제에 주어지는 나무의 최대의 길이가 20억으로 되어있다. 따라서 데이터 타입을 long으로 주어야한다.

public class BOJ_2805_나무자르기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] arr;
	static long max = 0;
	public static void main(String[] args) throws IOException {
		
		String firstRow = br.readLine();
		st = new StringTokenizer(firstRow," ");
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
	
		arr = new long[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]>max) max = arr[i];
		}
		
		long left = 0;
		long right = max;
		while(left<=right) {
			long length = 0;
			long mid = (left+right)/2;
			for(int j=0; j<N; j++) {
				if(mid<arr[j]) {
					length += arr[j]-mid;
				}
			}
			if(length >= M) {
				left = mid +1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(right);
	}
}
