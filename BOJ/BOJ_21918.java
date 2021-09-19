import java.io.*;
import java.util.*;

public class Main {
	static int[] bulbStatus;
	static int N; //전구의 개수
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int M; //명령어의 개수
		
		
		String firstrow = br.readLine();
		st = new StringTokenizer(firstrow);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bulbStatus = new int[N+1];
		
		String secondrow = br.readLine();
		st = new StringTokenizer(secondrow);
		for(int i=1; i<=N; i++) {
			bulbStatus[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<=M; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken()); //a번째 명령어
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			fun(a,b,c);
		}
		
		for(int i=1; i<=N ; i++) {
			sb.append(bulbStatus[i]).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static void fun(int a, int b, int c) {
		if(a == 1) {
			bulbStatus[b] = c;
		} else if(a == 2) {
			for(int i=b; i<=c; i++) {
				if(bulbStatus[i]==0) {
					bulbStatus[i] = 1;
				}else {
					bulbStatus[i] = 0;
				}
			}
		} else if(a==3) {
			for(int i=b; i<=c; i++) {
				bulbStatus[i] = 0;
			}
		} else {
			for(int i=b; i<=c; i++) {
				bulbStatus[i] = 1;
			}
		}
	}
}
