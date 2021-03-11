package BJ_시간복잡도와기초지식연습문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_2587_대표값2 {
	
	static int [] arr;
	static int avg, mid; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[5];
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		avg = sum / 5;
		
		Arrays.sort(arr);
		
		System.out.println(avg);
		System.out.println(arr[2]);
		
		
	}

}
