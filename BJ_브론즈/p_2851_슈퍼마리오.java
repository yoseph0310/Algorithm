package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_2851_슈퍼마리오 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] arr = new int[10];
		int result = 0;
		
		int now = 0;
		int after = 0;
		
		for (int i = 0; i < 10; i++) {	
			arr[i] = Integer.parseInt(br.readLine());
		}

		result = arr[0];
		for (int i = 1; i < 10; i++) {
			now = result;
			after = result + arr[i];
			
			now = Math.abs(100-now);
			after = Math.abs(100-after);
			
			if ( after <= now ) {
				result += arr[i];
			}else {
				break;
			}
			
		}
		System.out.println(result);
		
	}
	
	
}

// sumArr 하나를 만든다 
// 10+20 10+20+30 .... 10+...+100
// 