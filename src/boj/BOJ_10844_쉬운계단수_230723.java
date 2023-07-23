package boj;

import java.io.*;
import java.util.*;

public class BOJ_10844_쉬운계단수_230723 {
	
	/*
	 * 20230723 시간초과
	 */
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		long result = 0;
		for(int i=1; i<=9; i++) {
			result += fun(i,1) % 1000000000;			
		}
		result %= 1000000000;
		System.out.println(result);
	}
	
	static long fun(int num, int idx) {
		
		long temp = 1L;
		if(idx == N) {
			return temp;
		}else {
			if(num == 0) {
				temp =  fun(1,idx+1);
			}else if(num == 9) {
				temp =  fun(8,idx+1);
			}else {
				temp = fun(num-1,idx+1)+fun(num+1,idx+1);
			}
		}
		return temp;
	}
}

