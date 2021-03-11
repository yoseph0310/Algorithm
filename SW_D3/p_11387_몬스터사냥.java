package SW_D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_11387_몬스터사냥 {
	
	static int T;
	static double D, L, N, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Long.parseLong(st.nextToken());	// 데미지
			L = Integer.parseInt(st.nextToken());	// 레벨
			N = Integer.parseInt(st.nextToken());	// 횟수
			
			ans = 0;
			for (int i = 0; i < N; i++) {
				
				ans += D * ( 1 + (i*L)/100 );
			}
			
			
			
//			System.out.println(D+" "+L+" "+N);
			System.out.println("#"+t+" "+(int)ans);
		}
	}
}
