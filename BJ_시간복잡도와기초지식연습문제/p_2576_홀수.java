package BJ_시간복잡도와기초지식연습문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2576_홀수 {
	
	static int [] arr;
	static int sum, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[7];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 7; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < 7; i++) {
			if ( arr[i] % 2 == 1) {
				sum += arr[i];
				min = Math.min(arr[i], min);
			}
		}
		
		if ( sum == 0 && min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);			
		}
		
	}
	
}
