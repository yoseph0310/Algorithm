package 모의SW_A형_역량테스트대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_17070_파이프옮기기 {
	
	static int N, ans;
	static int [][] map;
	static int [] dr = {0, 1, 1}; // 우 우하 하 
	static int [] dc = {1, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print(map);

		solve(0,1,0);
		System.out.println(ans);
		
	}
	
	static void solve(int r, int c, int d) {
		
		if ( r == N-1 && c == N-1 ) {
			ans++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if( (i == 0 && d == 2 ) || (i == 2 && d == 0)) {
				continue;
			}
			
			if ( nr > N-1 || nc > N-1 || map[nr][nc] == 1 ) {
				continue;
			}
			
			if ( i == 1 && ( map[r][c+1] == 1 || map[r+1][c] == 1)) {
				continue;
			}
			
			solve(nr, nc, i);
		}
	}

	static void print(int [][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
