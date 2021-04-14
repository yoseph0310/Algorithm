package BJ_실버.p_7576_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_7576_토마토 {

	static int N,M;
	static int map[][];
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};

	static class Point{
		int r, c, day;
		
		public Point(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 &&  c >= 0 && r < N && c < M;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		bfs();
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();	
		int day = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.offer(new Point(i,j,0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int cr = curr.r;
			int cc = curr.c;
			day = curr.day;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if ( isBoundary(nr,nc) && map[nr][nc] == 0 ) {
					q.offer(new Point(nr,nc, day+1));
					map[nr][nc] = 1;
				}
						
			}
		}
		
		if (check()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}

	}
	
	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
}
