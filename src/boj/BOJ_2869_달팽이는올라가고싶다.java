package boj;

import java.io.*;
import java.util.*;

public class BOJ_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		
		/* 도저히 사고가 안되어 답을 보았다.
		 * 전체길이에서 내려가는 것을 하나를 빼고
		 * (올라가는 것 - 내려가는 것)으로 나눈다 
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
			
		int day = (v-b)/(a-b);
		if((v-b)%(a-b) != 0) {
			day += 1;
		}
		System.out.println(day);
	}
	
}

