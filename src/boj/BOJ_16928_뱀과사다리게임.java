package boj;

import java.util.*;
import java.io.*;

public class BOJ_16928_�����ٸ����� {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static boolean[] visitCheck = new boolean[101]; 
	static int[] ladderAndSnake = new int[101];
	
	public static void main(String[] args) throws IOException {	
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		//��ٸ��� �ö󰡴��� ����Ÿ�� ���������Ĵ� �߿����� �ʴ�.
		//�ش� ĭ���� �̵��ϸ� ���� �ٸ� ĭ���� �̵��ϴٴ� ����� �߿�
		
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
				//���� �ش�ĭ�� �������� ���� && �ֻ����� �������� 100���� �۰ų� ���ƾ��Ѵ�.
				if(temp.getLoc()+i <=100 && !visitCheck[temp.getLoc()+i]) { 
					//�ش� ��ġ�� ��ٸ��� ���ΰ��
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
	private int loc; //������ġ
	private int count; //������ Ƚ��
	
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
