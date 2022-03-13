package boj;

import java.io.*;
import java.util.*;


public class BOJ_7569_토마토 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M; //column의수
	static int N; //row 칸의수
	static int H; //높이
	static int[][][] arr;
	static ArrayList<Loc> rottenList = new ArrayList<Loc>();;
	static int result;
	static boolean flag; //전부다 익은상태인지 아닌지 확인하는 flag
	static boolean[][][] check;
	static int[] dx = new int[] {-1,0,1,0,0,0}; //좌, 상, 우, 하, 위, 아래
	static int[] dy = new int[] {0,1,0,-1,0,0};
	static int[] dz = new int[] {0,0,0,0,1,-1};
	static int totalCount = 0; //익지않은 토마토 수
	
	
	public static void main(String[] args) throws IOException {
		String temp = br.readLine();
		st = new StringTokenizer(temp);
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];
		check = new boolean[H][N][M];
		
		for(int z = 0; z < H; z++) {
			for(int y = 0; y<N; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x<M ; x++) {
					arr[z][y][x] = Integer.parseInt(st.nextToken());
					if(arr[z][y][x] == 1) {
						rottenList.add(new Loc(z,y,x,0));
					}else if(arr[z][y][x] == 0) {
						flag = true;
						totalCount++;
					}
				}
			}
		}
		System.out.println(dfs());
	}
	
	public static int dfs() {
		int lastDay=0;
		int rawTomatoCount = 0;
		Queue<Loc> q = new LinkedList<Loc>();
		
		if(!flag) {
			return 0 ;	
		}
		
		for(int i=0; i<rottenList.size(); i++) { //시작
			q.offer(rottenList.get(i));
		}
		
		while(!q.isEmpty()) {
			Loc temp = q.poll();
			int z = temp.z;
			int y = temp.y;
			int x = temp.x;
			int day = temp.day;
			lastDay = day;
			
			for(int i=0; i<6; i++) {
				if(z+dz[i]>=0 && y+dy[i]>=0 && x+dx[i]>=0
					&& z+dz[i]<H && y+dy[i]<N && x+dx[i]<M
					&& !check[z+dz[i]][y+dy[i]][x+dx[i]]
					&& arr[z+dz[i]][y+dy[i]][x+dx[i]] == 0
					) {
						q.offer(new Loc(z+dz[i],y+dy[i],x+dx[i], day+1));
						check[z+dz[i]][y+dy[i]][x+dx[i]] = true;
						rawTomatoCount++;
					}
			}

		}
		
		if(rawTomatoCount != totalCount) {

			return -1;
		}
		return lastDay;
		
	}
}

class Loc {
	int z;
	int y;
	int x;
	int day;
	
	Loc(){};
	
	Loc(int z, int y, int x, int day){
		this.z = z;
		this.y = y;
		this.x = x;
		this.day = day;
	}
}


