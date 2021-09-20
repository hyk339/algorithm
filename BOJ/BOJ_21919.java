import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		long result = 1;
		
		long N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		st = new StringTokenizer(str);
		
		//lcm 최소공배수
		//gcf 최대공약수
		
		for(int i=0; i<N; i++) {
			long num = Integer.parseInt(st.nextToken());
			if(check(num)) {
				result = gcf(result,num);
			}
		}
		
		if(result == 1) {
			result = -1;
		}
		
		System.out.println(result);
	}
	
	public static boolean check(long num) {
		for(long i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	
	//최대 공약수 구하는 "유클리드 호재법 활용"
	public static long lcm(long a, long b) {
		 while(a%b != 0) {
			long temp = a%b;
			a = b;
			b = temp;
		 }
	return b;
	}
	

	//최소 공배수를 구할때는 두수의 곱에서 최대공약수를 나누는 방법을 활용
	public static long gcf(long a, long b) {
		return a*b / lcm(a,b);
	}
}
