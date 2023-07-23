package boj;

import java.io.*;
import java.util.*;

public class BOJ_1463_1로만들기_230723 {
	/*
	 * 2023.07.23 시간초과..
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int result = fun(num);
		System.out.println(result);
	}
	static int fun(int n) {
		
		int result = 0;
		if(n == 1) {
			return result;
		}else {
			if(n%6 == 0) {
				result = Math.min(Math.min(fun(n/3), fun(n/2)),fun(n-1))+1;
			}else if(n%3 == 0) {
				result = Math.min(fun(n/3), fun(n-1))+1;				
			}else if(n%2 == 0) {
				result = Math.min(fun(n/2), fun(n-1))+1;				
			}else {
				result = fun(n-1)+1;
			}
		}
		return result;	
	}
}
