package BJ_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675 {
	
	static int T, R; // 테케 , 문자 반복 횟수
	static String s;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			s = st.nextToken();
			
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < R; j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append('\n');
			
			
		}
		System.out.println(sb);
	}

}
