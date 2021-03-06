package boj??bfs;

import java.io.*;
import java.util.*;


public class BOJ_1012_???기농배추 {
	
	//????????? ?????? ??????
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int tx, ty;
	static int[][] arr;
	static boolean[][] visitCheck; //???????????? 체크
	static int count; //벌레??? 몇마??? ????????????????? count

	
	public static void main(String[] args) throws IOException {
		
		Integer testCaseNum = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCaseNum; i++) {
			count = 0;
			st = new StringTokenizer(br.readLine()," ");
			tx = Integer.parseInt(st.nextToken()); //배추??? ???로길???
			ty = Integer.parseInt(st.nextToken()); //배추??? ???로길???
			int n = Integer.parseInt(st.nextToken()); //????????? 배추 ??? 개수
			
			visitCheck = new boolean[ty][tx];
			detailLoc(tx,ty,n);
			
			for(int y=0; y<ty; y++) { //(0,0)?????? (x,y)까?? 모두 ??????
				for(int x=0; x<tx; x++) {
					if(arr[y][x] == 1 && !visitCheck[y][x]) {
						dfs(y,x);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void detailLoc(int x, int y, int n) throws IOException {
		arr = new int[y][x];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int tempx = Integer.parseInt(st.nextToken());
			int tempy = Integer.parseInt(st.nextToken());
			arr[tempy][tempx] = 1;
		}
	}
	
	private static void dfs(int y, int x) {
		visitCheck[y][x] = true;
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(newX>=0 && newY>=0 
				&& newX<tx && newY<ty 
				&& arr[newY][newX] == 1 
				&& !visitCheck[newY][newX]) {
				dfs(newY,newX);
			}
		}
	}

}
