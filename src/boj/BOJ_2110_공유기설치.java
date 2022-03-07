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
		
		int low = 1; //������ �ִܰŸ��� 1�̴�.
		int high = arr[N-1] - arr[0] + 1;
		
		
		
		while(low < high) {
			int count = 1;
			int lastLocate = arr[0];
			int mid = (high+low)/2;
			for(int i=1; i<N; i++) { //ù��°�� ������ ��ġ�ؼ� 1���� ����
				if(arr[i]-lastLocate>=mid) {
					lastLocate = arr[i];
					count++;
				}
			}
			if(count < C) {
				high = mid;
			}else if(count >= C) {
				low = mid+1;
			}
		}
		System.out.println(low-1);
	}
}
