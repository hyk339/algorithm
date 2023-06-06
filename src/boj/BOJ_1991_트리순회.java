package boj;

import java.io.*;
import java.util.*;

public class BOJ_1991_트리순회 {
	
	static int N; //트리의 노드의 개수 
	static HashMap<String,Node> hm = new HashMap<String,Node>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String center = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			hm.put(center, new Node(left,right));
		}
		
		preorder("A");
		sb.append("\n");
		inorder("A");
		sb.append("\n");
		postorder("A");
		
		System.out.println(sb);
	}
	
	static void preorder(String center) {
		sb.append(center);
		
		Node curr = hm.get(center);
		if(!curr.left.equals(".")) {
			preorder(curr.left);
		}
		
		if(!curr.right.equals(".")) {
			preorder(curr.right);
		}
	}
	
	static void inorder(String center) {
		
		Node curr = hm.get(center);
		if(!curr.left.equals(".")) {
			inorder(curr.left);
		}
		
		sb.append(center);
		
		if(!curr.right.equals(".")) {
			inorder(curr.right);
		}
	}
	
	static void postorder(String center) {
		Node curr = hm.get(center);
		if(!curr.left.equals(".")) {
			postorder(curr.left);
		}
		
		
		if(!curr.right.equals(".")) {
			postorder(curr.right);
		}
		
		sb.append(center);
		
	}
	
	static class Node {
		String left;
		String right;
		
		Node(String left, String right){
			this.left = left;
			this.right = right;
		}
	}
}
