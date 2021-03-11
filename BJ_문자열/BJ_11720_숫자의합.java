package BJ_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11720_숫자의합 {
	
	static int N, sum;
	static int[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		String a = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = a.charAt(i)-'0';
			sum += arr[i];
		}
		
		System.out.println(sum);
	}

}
