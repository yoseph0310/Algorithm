package JO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_2577_회전초밥 {
	
	static int N, d, k, c;
	static int ans = Integer.MIN_VALUE;
	static int dish[];
	static boolean kind[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());				// 접시의수
		d = Integer.parseInt(st.nextToken());				// 초밥의 가짓수
		k = Integer.parseInt(st.nextToken());				// 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken());				// 쿠폰 번호 
		
		dish = new int[N];
		kind = new boolean[d+1];
		
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			Arrays.fill(kind, false);
			
			for (int j = i; j < (i+k); j++) {
				if(!kind[dish[j%N]]) {
					kind[dish[j%N]] = true;
					cnt++;
					if ( dish[j%N] == c) cnt--;
				}
				
				
			}
			if(cnt==k+1) {
				ans = cnt;
				break;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
		
	}
}
