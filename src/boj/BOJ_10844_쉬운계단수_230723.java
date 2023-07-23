package boj;

import java.io.*;
import java.util.*;

public class BOJ_10844_쉬운계단수_230723 {
	
	/*
	 * 20230723 시간초과
	 * 20230723 결국 전에 풀었던 풀이를 보았다.
	 *          각자리수 까지의 횟수를 저장할때 1000000000 이상을 저장할 필요없이
	 *          나눈 나머지 값만 저장하면 된다.
	 */
	static int N;
	static Long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new Long[N+1][10];
		long result = 0;
		for(int i=1; i<=9; i++) {
			result += fun(1,i);			
		}
		result %= 1000000000;
		System.out.println(result);
	}
	
	static long fun(int idx, int num) {
		
		if(dp[idx][num] == null) {
			if(idx == N) {
				dp[idx][num] = 1L;
			}else {
				if(num == 0) {
					dp[idx][num] =  fun(idx+1,1);
				}else if(num == 9) {
					dp[idx][num] =  fun(idx+1,8);
				}else {
					dp[idx][num] = fun(idx+1, num-1)+fun(idx+1, num+1);
				}
			}
		}
		return dp[idx][num] % 1000000000;
	}
}

