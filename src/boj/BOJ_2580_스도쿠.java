package boj;

import java.io.*;
import java.util.*;


public class BOJ_2580_스도쿠 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr = new int[9][9]; //스도쿠는 가로x세로가 81
	static ArrayList<Loc> arrList = new ArrayList<Loc>();
	static StringBuilder sb = new StringBuilder();
	static boolean findResult = false;
	
	public static void main(String[] args) throws IOException {
		
		for(int y=0; y<9; y++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int x=0; x<9; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == 0) arrList.add(new Loc(y,x));
			}
		}
		
		if(arrList.size() == 0) { //만약 처음부터 이미 스도쿠가 모두 맞춰진 상태라면
			printResult();
			return;
		}
		
		search(0); //arrList의 0번째부터 값을 하나씩 찾아가며 넣는다.
		
		
	}
	
	public static void search(int idx) {
		
		if(idx == arrList.size()) {
			printResult();
			findResult = true;
			return;
		}
		
		
		
		Loc loc = arrList.get(idx);
		int x = loc.x;
		int y = loc.y;
		
		for(int chk=1; chk<=9; chk++) { //1~9까지의 수가 있는지 확인하기 위함
			boolean flag = false;
			
			//가로줄 확인한다.
			for(int n=0; n<9; n++) { 
				if(arr[y][n] == chk) {
					flag = true; // 1~9까지의 수가 원래있다면
				}
			}
			
			//없는 수를 발견했다면 세로줄 확인
			if(!flag) {
				boolean secondFlag = false;
				for(int m=0; m<9; m++) { //가로줄 확인한다.
					if(arr[m][x] == chk) { 
						// chk 수가 세로줄에 원래있다면
						secondFlag = true;
						break;
					}
				}
				
				if(!secondFlag) {
					boolean thirdFlag = false;
					//3*3영역에서도 있는지 없는지 확인
					for(int dy = (y/3)*3; dy<((y/3)+1)*3; dy++) {
						for(int dx = (x/3)*3; dx<((x/3)+1)*3; dx++) {
							if(arr[dy][dx] == chk) {
								thirdFlag = true;
								break;
							}
						}
					}
					//가로,세로,3*3에서 모두 검증이 끝났다면
					if(!thirdFlag) {
						arr[y][x] = chk;
						search(idx+1);
						if(findResult) {
							return;
						}
						arr[y][x] = 0;
					}
				}
				

			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void printResult() { //스토쿠 완성후 결과를 출력하는 함수
		for(int y=0; y<9; y++) {
			for(int x=0; x<9; x++) {
				sb.append(arr[y][x]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	
	public static class Loc {
		int y;
		int x;
		
		Loc(){}
		
		Loc(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
