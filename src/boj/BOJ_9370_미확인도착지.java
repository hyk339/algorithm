package boj;

import java.io.*;
import java.util.*;

public class BOJ_9370_미확인도착지 {
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int T; //테스트 케이스 수
	static int n; //교차로 수
	static int m; //도로 수
	static int t; //목적지 수
	static ArrayList<BOJ9370>[] arr; 
	static int[] dist;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
		T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) { //테스트 케이스 횟수만큼 반복
			
		}
	}
}

class BOJ9370 {
	int to;
	int weight;
	
	BOJ9370(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
}
