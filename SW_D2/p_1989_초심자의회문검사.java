package SW_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_1989_초심자의회문검사 {

	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			String s = br.readLine().trim();
			
			sb = new StringBuilder(s);
			sb = sb.reverse();
			System.out.print("#"+t+" ");
			if ( s.equals(sb.toString())) {
				System.out.println(1);
				continue;
			}
			
			
			System.out.println(0);
			
//			System.out.println("#"+t+" "+ans);
		}
	}

}
