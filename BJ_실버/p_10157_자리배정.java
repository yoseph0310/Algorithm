package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10157_자리배정 {
	
	static int R, C, K;
	static int [][]map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());	// 가로 column
		R = Integer.parseInt(st.nextToken());	// 세로 row
		
		K = Integer.parseInt(br.readLine()); 	// 대기번호 K
		
		map = new int[R][C];					// 6 * 7의 map
		if ( R*C < K) {
			System.out.println(0);
			return;
		}
		
		int cnt = 1;							// cnt는 1번 부터
		// 시작점
		int r = R-1;							// 실제 배열안에서는 5,0 부터이니 R-1
		int c = 0;								// c은 0부터
		int dir = 0;							// 방향 0 부터
		
		while ( cnt != K) {
			
			map[r][c] = cnt;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if ( nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != 0) {
				dir++;
				if ( dir == 4 ) dir = 0;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			r = nr;
			c = nc;
			
			cnt++;
			
//			if ( nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == 0) {
//				r = nr;
//				c = nc;
//				cnt++;
//			}
//			
//			else {
//				dir++;
//				if ( dir == 4) dir = 0;
//				nr = r+dr[dir];
//				nc = c+dc[dir];
//			}
		}
		
		
		
//		print(map);
//		
//		
//		System.out.println(cnt);
		
		System.out.println((c+1)+" "+(R-r));
		
	}
//	
//	public static void print(int[][]map) {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}
