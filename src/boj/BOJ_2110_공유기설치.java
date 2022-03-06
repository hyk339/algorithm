package boj;

import java.io.*;
import java.util.*;

public class BOJ_2110_�����⼳ġ {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String[]  tempArr = br.readLine().split(" ");
		int N = Integer.parseInt(tempArr[0]); //���� ����
		int C = Integer.parseInt(tempArr[1]); //������ ����
		int arr[] = new int[N]; //���� ��ġ�� ����ִ� �迭
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); //����
		
		int left = 1; //������ �ִܰŸ��� 1�̴�.
		int right = arr[N-1];
		
		System.out.println("left : "+left);
		System.out.println("right : "+right);
		
		int count = 1;
		int mid = 0;
		while(left < right) {
			mid = (right+left)/2;
			int nowLoc = left;
			for(int i=1; i<N; i++) { //ù��°�� ������ ��ġ�ؼ� 1���� ����
				if(nowLoc+mid<=arr[i]) {
					nowLoc = arr[i];
					count++;
				}
			}
			if(count >= C) {
				left = mid+1;
			}else if(count < C) {
				right = mid-1;
			}
		}
		System.out.println(mid);
	}
}
