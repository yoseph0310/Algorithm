package BJ_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1012_배추 {
	
	static int T, M, N, K;
	static int [][] map; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());		// 가로길이
			N = Integer.parseInt(st.nextToken());		// 세로길이
			K = Integer.parseInt(st.nextToken());		// 배추가 심겨진 위치의 개수
			
			map = new int[M][N];
			
			for (int i = 0; i < K; i++) {
				
			}
			
		}
				

	}

}
