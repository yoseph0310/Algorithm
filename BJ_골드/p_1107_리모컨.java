package BJ_골드;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p_1107_리모컨 {

	static boolean btn [] = new boolean[10];
	
	
	static int possible(int n) {
		if ( n == 0 ) {
			if ( btn[0] ) {
				return 0;
			} else {
				return 1;
			}
		}
		
		int len = 0;
		while(n > 0) {
			if ( btn[n % 10]) {
				return 0;
			}
			len += 1;
			n /= 10;
		}
		
		return len;
		
	}
	
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		
//		int N = Integer.parseInt(br.readLine());	// 이동 채널
//		int M = Integer.parseInt(br.readLine());	// 고장난 버튼 갯수
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
//		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
//			int x = Integer.parseInt(st.nextToken());
			int x = sc.nextInt();
			btn[x] = true; 		// true 면 고장
		}
		
		int ans = Math.abs(N - 100); 
		
		for (int i = 0; i < 1000000; i++) {
			int c = i;
			int len = possible(c);
			
			if ( len > 0 ) {
				int press = Math.abs(c-N);
				
				if ( ans > len + press ) {
					ans = len + press;
				}
			}
			
		}
		System.out.println(ans);
	}

}
