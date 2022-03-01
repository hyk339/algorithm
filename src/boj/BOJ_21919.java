package boj;
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
		
		//lcm ìµœì†Œê³µë°°?ˆ˜
		//gcf ìµœë?ê³µì•½?ˆ˜
		
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
	
	
	//ìµœë? ê³µì•½?ˆ˜ êµ¬í•˜?Š” "?œ ?´ë¦¬ë“œ ?˜¸?ž¬ë²? ?™œ?š©"
	public static long lcm(long a, long b) {
		 while(a%b != 0) {
			long temp = a%b;
			a = b;
			b = temp;
		 }
	return b;
	}
	

	//ìµœì†Œ ê³µë°°?ˆ˜ë¥? êµ¬í• ?•Œ?Š” ?‘?ˆ˜?˜ ê³±ì—?„œ ìµœë?ê³µì•½?ˆ˜ë¥? ?‚˜?ˆ„?Š” ë°©ë²•?„ ?™œ?š©
	public static long gcf(long a, long b) {
		return a*b / lcm(a,b);
	}
}
