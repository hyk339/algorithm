package boj;

import java.io.*;
import java.util.*;

public class BOJ_9461_파도반수열 {
	public static int t;
	public static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int temp = Integer.parseInt(br.readLine());
			sb.append(func(1,1,1,1,temp)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int func(int num, int val1, int val2, int val3, int purpose) {
		if(num == purpose) {
			return val1;
		}
		return func(num+1,val2,val3,val1+val2,purpose);
	}
	
}
