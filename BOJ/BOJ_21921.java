import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N,X = 0;
		int[] arr = null;
		int max = 0;
		int count = 0;
		int sum = 0;
		
		String firstRow = br.readLine();
		st = new StringTokenizer(firstRow);
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
		String secondRow = br.readLine();
		st = new StringTokenizer(secondRow);
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i<=X) {
				sum += arr[i];
				count = 1;
				max = sum;
			}
		}
		
		int left = 1;
		int right = X;

		while(true) {
			right++;
			left++;
			
			if(right > N) break;
			
			sum = sum-arr[left-1]+arr[right];
			
			if(sum > max) {
				max = sum;
				count = 1;
			}else if(sum == max) {
				count++;
			}
		}

		if(max == 0) {
			System.out.println("SAD");
			return;
		} else {
			System.out.println(max);
			System.out.println(count);
		}
		
	}
}
