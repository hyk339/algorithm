package boj;

import java.io.*;
import java.util.*;

public class BOJ_1629_곱셈 {
	
	static int A;
	static int B;
	static int C;
	static String[] pattern;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pattern = new String[C];
		
		Arrays.fill(pattern,"N");
		
		findRemain();
		
	}
	
	public static void findRemain() {
		
		boolean check = false;
		int number = 1;
		int curr = A;
		int beforeDivnumber = 1;
		if(curr>=C) pattern[curr%C] = number+"";
		
		
		while(number<=B) { //거듭제곱 

			curr = curr*A;
			++number;
			
			if(curr>=C) {
				if(pattern[curr%C].equals("N")) {
					pattern[curr%C] = number+ "";
				}else {
					check = true; //패턴을 찾았다면 true로 바꾼다.
					break;
				}
			}else {
				beforeDivnumber = number;
			}
		}
		
		//거듭제곱을 해도 나누는 값보다 작을때
		if(curr < C) { 
			result = curr;

		}else if(!check) { //패턴을 찾기 전에 거듭제곱 횟수가 적어 끝났을경우
			for(int i=0; i<C; i++) {
				if(pattern[i].equals(String.valueOf(number))) {
					result = i;
					return;
				}
			}
		}else { //패턴을 찾아야하는 경우
			
		}
	}
}
