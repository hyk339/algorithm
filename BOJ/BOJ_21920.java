import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		long sum = 0;
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		String strArr = br.readLine();
		int X = Integer.parseInt(br.readLine());
		st = new StringTokenizer(strArr);
		
		for(int i=0; i<N; i++) {
			long num = Integer.parseInt(st.nextToken());
			if(gcd(num,X)==1) {
				sum += num;
				count++;
			}
		}
		
		System.out.println((double)sum/count);
	}
	
	public static long gcd(long x, long y) {
		
		while(y != 0) {
			long temp = x%y;
			x = y;
			y = temp;
		}
		return x;
	}
}
