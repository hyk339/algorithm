package boj;

import java.util.*;
import java.io.*;

public class BOJ_3273_�μ����� {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n; //������ ũ�� n
	static int[] arr; //n���� ���� ���� �迭
	static int x; //�μ��� ������ ���ϰ��� �ϴ� ��
	static int count; // ���ϰ��� �ϴ� ���� ����
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				// ������ �Ǿ��ֱ� ������ �μ��� ���� x���� ũ�ٸ� �������� Ȯ������ �ʾƵ� x���� ũ��
				if(arr[i] + arr[j] > x) break;  
				if(arr[i] + arr[j] == x ) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
