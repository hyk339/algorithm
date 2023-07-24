package boj;

import java.io.*;
import java.util.*;

public class BOJ_2156_포도주시식 {
	//잔의 개수
	static int n;
	static int[] arr;
	static Integer dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new Integer[n];
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}
}
