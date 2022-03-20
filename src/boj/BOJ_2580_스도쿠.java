package boj;

import java.io.*;
import java.util.*;


public class BOJ_2580_������ {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr = new int[9][9]; //������� ����x���ΰ� 81
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
		
		if(arrList.size() == 0) { //���� ó������ �̹� ������ ��� ������ ���¶��
			printResult();
			return;
		}
		
		search(0); //arrList�� 0��°���� ���� �ϳ��� ã�ư��� �ִ´�.
		
		
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
		
		for(int chk=1; chk<=9; chk++) { //1~9������ ���� �ִ��� Ȯ���ϱ� ����
			boolean flag = false;
			
			//������ Ȯ���Ѵ�.
			for(int n=0; n<9; n++) { 
				if(arr[y][n] == chk) {
					flag = true; // 1~9������ ���� �����ִٸ�
				}
			}
			
			//���� ���� �߰��ߴٸ� ������ Ȯ��
			if(!flag) {
				boolean secondFlag = false;
				for(int m=0; m<9; m++) { //������ Ȯ���Ѵ�.
					if(arr[m][x] == chk) { 
						// chk ���� �����ٿ� �����ִٸ�
						secondFlag = true;
						break;
					}
				}
				
				if(!secondFlag) {
					boolean thirdFlag = false;
					//3*3���������� �ִ��� ������ Ȯ��
					for(int dy = (y/3)*3; dy<((y/3)+1)*3; dy++) {
						for(int dx = (x/3)*3; dx<((x/3)+1)*3; dx++) {
							if(arr[dy][dx] == chk) {
								thirdFlag = true;
								break;
							}
						}
					}
					//����,����,3*3���� ��� ������ �����ٸ�
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
	
	
	
	
	
	
	
	
	
	
	public static void printResult() { //������ �ϼ��� ����� ����ϴ� �Լ�
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
