package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_11399_ATM {
	
	static int N;
	static int [] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		print(arr);
		Arrays.sort(arr);
//		print(arr);
		
		int total = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			total += sum;
		}
		System.out.println(total);
		
		
	}
	public static void print(int[]arr) {
		for (int i = 0; i < N; i++) {			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
