package boj;

import java.io.*;
import java.util.*;

public class BOJ_1904_01타일 {
	
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		arr = new int[1000001];
		arr[1] = 1;
		arr[2] = 2;
		System.out.println(func(num));
	}
	
	public static int func(int num) {
		if(arr[num] == 0) {
			arr[num] = (func(num-2)+func(num-1))%15746;
		}
		return arr[num];
	}
}
