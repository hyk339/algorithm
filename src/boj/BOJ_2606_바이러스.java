package boj??bfs;

import java.io.*;
import java.util.*;

public class BOJ_2606_λ°μ΄?¬?€ {
	
	static Integer count = 0; //λ°μ΄?¬?€? κ±Έλ¦° μ»΄ν¨?° κ°μ μΉ΄μ΄?Έ
	static ArrayList<Integer>[] arr; //?°κ²°λ μ»΄ν¨?°? λ°°μ΄? ?΄? λ³??
	static boolean[] visitCheck; //?΄?Ή μ»΄ν¨?° μ²΄ν¬??μ§? ??Έ
	
	public static void main(String[] args) throws IOException {
		//?,μΆλ ₯ ??Έ? ?? λΆ?λΆ?
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer totalComNum; //μ΄? μ»΄ν¨?° κ°μ
		Integer connectionCount; //?°κ²°λ μ»΄ν¨?° κ°μ
		
		
		totalComNum = Integer.parseInt(br.readLine());
		visitCheck = new boolean[totalComNum+1];
		connectionCount = Integer.parseInt(br.readLine());
		arr = new ArrayList[totalComNum+1];
		
		for(int i=0; i<connectionCount; i++) { //HashMap? ?°κ²°λ μ»΄ν¨?°? ??? ? λ³΄λ?? ?£κΈ? ?? λΆ?λΆ?
			String twoComStr = br.readLine();
			st = new StringTokenizer(twoComStr);
			Integer firstCom = Integer.parseInt(st.nextToken());
			Integer secondCom = Integer.parseInt(st.nextToken());
			
			if(arr[firstCom] != null) {
				arr[firstCom].add(secondCom);
			} else {
				arr[firstCom] = new ArrayList<Integer>();
				arr[firstCom].add(secondCom);
			}
			
			if(arr[secondCom] != null) {
				arr[secondCom].add(firstCom);
			} else {
				arr[secondCom] = new ArrayList<Integer>();
				arr[secondCom].add(firstCom);
			}
		}
		
		
		//1λ²? μ»΄ν¨?°κ°? ?λ°μ΄?¬?€? κ±Έλ Έ? ?
		visitCheck[1] = true;
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int comNum){
		for(int i=0; i<arr[comNum].size(); i++) {
			int selectedNum = arr[comNum].get(i);
			if(visitCheck[selectedNum]) { //κ²??¬κ°? ?΄λ―? ??κ²½μ°
				continue;
			} else {
				count++;
				visitCheck[selectedNum] = true;
				dfs(selectedNum);
			}
		}
	}
}
