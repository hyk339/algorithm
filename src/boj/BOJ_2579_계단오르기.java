package boj;

import java.io.*;
import java.util.*;

public class BOJ_2579_계단오르기 {
	
	static int[] arr;
	static int[] dp;
	/* dp를 Integer 배열로 활용하는게 훨씬 깔끔하다.
	   dp[m] 값이 null이 아닌 것만 확인하면 되기 때문
	*/
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		 arr = new int[n+1];
		 dp = new int[n+1];
		 
		 for(int i=1; i<=n; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		 }
		 
		 dp[0] = arr[0];
		 dp[1] = arr[1];
		 if(n>=2) {
			 dp[2] = arr[1]+arr[2];
		 }
		 
		 
		 int result = fun(n);
		 System.out.println(result);
	}
	
	public static int fun(int loc) {
		if(dp[loc] == 0 && loc != 0) {
			dp[loc] = Math.max(fun(loc-2),(fun(loc-3)+arr[loc-1]))+arr[loc];
		}
		
		return dp[loc];
		
	}
}
