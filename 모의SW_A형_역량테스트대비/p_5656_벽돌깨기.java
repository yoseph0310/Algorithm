package 모의SW_A형_역량테스트대비.p_5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_5656_벽돌깨기 {
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Point> q;
	static int T,C,M,N, ans, brickCnt;
	static int map[][];
	static int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean visited[][];
	static int marble[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());		// 구슬을 쏠 수 있는 횟수
			M = Integer.parseInt(st.nextToken());		// 가로
			N = Integer.parseInt(st.nextToken());		// 세로
			ans = Integer.MAX_VALUE;
			brickCnt = 0;
			
			q = new LinkedList<>();
			visited = new boolean[N][M];
			map = new int[N][M];
			marble = new int[C];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if ( map[i][j] != 0 ) brickCnt++;
				}
			}
//			print(map);
			
			// 열 하나를 골라서 쏘는데 쏘는 순서에 따라 결과가 달라지므로 순열을 사용
			perm(0);
			
			
			System.out.println("#"+t+" "+ans);
		}
		
	} // main 
	static void perm(int cnt) {
		
		if ( cnt == C ) {
			int total = brickCnt;
			int [][] cMap = copy();		// 맵 변화에 따라 영향을 끼치므로 copymap 사용
			
			for (int i = 0; i < C; i++) {
				init();								// 초기 시작 (방문 여부 초기화)
				total -= shot(marble[i], cMap);		// 순열로 고른 열을 cMap 위에서 쏜다. 그리고 그값을 total에서 뺀다.
				fall(cMap);							// cMap에서 빈 공간 (0)이 있으면 벽돌들을 떨어트린다.
			}
			ans = ans > total ? total : ans;
			
			return;
		}
		
		for (int i = 0; i < M; i++) {
			marble[cnt] = i;
			perm(cnt+1);
		}
	}
	
	static int shot(int c, int [][] map) {
		int cnt = 0;
		
		// 처음 부딪히는 곳
		for (int r = 0; r < N; r++) {
			if ( map[r][c] != 0 ) {
				q.offer(new Point(r, c));
				visited[r][c] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cr = cur.r, cc = cur.c;
			int len = map[cr][cc] - 1;		// 깨지는 사거리는 (벽돌에 적힌 숫자 - 1) 칸
			
			map[cr][cc] = 0;
			cnt++;
			
			if (len==0) continue;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr;
				int nc = cc;
				
				for (int i = 0; i < len; i++) {
					nr += dir[d][0];
					nc += dir[d][1];
					
					if ( nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
					if ( map[nr][nc] == 0) continue;
					
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc));
				}
			}
		}
		
		return cnt;
	}
	
	static void fall(int[][]map) {
		for (int c = 0; c < M; c++) {
			for (int r = N-1; r >= 0; r--) {
				if ( map[r][c] == 0 ) {
					int nr = r;
					
					while ( nr > 0 && map[nr][c] == 0) {
						nr--;
					}
					
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
			}
		}
	}
	
	static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static int[][] copy() {
		int [][] temp = new int[N][M];
		
		for (int i = 0; i < N ; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		return temp;
	}
	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

// 좌우로 움직여서 맨위 벽돌만 깬다.
// 벽돌은 숫자 1~9로 표현, 구슬이 명중한 벽돌은 상하좌우로 (벽돌에 적힌 숫자 -1)만큼 0이된다.
// 범위 내에 있는 벽돌은 동시에 제거된다.

// 빈 공간이 있다면 벽돌들은 밑으로 떨어진다.
// 남은 벽돌 수 구하라.

// 1. 구슬을 쏜다.
// 
