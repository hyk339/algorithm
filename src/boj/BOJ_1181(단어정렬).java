import java.io.*;
import java.util.*;

public class Main { //단어정렬
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[N];
		for(int i =0; i<N; i++) {
			strArr[i] = br.readLine();
		}
		Arrays.sort(strArr, new Comparator<String>() {
			public int compare(String str1, String str2) {
				if(str1.length() == str2.length()) {
					return str1.compareTo(str2);
				}
				return str1.length()-str2.length();
			}
		});
		sb.append(strArr[0]).append("\n");
		for(int i=1; i<N; i++) {
			if(!strArr[i].equals(strArr[i-1])) {
				sb.append(strArr[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
