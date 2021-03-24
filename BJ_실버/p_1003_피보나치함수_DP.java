package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_1003_피보나치함수_DP {
	
	static int T, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			int zero = 1;
			int one = 0;
			int zero_plus_one = 1;
			
			for (int i = 0; i < N; i++) {
				zero = one;
				one = zero_plus_one;
				zero_plus_one = zero+one;
			}
			
			System.out.println(zero+" "+one);
		}
	}

}
