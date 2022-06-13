package boj;

import java.util.*;
import java.io.*;

public class BOJ_3273_두수의합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n; //수열의 크기 n
	static int[] arr; //n개의 수를 담을 배열
	static int x; //두수의 합으로 구하고자 하는 값
	static int count; // 구하고자 하는 쌍의 갯수
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				// 정렬이 되어있기 때문에 두수의 합이 x보다 크다면 다음수는 확인하지 않아도 x보다 크다
				if(arr[i] + arr[j] > x) break;  
				if(arr[i] + arr[j] == x ) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
