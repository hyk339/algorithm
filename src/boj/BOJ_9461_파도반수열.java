package boj;

import java.io.*;
import java.util.*;

public class BOJ_9461_파도반수열 {
	public static int t;
	public static Long[] arr = new Long[101];
	public static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		
		arr[1] = 1L;
		arr[2] = 1L;
		arr[3] = 1L;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int temp = Integer.parseInt(br.readLine());
			sb.append(func(temp)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static Long func(int N) {
		if(arr[N] == null) {
			arr[N] = func(N-3)+func(N-2);
		}
		
		return arr[N];
	}
	
}
