package boj;

import java.io.*;
import java.util.*;

public class BOJ_2525_¿Àºì½Ã°è {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String tempStr = br.readLine();
		String[] arr = tempStr.split(" ");
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		int C = Integer.parseInt(br.readLine());
		
		int hour = 0;
		int minute = 0;
		
		if(B+C>=60) {
			int share = (B+C)/60;
			int remain = (B+C)%60;
			minute = remain;
			if(A+share >=24) {
				hour = A+share-24;
			}else {
				hour = A+share;
			}
		}else {
		   hour = A;
	       minute = B+C;
		}
		sb.append(hour).append(" ").append(minute);
		System.out.println(sb);
	}
}
