package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p_8320_직사각형을만드는방법 {
	
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <=N ; i++) {
			for (int j = i; i*j <=N; j++) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}

}

// 변 길이가 1인 정사각형 n개