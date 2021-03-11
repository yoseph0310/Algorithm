package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1592_영식이와친구들 {
	
	static int N,M,L,cnt;
	static int [] person;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		person = new int[N];
		int cnt = 0;
		int idx = 0;
		
		while(true) {
			person[idx]++;
			if ( person[idx] == M)
				break;
			
			if ( person[idx]%2 == 0) {
				if ( idx + L >= N ) {
					idx = L-N+idx;
				}else {
					idx+=L;
				}
			}else if(person[idx]%2 == 1) {
				if ( idx - L < 0) {
					idx = idx-L+N;
				}else {
					idx-=L;
				}
				
				
			}
			cnt++;
		}
		
		
		
		System.out.println(cnt);
		
	}

}
