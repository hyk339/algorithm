package boj??bfs;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이?��?�� {
	
	static Integer count = 0; //바이?��?��?�� 걸린 컴퓨?�� 개수 카운?��
	static ArrayList<Integer>[] arr; //?��결된 컴퓨?��?�� 배열?�� ?��?�� �??��
	static boolean[] visitCheck; //?��?�� 컴퓨?�� 체크?��?���? ?��?��
	
	public static void main(String[] args) throws IOException {
		//?��,출력 ?��?��?�� ?��?�� �?�?
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer totalComNum; //�? 컴퓨?�� 개수
		Integer connectionCount; //?��결된 컴퓨?�� 개수
		
		
		totalComNum = Integer.parseInt(br.readLine());
		visitCheck = new boolean[totalComNum+1];
		connectionCount = Integer.parseInt(br.readLine());
		arr = new ArrayList[totalComNum+1];
		
		for(int i=0; i<connectionCount; i++) { //HashMap?�� ?��결된 컴퓨?��?�� ???�� ?��보�?? ?���? ?��?�� �?�?
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
		
		
		//1�? 컴퓨?���? ?��바이?��?��?�� 걸렸?�� ?��
		visitCheck[1] = true;
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int comNum){
		for(int i=0; i<arr[comNum].size(); i++) {
			int selectedNum = arr[comNum].get(i);
			if(visitCheck[selectedNum]) { //�??���? ?���? ?��?��경우
				continue;
			} else {
				count++;
				visitCheck[selectedNum] = true;
				dfs(selectedNum);
			}
		}
	}
}
