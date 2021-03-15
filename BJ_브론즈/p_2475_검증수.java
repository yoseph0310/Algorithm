package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2475_검증수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[5];
		
		int sum = 0;
		int ans = 0;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i]*arr[i];
		}
 		
//		System.out.println(sum);
		
		ans = sum % 10;
		
		System.out.println(ans);
		

	}

}
