package SW_D1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2072홀수만더하기 {
	
	static int T;
	static int[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		arr = new int[10];
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				if(arr[i] % 2 == 1) {
					sum += arr[i];
				}
			}
			
			System.out.println("#"+ t + " " + sum);
		}
	}

}
