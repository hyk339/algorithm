package boj;

import java.io.*;
import java.util.*;

public class BOJ_15649_N과M1 {
	
	static StringBuilder sb = new StringBuilder(); 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		for(int i=1; i<=N; i++) {
			//초기화
			check = new boolean[N+1];
			
			dfs(i,"",0);
			
		}
		System.out.println(sb);
	}
	

	
	public static void dfs(int k, String str, int count) {
		
		check[k] = true;
		str +=k+" ";
		count++;
		System.out.println("k : "+k);
		System.out.println("str : "+str);
		System.out.println("count : "+count);
		if(count == M) {
			str += "\n";
			sb.append(str);
			return;
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println("k : "+k);
			System.out.println("str : "+str);
			System.out.println("count : "+count);
			
			if(!check[i]) {
				
				dfs(i,str,count);
				
				check[i] = false;
			}
		}
	}
}
