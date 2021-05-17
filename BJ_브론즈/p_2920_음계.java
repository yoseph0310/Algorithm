package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2920_음계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[8];
		
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		int diff_m = 0;
		int diff_p = 0;
		
		for (int i = 0; i < 7; i++) {
			if (arr[i] - arr[i+1] == -1) {
				diff_m--;
			} else if ( arr[i] - arr[i+1] == 1) {
				diff_p++;
			}
		}
		
		if (diff_m == -7) {
			System.out.println("ascending");
		} else if ( diff_p == 7) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}

}
