package boj;

import java.io.*;
import java.util.*;

public class BOJ_12865_평범한배낭 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N; 		// 물품의 수
	static int K; 		// 버틸 수 있는 무게
	static int result = 0;  // 가치합의 최댓값
	static WeightAndValue_12865[] arr;
	
	public static void main(String[] args) throws IOException {
		
		String[] strArr = br.readLine().split(" ");
		N = Integer.parseInt(strArr[0]);
		K = Integer.parseInt(strArr[1]);
		
		arr = new WeightAndValue_12865[N];
		for(int i=0; i<N; i++) {
			strArr = br.readLine().split(" ");
			arr[i] = new WeightAndValue_12865(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]));
		}
		
		for(int i=0; i<N; i++) {
			check(i,0,0);
		}
		System.out.println(result);
	}
	
	public static void check(int idx, int currWeight, int currValue) {
		
		int tempWeight = arr[idx].weight;
		int tempValue = arr[idx].value;
		
		// 지금까지 더한 무게와 새로운 문품의 무게 합이 버틸수 있는 무게보다 크다면 stop 
		if(currWeight+tempWeight > K) {
			if(result < currValue) result = currValue;
			return;
		} else {
			for(int i=idx+1; i<N; i++) {
				check(i,currWeight + tempWeight, currValue + tempValue);
			}
		}
	}
}

class WeightAndValue_12865 {
	int weight;
	int value;
	
	WeightAndValue_12865(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
}