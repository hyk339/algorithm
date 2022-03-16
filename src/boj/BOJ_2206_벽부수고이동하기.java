package boj;

import java.io.*;
import java.util.*;


public class BOJ_2206_벽부수고이동하기 {
	
	static int N; //행
	static int M; //열
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tempStrArr = br.readLine().split(" ");
		N = Integer.parseInt(tempStrArr[0]);
		M = Integer.parseInt(tempStrArr[1]);
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String tempStr = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = tempStr.charAt(j)-'0';
			}
			System.out.println(Arrays.toString(arr[i]));
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Loc2206> q = new LinkedList<Loc2206>();
		q.offer(new Loc2206(0,0,1,false));
		
		while(!q.isEmpty()) {
			Loc2206 loc = q.poll();
			int y = loc.y;
			int x = loc.x;
			int count = loc.count;
			boolean breakWall = loc.breakWall;
			for(int i=0; i<4; i++) {
				if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<M && y+dy[i]<N) {
					if(arr[y+dy[i]][x+dx[i]] == 0)
				}
			}
		}
	};
}

class Loc2206 {
	int y;
	int x;
	int count;
	boolean breakWall;
	
	Loc2206(){}
	Loc2206(int y, int x, int count, boolean breakWall){
		this.y = y;
		this.x = x;
		this.count = count;
		this.breakWall = breakWall;
	}
}
