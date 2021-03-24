package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2536_치즈 {

	static int R, C, day, size;
	static int map[][];
	static boolean visit[][];
	
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,1,0,-1};
	
	static Queue<Point> meltCheeze = new LinkedList<>();
	static boolean isBoundary(int r, int c) {
		return r > 0 && r <= R && c > 0 && c <= C;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visit = new boolean[R+1][C+1];
			
			outSide(new Point(1,1));
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if ( map[i][j] == 1 && isEdge(i,j)) {
						bfs(i,j);
					}
				}
			}
			
			if ( meltCheeze.isEmpty()) break;
			
			size = meltCheeze.size();
			
			while( !meltCheeze.isEmpty()) {
				Point p = meltCheeze.poll();
				map[p.r][p.c] = -1;
			}
			
			day++;
		}
		
		System.out.println(day);
		System.out.println(size);
		
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			Point cp = q.poll();
			
			if ( isEdge(cp.r, cp.c)) {
				map[cp.r][cp.c] = 2;
				meltCheeze.add(new Point(cp.r, cp.c));
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cp.r + dr[d];
				int nc = cp.c + dc[d];
				
				if ( isBoundary(nr, nc) && map[nr][nc] == 1 && !visit[nr][nc]) {
					q.add(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}
	
	static boolean isEdge(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if ( map[nr][nc] == -1) {
				return true;
			}
		}
		return false;
	}
	
	static void outSide(Point p) {
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		map[1][1] = -1;
		visit[1][1] = true;
		
		while(!q.isEmpty()) {
			Point cp = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cp.r + dr[d];
				int nc = cp.c + dc[d];
				
				
				if ( isBoundary(nr, nc) && !visit[nr][nc] && map[nr][nc] <= 0) {
					map[nr][nc] = -1;
					visit[nr][nc] = true;
					q.add(new Point(nr,nc));
				}
			}
		}
		
	}
	
	static class Point{
		int r; int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

// 모두 녹아 없어지는 데 걸리는 시간
// 녹기 한시간 전의 치즈조각 칸의 개수