package boj;

import java.io.*;
import java.util.*;

public class BOJ_11444_피보나치수6 {
	
	static long n;
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		
		int result = 0;
		int a = 0;
		int b = 1;
		if(n == 1L) {
			result = 1;
		}else {
			result = func(a,b,2);
		}
		System.out.println(result);
		
	}
	
	public static int func(int val1, int val2, long next) {
		
		int nextVal = (val1+val2)%MOD;
		
		if(next == n) {
			return nextVal;
		}
		return func(val2,nextVal,next+1);
	}
}
