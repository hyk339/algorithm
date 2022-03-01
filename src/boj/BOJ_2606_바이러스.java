package boj??bfs;

import java.io.*;
import java.util.*;

public class BOJ_2606_ë°”ì´?Ÿ¬?Š¤ {
	
	static Integer count = 0; //ë°”ì´?Ÿ¬?Š¤?— ê±¸ë¦° ì»´í“¨?„° ê°œìˆ˜ ì¹´ìš´?Š¸
	static ArrayList<Integer>[] arr; //?—°ê²°ëœ ì»´í“¨?„°?˜ ë°°ì—´?„ ?‹´?„ ë³??ˆ˜
	static boolean[] visitCheck; //?•´?‹¹ ì»´í“¨?„° ì²´í¬?–ˆ?Š”ì§? ?™•?¸
	
	public static void main(String[] args) throws IOException {
		//?…,ì¶œë ¥ ?™•?¸?„ ?œ„?•œ ë¶?ë¶?
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer totalComNum; //ì´? ì»´í“¨?„° ê°œìˆ˜
		Integer connectionCount; //?—°ê²°ëœ ì»´í“¨?„° ê°œìˆ˜
		
		
		totalComNum = Integer.parseInt(br.readLine());
		visitCheck = new boolean[totalComNum+1];
		connectionCount = Integer.parseInt(br.readLine());
		arr = new ArrayList[totalComNum+1];
		
		for(int i=0; i<connectionCount; i++) { //HashMap?— ?—°ê²°ëœ ì»´í“¨?„°?— ???•œ ? •ë³´ë?? ?„£ê¸? ?œ„?•œ ë¶?ë¶?
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
		
		
		//1ë²? ì»´í“¨?„°ê°? ?›œë°”ì´?Ÿ¬?Š¤?— ê±¸ë ¸?„ ?•Œ
		visitCheck[1] = true;
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int comNum){
		for(int i=0; i<arr[comNum].size(); i++) {
			int selectedNum = arr[comNum].get(i);
			if(visitCheck[selectedNum]) { //ê²??‚¬ê°? ?´ë¯? ??‚œê²½ìš°
				continue;
			} else {
				count++;
				visitCheck[selectedNum] = true;
				dfs(selectedNum);
			}
		}
	}
}
