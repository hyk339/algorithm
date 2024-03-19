package boj;

import java.io.*;
import java.util.*;

public class BOJ_2839_설탕배달 {	
	
	static int n; //배달할 설탕 kg
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int result = -1;
		int result1 = func1(n);
		System.out.println(result1);
		if(result1 != -1) {
			result = result1;
		}
		int result2 = func2(n);
		if(result2 != -1 && result == -1) {
			result = result2;
		}else if(result2 != -1 && result != -1) {
			result = result2 < result ? result2 : result;
		}
		System.out.println(result2);
		int result3 = func3(n);
		if(result3 != -1 && result == -1) {
			result = result3;
		}else if(result3 != -1 && result != -1) {
			result = result3 < result ? result3 : result;
		}
		System.out.println(result3);
		System.out.println(result);
		
	}
	
	public static int func1(int n) {
		int count = 0;
		if(n/5 > 0) {
			count += n/5;
			n = n%5;
		}
		
		if(n/3 > 0) {
			count += n/3;
			n = n%3;
		}
		
		if(n>0) return -1;
		
		return count;
	}
	
	public static int func2(int n) {
		if(n%5 == 0) {
			return n/5;
		}else if(n%3 == 0) {
			return n/3;
		}else {
			return -1;
		}
	}
	
	public static int func3(int n) {
		int count = 0;
		if(n/3 > 0) {
			count += n/3;
			n = n%3;
		}
		System.out.println(n);
		if(n/5 > 0) {
			count += n/5;
			n = n%5;
		}
		System.out.println(n);
		if(n>0) return -1;
		return count;
	}
	
}
