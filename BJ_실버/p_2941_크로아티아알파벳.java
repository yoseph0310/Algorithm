package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_2941_크로아티아알파벳 {
	
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int len = s.length();
		
		for (int i = 0; i < len; i++) {
			
			char c = s.charAt(i);
			
			if ( c == 'c' && i < len-1) {
				if ( s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
					i++;
				}
			}
			
			else if ( c == 'd' && i < len-1) {
				if ( s.charAt(i+1) == '-') {
					i++;
				}
				else if ( s.charAt(i+1) == 'z' && i < len-2) {
					if ( s.charAt(i+2) == '=' ) {
						i+=2;
					}
				}
			}
			
			else if ( (c == 'n' || c == 'l') && i < len-1) {
				if ( s.charAt(i+1) == 'j') {
					i++;
				}
			}
			
			else if ( (c == 's' || c == 'z') && i < len-1) {
				if ( s.charAt(i+1) == '=') {
					i++;
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);

	}

}
// charAt(i) == 'c'