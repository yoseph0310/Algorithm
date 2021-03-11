package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_8958_OX퀴즈 {
	
	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			String s = br.readLine();
			
			int cnt = 0, total = 0;
			
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				
				if ( ch == 'O') {
					total += ++cnt;
				}
				else {
					cnt = 0;
				}
			}
			
			
			
			System.out.println(total);
			
			
//			System.out.println(s);
		}
	}
}
