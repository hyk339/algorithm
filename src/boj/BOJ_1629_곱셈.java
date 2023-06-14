package boj;

import java.io.*;
import java.util.*;

public class BOJ_1629_곱셈 {
	
	static long A;
	static long B;
	static long C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long result = func(A,B,C);
		System.out.println(result);

	}

	public static long func(long a, long b, long c) {
		if(b==0) {
			return 1;
		}
		if(b%2 == 1) {
			return (a * (func(a,b-1,c))) % c;
		}
		long k = func(a,b/2,c);
		return (k*k)%c;
	}
}

