package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1012_유기농배추 {
	
	static int T, M,N,K,cnt;
	static int map[][];
	static boolean visit[][];
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 가로
			N = Integer.parseInt(st.nextToken());	// 세로
			K = Integer.parseInt(st.nextToken());	// 배추 갯수
			
			map = new int[M][N];
			visit = new boolean[M][N];
			cnt = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int pr = Integer.parseInt(st.nextToken());
				int pc = Integer.parseInt(st.nextToken());
				map[pr][pc] = 1;
			}
			
//			print(map);
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if ( map[i][j] == 1 && !visit[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}
	static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			visit[cur.r][cur.c] = true;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if ( isBoundary(nr, nc) && !visit[nr][nc] && map[nr][nc] == 1) {
					q.add(new Node(nr, nc));
					visit[nr][nc] = true;					
				}
			}
			
		}
	}
	
	static class Node{
		int r, c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
//	
//	static void print(int[][]map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
}
