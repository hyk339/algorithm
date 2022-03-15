package boj;

import java.io.*;
import java.util.*;

public class BOJ_2178_¹Ì·ÎÅ½»ö {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
	static int[][] arr;
	static int count = Integer.MAX_VALUE;
	static int yNum;
	static int xNum;
	static int[][] visitCheck;
	
	public static void main(String[] args) throws IOException {
		String[] tempArr = br.readLine().split(" ");
		yNum = Integer.parseInt(tempArr[0]);
		xNum = Integer.parseInt(tempArr[1]);
		arr = new int[yNum][xNum];
		visitCheck = new int[yNum][xNum];
		
		for(int i=0; i<yNum; i++) {
			String temp = br.readLine();
			for(int j=0; j<xNum; j++) {
				arr[i][j] = Integer.parseInt(temp.substring(j, j+1));
			}
		}
		visitCheck[0][0] = 1;

		System.out.println(bfs(0,0));
	}

	public static int bfs(int y, int x) {
		Queue<Loc2178> q = new LinkedList<Loc2178>();
		q.offer(new Loc2178(x,y));
		
		while(!q.isEmpty()) {
			Loc2178 loc = q.poll();
			int tx = loc.x;
			int ty = loc.y;
			if(tx == (xNum-1) && ty == (yNum-1)) {
				return visitCheck[ty][tx];
			}
			
			for(int i=0; i<4; i++) {
				if(ty+dy[i]>=0 && tx+dx[i]>=0 && ty+dy[i]<yNum && tx+dx[i]<xNum
						&& arr[ty+dy[i]][tx+dx[i]]==1
						&& visitCheck[ty+dy[i]][tx+dx[i]] == 0) {
					q.offer(new Loc2178(tx+dx[i], ty+dy[i]));
					visitCheck[ty+dy[i]][tx+dx[i]] = visitCheck[ty][tx]+1;
				}
			}
		}
		return -1;
	}
}

class Loc2178{
	int x;
	int y;
	
	Loc2178(){}
	Loc2178(int x, int y){
		this.x = x;
		this.y = y;
	}
}
