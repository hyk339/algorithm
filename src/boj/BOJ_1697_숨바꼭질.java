package boj;

import java.io.*;
import java.util.*;

public class BOJ_1697_¼û¹Ù²ÀÁú {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int K;
	static int minSecond = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		
		dfs(N,0);
		System.out.println(minSecond);
	}
	
	public static void dfs(int loc, int second) {
		if(loc == K) {
			if(second < minSecond) minSecond = second;
			return;
		}
		
		if(loc-1>=0 && loc-1 <= 100000 && Math.abs(K-loc)>Math.abs(K-loc-1)) {
			dfs(loc-1, second+1);
		}
		
		if(loc+1>=0 && loc+1 <= 100000 && Math.abs(K-loc)>Math.abs(K-loc+1)) {
			dfs(loc+1, second+1);
		}
		
		if(loc*2>=0 && loc*2 <= 100000 && Math.abs(K-loc)>Math.abs(K-(loc*2))) {
			dfs(loc*2, second+1);
		}
	}
}
