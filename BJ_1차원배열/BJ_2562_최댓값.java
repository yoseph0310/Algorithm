package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2562_최댓값 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] arr = new int[9];
		int res = 0;
		
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			res = Math.max(arr[i], res);
			
		}
		
		System.out.println(res);
		for (int i = 0; i < arr.length; i++) {
			if ( res == arr[i]) System.out.println(i+1);
		}
	}

}
