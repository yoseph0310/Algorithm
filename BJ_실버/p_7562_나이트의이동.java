package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_7562_나이트의이동 {
	
	static int T, ans, N, sr, sc, er, ec;
	static int [][] map;
	static boolean [][] visit;
	
	static int [] dr = {-1,-2,-2,-1,1,2,2,1};
	static int [] dc = {-2,-1,1,2,2,1,-1,-2};

	static boolean isBoundary(int r, int c ) {
		return r >= 0 && r < N && c >= 0 && c < N; 
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine()); // 체스판 한변의 길이
			
			map = new int[N][N];
			visit = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			
			bfs(new Position(sr, sc));
			System.out.println(map[er][ec]);
		}
		
	}
	
	static void bfs(Position p) {
		Queue<Position> q = new LinkedList<>();
		
		visit[p.r][p.c] = true;
		
		q.add(p);
		
		while(!q.isEmpty()) {
			Position next = q.poll();
			
			if ( next.r == er && next.c == ec) {
				break;
			}
			
			for (int d = 0; d < 8; d++) {
				int nr = next.r + dr[d];
				int nc = next.c + dc[d];
				
				if ( isBoundary(nr, nc) && !visit[nr][nc]) {
					q.add(new Position(nr,nc));
					visit[nr][nc] = true;
					
					map[nr][nc] = map[next.r][next.c] + 1;
				}
			}
		}
		
	}
	
	static class Position{
		int r, c;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
