package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8958 {

	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		int cnt, total;
		
		for(String OX : arr) {
			cnt = 0;
			total = 0;
			for (int i = 0; i < OX.length(); i++) {
				if ( OX.charAt(i) == 'O' ) {
					total += ++cnt;
				}
				else
					cnt = 0;
			}
			System.out.println(total);
		}

	}

}
