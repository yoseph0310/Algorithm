package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_2810_컵홀더 {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 좌석 수 = 사람수
		int cnt = 1;						// 컵홀더 수
		
		String s = br.readLine();
		
		for (int i = 0; i < N; i++) {
			if( s.charAt(i) == 'S') cnt++;
			else if ( s.charAt(i) == 'L') {
				cnt++;
				i++;
			}
		}
		
		if ( N > cnt ) {
			System.out.println(cnt);
		}
		else {
			System.out.println(N);
		}
	}

}

