package boj;

import java.util.*;
import java.io.*;

public class BOJ_7562_나이트의이동 {
	

	static StringBuilder sb = new StringBuilder(); //결과를 담을 곳
	static int[] dirX = {1,2,2,1,-1,-2,-2,-1}; //나이트가 이동할수 있는 8가지 경우
	static int[] dirY = {2,1,-1,-2,-2,-1,1,2}; //나이트가 이동할수 있는 8가지 경우
	static int l; //체스판 한변의 길이
	static boolean[][] visitCheck;
	static int startX; //시작점의 X좌표
	static int startY; //시작점의 Y좌표
	static int destX; //도착지점의 X좌표
	static int destY; //도착지점의 Y좌표
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCaseCount = Integer.parseInt(br.readLine());
		
		//테스트 케이스 횟수만큼 for문 반복
		for(int i=0; i<testCaseCount; i++) {
			l = Integer.parseInt(br.readLine());
			visitCheck = new boolean[l][l];
			//시작 지점의 위치를 담는다.
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
	
			//도착 지점의 위치를 담는다.
			st = new StringTokenizer(br.readLine());
			destX = Integer.parseInt(st.nextToken());
			destY = Integer.parseInt(st.nextToken());
			
			bfs(startY,startX);
			
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int y, int x) {
		
		Queue<NightLoc> q = new LinkedList<NightLoc>();
		q.offer(new NightLoc(y,x,0));
		visitCheck[y][x] = true;
		
		while(!q.isEmpty()) {
			NightLoc temp = q.poll();
			int tempX = temp.getX();
		    int tempY = temp.getY();
		    
		    //목표 좌표에 도착했다면
		    if(tempX == destX && tempY == destY) {
		    	sb.append(temp.getMoveCount()).append("\n");
		    	return;
		    }
		    
		    for(int i=0; i<8; i++) {	//8가지 방향을 이동시키고 count를 늘린다.
		    	if(tempX + dirX[i]>=0 && tempY + dirY[i]>=0 
		    	    && tempX + dirX[i]<l && tempY + dirY[i]<l
		    	    && !visitCheck[tempY + dirY[i]][tempX + dirX[i]]) {
		    			q.offer(new NightLoc(tempY + dirY[i],tempX + dirX[i],temp.getMoveCount()+1));
		    			visitCheck[tempY + dirY[i]][tempX + dirX[i]] = true;
		    		
		    	}
		    }
		    
		}
		
	}
	
}

class NightLoc {
	private int y;
	private int x;
	private int moveCount;
	
	NightLoc(int y, int x, int moveCount){
		this.y = y;
		this.x = x;
		this.moveCount = moveCount;
	}

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

	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}

}

