package boj;

import java.io.*;
import java.util.*;

public class BOJ_2720_세탁소사장동혁 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int money = Integer.parseInt(br.readLine());
			if(money/25 > 0 && money>0) {
				sb.append(money/25).append(" ");
				money = money%25;
			}
			if(money/10 > 0 && money>0) {
				sb.append(money/10).append(" ");
				money = money%10;
			}else {
				sb.append(0).append(" ");
			}
			if(money/5 > 0 && money>0) {
				sb.append(money/5).append(" ");
				money = money%5;
			}else {
				sb.append(0).append(" ");
			}
			if(money/1 > 0 && money>0) {
				sb.append(money/1).append(" ");
				money = money%1;
			}else {
				sb.append(0).append(" ");
			}
			sb.append("\n");
		}
		
		
		System.out.print(sb);
		
	}
}
