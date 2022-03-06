package boj;

import java.io.*;
import java.util.*;

// 2022.03.05 unsolved
// 2022.03.06 solved 
//  1. �ڸ��� �� �������� ������ ���� ���� �ʿ��� ���̺��� ũ�ų� ������ left�� Ű�����Ѵ�.
//  2. ������ �� ����. ������ �־����� ������ �ִ��� ���̰� 20������ �Ǿ��ִ�. ���� ������ Ÿ���� long���� �־���Ѵ�.

public class BOJ_2805_�����ڸ��� {
	
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
