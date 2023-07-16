package boj;

import java.io.*;
import java.util.*;

public class BOJ_9461_파도반수열_230716 {
	
	static int T;
	static Integer[] arr;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new Integer[101];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(fun(n)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int fun(int num) {
		if(arr[num] == null) {
			arr[num] = fun(num-2)+fun(num-3);
		}
		
		return arr[num];
	}
}
