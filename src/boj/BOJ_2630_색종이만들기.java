package boj;

import java.io.*;
import java.util.*;


public class BOJ_2630_�����̸���� {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static int blueCount = 0;
	static int whiteCount = 0;
	
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			st = new StringTokenizer(temp);
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0,N); //�����̸���� �Լ�����
		System.out.println(whiteCount);
		System.out.println(blueCount);
		
	}
	
	public static void func(int row, int column, int m) {
		int first = arr[row][column]; //���� ù��° ������ �����̻� 
		System.out.println("row : "+row+", column : "+column);
		System.out.println("first : "+first);
		
		for(int y=row; y<row+m; y++) {
			for(int x=column; x<column+m; x++) {
				System.out.println("arr["+y+"]["+x+"] : "+ arr[y][x]);
				if(arr[y][x] != first) { //���� ó�� ���� ������ ���� ���� ���� ���
					func(row, column, m/2);
					func(row, column+m/2, m/2);
					func(row+m/2, column, m/2);
					func(row+m/2, column+m/2, m/2);
					return;
				}		
			}
		}
		
		if(first == 0) { //�Ͼ���̸�
			whiteCount++;
			System.out.println("whiteCount : "+whiteCount);
		}else if(first == 1){ //�Ķ����̸�
			blueCount++;
			System.out.println("blueCount : "+blueCount);
		}
	}
	
}
