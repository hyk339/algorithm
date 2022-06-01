package boj;

import java.util.*;
import java.io.*;

public class BOJ_16928_뱀과사다리게임 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] visitCheck = new boolean[101]; 
	static int[] ladderAndSnake = new int[101];
	
	public static void main(String[] args) throws IOException {	
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		//사다리로 올라가느냐 뱀을타고 내려가느냐는 중요하지 않다.
		//해당 칸으로 이동하면 전혀 다른 칸으로 이동하다는 사실이 중요
		
		int total = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		for(int i=0; i<total; i++) {
			st= new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladderAndSnake[x] = y;
		}
		
		bfs();
		System.out.println(sb);
	}
	
	static void bfs() {
		
		Queue<BOJ16928> q = new LinkedList<BOJ16928>();
		q.offer(new BOJ16928(1,0));
		
		while(!q.isEmpty()) {
			BOJ16928 temp = q.poll();
			
			if(temp.getLoc() == 100) {
				sb.append(temp.getCount());
			}
			
			for(int i=1; i<=6; i++) {
				//전에 해당칸이 나온적이 없고 && 주사위를 굴렸을때 100보다 작거나 같아야한다.
				if(temp.getLoc()+i <=100 && !visitCheck[temp.getLoc()+i]) { 
					//해당 위치가 사다리나 뱀인경우
					if(ladderAndSnake[temp.getLoc()+i] != 0) {
						q.offer(new BOJ16928(ladderAndSnake[temp.getLoc()+i],temp.getCount()+1));
					} else {
						q.offer(new BOJ16928(temp.getLoc()+i,temp.getCount()+1));
					}
					visitCheck[temp.getLoc()+i] = true;
				}
			}
		}
	}
}

class BOJ16928 {
	private int loc; //현재위치
	private int count; //움직인 횟수
	
	BOJ16928(int loc, int count){
		this.loc = loc;
		this.count = count;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
