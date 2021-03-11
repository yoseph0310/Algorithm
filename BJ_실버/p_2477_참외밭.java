package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2477_참외밭 {
	
	static int K; // 참외의 개수 ( 1~20 ) 
	static int [][] arr;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		arr = new int[6][2];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int maxGaro = Integer.MIN_VALUE;
		int minGaro = Integer.MAX_VALUE;
		int maxSero = Integer.MIN_VALUE;
		int minSero = Integer.MAX_VALUE;
		
		for (int i = 0; i < 6; i++) {
			
			// 최대 최소 가로 구하기
			if ( arr[i][0] == 1 || arr[i][0] == 2) {
				maxGaro = Math.max(arr[i][1], maxGaro);
				minGaro = Math.min(arr[i][1], minGaro);
			}
			// 최대 최소 세로 구하기
			else if ( arr[i][0] == 3 || arr[i][0] == 4 ) {
				maxSero = Math.max(arr[i][1], maxSero);
				minSero = Math.min(arr[i][1], minSero);
			}
		
		}
		
		int maxR = maxGaro * maxSero; 
		int minR = minGaro * minSero;
		
		ans = (maxR-minR) * K;
		System.out.println(ans);
		
		
	}

}