package 모의SW_A형_역량테스트대비.p_1249;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1249_보급로 {
	
	static int T, N, min;
	static int map[][];
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	
	static int ans[][];
	static boolean visited[][];
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String [] str = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
//			print(map);
			min = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;
			bfs(0,0);
			System.out.println("#"+t+" "+min);
		}
	
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			if ( cr == N-1 && cc == N-1 )
				min = min > ans[N-1][N-1] ? ans[N-1][N-1] : min;
			
			if ( min <= ans[cr][cc]) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if ( isBoundary(nr, nc) ) {
					if (!visited[nr][nc] || ans[nr][nc] > ans[cr][cc] + map[nr][nc]) {
						q.add(new Point(nr, nc));
						ans[nr][nc] = ans[cr][cc] + map[nr][nc];
						visited[nr][nc] = true;
					}
				}
		
			}

		}
		
	}
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void print(int[][]map){
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
