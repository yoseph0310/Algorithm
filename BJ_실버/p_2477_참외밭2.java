package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2477_참외밭2 {

	static int [][] arr = new int[6][2];
	static int maxGaro, maxSero, minGaro, minSero, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());	// 방향
			arr[i][1] = Integer.parseInt(st.nextToken());	// 가로든 세로든 길이
		}
		
		maxGaro = 0;
		maxSero = 0;
		
		for (int i = 0; i < 6; i++) {
			if ( i % 2 == 0) {
				maxSero = Math.max(maxSero, arr[i][1]);
			}
			else {
				maxGaro = Math.max(maxGaro, arr[i][1]);
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if ( i % 2 == 0) {
				if ( maxGaro == arr[(i+5)%6][1] + arr[(i+1)%6][1]) {
					minSero = arr[i][1];
				}
			}
			else {
				if ( maxSero == arr[(i+5)%6][1] + arr[(i+1)%6][1]) {
					minGaro = arr[i][1];
				}
			}
		}
		
		System.out.println((maxGaro * maxSero - minGaro * minSero) * K );
	}

}