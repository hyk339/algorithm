package boj;

import java.io.*;
import java.util.*;

public class BOJ_2206_벽부수고이동하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; //행
	static int m; //열
	static int[][] arr; 
	static boolean[][][] visited; //방문여부 체크
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		String[] tempArr = br.readLine().split(" ");

		n = Integer.parseInt(tempArr[0]);
		m = Integer.parseInt(tempArr[1]);
		arr = new int[n][m];
		visited = new boolean[n][m][2];
		
		for (int y = 0; y < n; y++) {
			String tempStr = br.readLine();
			for (int x = 0; x < tempStr.length(); x++) {
				arr[y][x] = tempStr.charAt(x) - '0';
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Loc2206> q = new LinkedList<Loc2206>();
		q.offer(new Loc2206(0,0,1,false));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		while(!q.isEmpty()) {
			Loc2206 loc = q.poll();
			int x = loc.getX();
			int y = loc.getY();
			int count = loc.getCount();
			boolean destoryed = loc.isDestoryed();
			
			if(x == m-1 && y == n-1) {
				return count;
			}
			
			for(int i=0; i<4; i++) {
				if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<m && y+dy[i]<n) {
					if(arr[y+dy[i]][x+dx[i]] == 0) { //벽이 아니라면
						if(!destoryed && !visited[y+dy[i]][x+dx[i]][0]) { //부순적이 없고 방문한적이 없다면
							q.offer(new Loc2206(y+dy[i],x+dx[i],count+1,false));
							visited[y+dy[i]][x+dx[i]][0] = true;
						}else if(destoryed && !visited[y+dy[i]][x+dx[i]][1]){ //부순적이 있고 방문한적이 없다면
							q.offer(new Loc2206(y+dy[i],x+dx[i],count+1,true));
							visited[y+dy[i]][x+dx[i]][1] = true;
						}
					}else if(arr[y+dy[i]][x+dx[i]] == 1) { //벽이라면
						if(!destoryed && !visited[y+dy[i]][x+dx[i]][1]) {
							q.offer(new Loc2206(y+dy[i],x+dx[i],count+1,true));
							visited[y+dy[i]][x+dx[i]][1] = true;
						}
					}
				}
			}
		}
		
		return -1;
	}
}

class Loc2206 {
	private int y;
	private int x;
	private	int count;
	private	boolean destoryed;
	
	Loc2206(int y, int x, int count, boolean destoryed){
		this.y = y;
		this.x = x;
		this.count = count;
		this.destoryed = destoryed;
	}
	
	Loc2206(){};
	

	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isDestoryed() {
		return destoryed;
	}
	public void setDestoryed(boolean destoryed) {
		this.destoryed = destoryed;
	}
	@Override
	public String toString() {
		return "Loc2206 [y=" + y + ", x=" + x + ", count=" + count + ", destoryed=" + destoryed + "]";
	}
	
	
}
