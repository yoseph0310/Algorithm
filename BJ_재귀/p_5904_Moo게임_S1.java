package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p_5904_Moo게임_S1 {
	
	static int[]dp = new int[30];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 3; // 사이즈
		for (int i = 1; i < dp.length; i++) {
			dp[i] = (dp[i-1])*2 + (i+3); 
		}
		
		System.out.println(moo(N));
	}

	static char moo(int n) {
		if ( n == 1 ) return 'm';
		if ( n == 2 || n == 3 ) return 'o';
		
		int i = 0;
		while(dp[i] < n) i++;
		if ( dp[i] == n ) return 'o';
		if ( n - dp[i-1] == 1) return 'm';
		if ( n - dp[i-1] <= i+3 ) return 'o';
		
		return moo( (n-dp[i-1] - (i+3)));
		
	}
}
