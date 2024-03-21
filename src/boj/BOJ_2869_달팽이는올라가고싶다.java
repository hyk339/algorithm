package boj;

import java.io.*;
import java.util.*;

public class BOJ_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
			
		int day = 0;
		int now = 0;
		while(true) {
			day++;
			now += a;
			if(now>= v) {
				break;
			}
			now -= b;
		}
		System.out.println(day);
	}
	
}

