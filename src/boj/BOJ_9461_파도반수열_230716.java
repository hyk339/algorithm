package boj;

import java.io.*;
import java.util.*;

public class BOJ_9461_파도반수열_230716 {
	
	/*
	 * 2023-07-16 김현유 arr타입을 	Long으로 바꾸었더니 해결되었다.
	 *                 N이 100일때 값이 888,855,064,897가 나온다.
	 *                 int가 수용할 수 있는 21억을 넘었다.	
	 */
	static int T;
	static Long[] arr;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new Long[101];
		
		arr[1] = 1L;
		arr[2] = 1L;
		arr[3] = 1L;
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(fun(n)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static long fun(int num) {
		if(arr[num] == null) {
			arr[num] = fun(num-2)+fun(num-3);
		}
		
		return arr[num];
	}
}
