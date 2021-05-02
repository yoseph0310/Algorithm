package BJ_브론즈.p_2846_오르막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_2846_오르막길 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int before = 0;
		st = new StringTokenizer(br.readLine());
		int current = Integer.parseInt(st.nextToken());
		int sum = 0;
		int res = 0;
		
		for (int i = 1; i < N; i++) {
			before = current;
			current = Integer.parseInt(st.nextToken());
			
			if ( current - before > 0) {
				sum+= current - before;
			} else {
				res = Math.max(res, sum);
				sum = 0;
			}
		}
		
		res = Math.max(res, sum);
		
		System.out.println(res);
	} // main

}

