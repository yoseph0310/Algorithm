package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1600_말이되고픈원숭이 {
	
	static int min = Integer.MAX_VALUE;
	static int K, W, H, cnt;
	static int map[][];
	
	static boolean visited[][][];
	
	static int hr [] = { -1,-2,-2,-1,1,2,2,1 };
	static int hc [] = { -2,-1,1,2,2,1,-1,-2};
	
	static int mr [] = {-1,1,0,0};
	static int mc [] = {0,0,-1,1};
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][31];
		
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		bfs(0,0);

	}
	 
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c, 0, K));
		visited[r][c][0] = true;
		
		while(!q.isEmpty()) {
			Point cp = q.poll();
			
			if ( cp.r == H-1 && cp.c == W-1) {
				System.out.println(cp.cnt);
				return;
			}
			
			if ( isBoundary(cp.r, cp.c) && map[cp.r][cp.c] != 1 && !visited[cp.r][cp.c][cp.k] ) {
				visited[cp.r][cp.c][cp.k] = true;
				
				for (int d = 0; d < 4; d++) {
					int nr = cp.r + mr[d];
					int nc = cp.c + mc[d];
					
					q.add(new Point(nr, nc, cp.cnt+1, cp.k));
				}
				
				if (cp.k == 0) continue;
				for (int d = 0; d < 8; d++) {
					int nr = cp.r + hr[d];
					int nc = cp.c + hc[d];
					
					q.add(new Point(nr, nc, cp.cnt+1, cp.k-1));
				}
			}
		}
		
		System.out.println("-1");
		return;
	}
	
	static class Point{
		int r; int c; int cnt; int k;
		
		public Point(int r, int c, int cnt, int k) {	// 가는 횟수 , 말로 뛰는 것
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
}
