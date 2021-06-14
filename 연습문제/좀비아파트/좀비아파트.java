package 연습문제.좀비아파트;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 좀비아파트{
	
	static class Point{
		int h, r, c, d;
		
		public Point(int h, int r, int c, int d) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int M, N, H, ans;
	static int[][][] zombie; 
	static boolean flag; 
	static int[] dh = {-1, 1, 0, 0, 0, 0};
	static int[] dr = {0, 0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("좀비아파트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); 
			N = Integer.parseInt(st.nextToken()); 
			H = Integer.parseInt(st.nextToken()); 
			
			zombie = new int[H][N][M];
			flag = false;
			ans = 0;
			
			Queue<Point> queue = new LinkedList<>(); 
			
			for(int h = 0; h < H; h++) {
				for(int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < M; j++) {
						zombie[h][i][j] = Integer.parseInt(st.nextToken());
						if(zombie[h][i][j] == -1) flag = true;
						else if(zombie[h][i][j] == 1) {
							queue.offer(new Point(h, i, j, 0)); // z, y, x, day 계산
						}
					}
				}
			}
			
			if(!flag) {
				sb.append("ALL HUMANS").append("\n");
				continue;
			}
			
			while(!queue.isEmpty()) {
				Point cur = queue.poll();
				int ch = cur.h;
				int cr = cur.r;
				int cc = cur.c;
				zombie[ch][cr][cc] = 0;
				
				for(int k = 0; k < 6; k++) {
					int nh = ch + dh[k];
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					
					if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M || zombie[nh][nr][nc] == 0) continue;
					
					zombie[nh][nr][nc] = 0;
					queue.offer(new Point(nh, nr, nc, cur.d + 1));
				}
				ans = cur.d;
			}
			
			for(int h = 0; h < H; h++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0;j < M; j++) {
						if(zombie[h][i][j] == -1) flag = false;
					}
				}
			}
			
			if(!flag) sb.append("STILL ZOMBIES").append("\n");
			else sb.append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}