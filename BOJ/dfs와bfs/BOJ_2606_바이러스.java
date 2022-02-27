package dfs와bfs;

import java.io.*;
import java.util.*;

public class BOJ_2606_바이러스 {
	
	static Integer count = 0; //바이러스에 걸린 컴퓨터 개수 카운트
	static ArrayList<Integer>[] arr; //연결된 컴퓨터의 배열을 담을 변수
	static boolean[] visitCheck; //해당 컴퓨터 체크했는지 확인
	
	public static void main(String[] args) throws IOException {
		//입,출력 확인을 위한 부분
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer totalComNum; //총 컴퓨터 개수
		Integer connectionCount; //연결된 컴퓨터 개수
		
		
		totalComNum = Integer.parseInt(br.readLine());
		visitCheck = new boolean[totalComNum+1];
		connectionCount = Integer.parseInt(br.readLine());
		arr = new ArrayList[totalComNum+1];
		
		for(int i=0; i<connectionCount; i++) { //HashMap에 연결된 컴퓨터에 대한 정보를 넣기 위한 부분
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
		
		
		//1번 컴퓨터가 웜바이러스에 걸렸을 때
		visitCheck[1] = true;
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int comNum){
		for(int i=0; i<arr[comNum].size(); i++) {
			int selectedNum = arr[comNum].get(i);
			if(visitCheck[selectedNum]) { //검사가 이미 끝난경우
				continue;
			} else {
				count++;
				visitCheck[selectedNum] = true;
				dfs(selectedNum);
			}
		}
	}
}
