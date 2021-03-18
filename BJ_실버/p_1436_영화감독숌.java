package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int cnt = 1;
		
		while( cnt != N) {
			num++;
			
			if ( String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
	}

}
