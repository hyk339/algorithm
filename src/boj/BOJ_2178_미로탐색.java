package boj;

import java.io.*;
import java.util.*;

public class BOJ_2178_미로탐색 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
	static int[][] arr;
	static int count = Integer.MAX_VALUE;
	static int yNum;
	static int xNum;
	static boolean[][] visitCheck;
	
	public static void main(String[] args) throws IOException {
		String[] tempArr = br.readLine().split(" ");
		yNum = Integer.parseInt(tempArr[0]);
		xNum = Integer.parseInt(tempArr[1]);
		arr = new int[yNum][xNum];
		visitCheck = new boolean[yNum][xNum];
		
		for(int i=0; i<yNum; i++) {
			String temp = br.readLine();
			for(int j=0; j<xNum; j++) {
				arr[i][j] = Integer.parseInt(temp.substring(j, j+1));
			}
		}
		dfs(0,0,1);
		System.out.println(count);
	}

	public static void dfs(int y, int x, int ct) {
		visitCheck[y][x] = true;
		//목표 지점까지 도착했을때 count를 바꾸는 부분
		if(y == yNum-1 && x == xNum-1 && ct<count) {
			count = ct;
			return;
		}
		for(int i=0; i<4; i++) {
			if(y+dy[i]>=0 && x+dx[i]>=0 && y+dy[i]<yNum && x+dx[i]<xNum
					&& arr[y+dy[i]][x+dx[i]]==1
					&& !visitCheck[y+dy[i]][x+dx[i]]) {
				dfs(y+dy[i],x+dx[i], ct+1);
				visitCheck[y+dy[i]][x+dx[i]] = false;
			}
		}
	}
}
