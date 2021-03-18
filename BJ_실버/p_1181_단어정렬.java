package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class p_1181_단어정렬 {
	
	static int N;
	static HashSet<String> hm = new HashSet<String>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String [] str = new String[N];
		
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if ( o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
			
		});
		
		sb.append(str[0]).append("\n");
		for (int i = 1; i < N; i++) {
			if ( !str[i].equals(str[i-1])) {			
				sb.append(str[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	
}
