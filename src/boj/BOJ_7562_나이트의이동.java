package boj;

import java.util.*;
import java.io.*;

public class BOJ_7562_����Ʈ���̵� {
	

	static StringBuilder sb = new StringBuilder(); //����� ���� ��
	static int[] dirX = {1,2,2,1,-1,-2,-2,-1}; //����Ʈ�� �̵��Ҽ� �ִ� 8���� ���
	static int[] dirY = {2,1,-1,-2,-2,-1,1,2}; //����Ʈ�� �̵��Ҽ� �ִ� 8���� ���
	static int l; //ü���� �Ѻ��� ����
	static boolean[][] visitCheck;
	static int startX; //�������� X��ǥ
	static int startY; //�������� Y��ǥ
	static int destX; //���������� X��ǥ
	static int destY; //���������� Y��ǥ
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCaseCount = Integer.parseInt(br.readLine());
		
		//�׽�Ʈ ���̽� Ƚ����ŭ for�� �ݺ�
		for(int i=0; i<testCaseCount; i++) {
			l = Integer.parseInt(br.readLine());
			visitCheck = new boolean[l][l];
			//���� ������ ��ġ�� ��´�.
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
	
			//���� ������ ��ġ�� ��´�.
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
		    
		    //��ǥ ��ǥ�� �����ߴٸ�
		    if(tempX == destX && tempY == destY) {
		    	sb.append(temp.getMoveCount()).append("\n");
		    	return;
		    }
		    
		    for(int i=0; i<8; i++) {	//8���� ������ �̵���Ű�� count�� �ø���.
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

