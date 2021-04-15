package 모의SW_A형_역량테스트대비.p_1953_탈주범검거;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1953_탈주범검거 {
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int T, ans;
	static int N, M, SR, SC, L;
	static int map [][];
	static Queue<Point> q;
	static boolean visited[][];
	
	static int dir [][] = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			SR = Integer.parseInt(st.nextToken());
			SC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			q = new LinkedList<>();
			map = new int[N][M];
			visited = new boolean[N][M];
			ans = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			print(map);
			bfs();
			
			System.out.println("#"+t+" "+ans);
		}
		
	} // main
	static void bfs() {
		int time = 0;
		
		q.offer(new Point(SR, SC));
		visited[SR][SC] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			if ( ++time >= L) return;
			
			for (int i = 0; i < size; i++) {
				
				Point cur = q.poll();
				int cr = cur.r;
				int cc = cur.c;
				int type = map[cr][cc];
				
				for (int d = 0; d < 4; d++) {
					int nr = cr + dir[d][0];
					int nc = cc + dir[d][1];
					
					if ( nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if ( visited[nr][nc] || map[nr][nc]==0) continue;
					
					int next = map[nr][nc];
					
					switch(d) {
					case 0:
						if ( type == 1 || type == 2 || type == 4 || type == 7) {
							if( next == 1 || next == 2 || next == 5 || next == 6) {
								visited[nr][nc] = true;
								q.offer(new Point(nr, nc));
								ans++;
							}
						}
						break;
					case 1:
						if ( type == 1 || type == 2 || type == 5 || type == 6) {
							if ( next == 1 || next == 2 || next == 4 || next == 7) {
								visited[nr][nc] = true;
								q.offer(new Point(nr, nc));
								ans++;
							}
						}
						break;
					case 2:
						if ( type == 1 || type == 3 || type == 6 || type == 7) {
							if ( next == 1 || next == 3 || next == 4 || next == 5) {
								visited[nr][nc] = true;
								q.offer(new Point(nr, nc));
								ans++;
							}
						}
						break;
					case 3:
						if ( type == 1 || type == 3 || type == 4 || type == 5) {
							if ( next == 1 || next == 3 || next == 6 || next == 7) {
								visited[nr][nc] = true;
								q.offer(new Point(nr, nc));
								ans++;
							}
						}
						break;
					}
				}
			}
					
		}
		
		
		
		
	}
	
	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

// BFS