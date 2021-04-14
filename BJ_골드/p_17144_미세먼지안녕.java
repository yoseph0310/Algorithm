package BJ_골드.p_17144_미세먼지안녕;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_17144_미세먼지안녕 {
	
	static int R, C, T;
	static int cleaner = -1;
	static Queue<Point> q;
	static int map [][];
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	
	static class Point{
		int r, c, w;
		
		public Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());	// 행
		C = Integer.parseInt(st.nextToken());	// 열
		T = Integer.parseInt(st.nextToken());	// 초
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if ( cleaner == -1 && map[i][j] == -1) {
					cleaner = i;
				}
				
			}
		}
//		print(map);
		
		for (int t = 0; t < T; t++) {
			check();
			spread();
			operate();
		}
		
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1) continue;
				ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}
	
	private static void check() {
		
		q = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if ( map[i][j] == -1 || map[i][j] == 0) continue;
				q.add(new Point(i,j, map[i][j]));
			}
		}
		
	}
	
	private static void spread() {
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			// 확산될 먼지가 없으면
			if(now.w < 5) continue;
			// 확산되는 양은 Ar,c/5
			int amountOfSpread = now.w / 5;
			int cnt = 0;
			// 인접한 방향으로 확산
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				// 범위를 벗어나면
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				// 공기청정기가 있으면
				if(map[nr][nc] == -1) continue;
				
				map[nr][nc] += amountOfSpread;
				++cnt;
			}
			
			// 남은 미세먼지 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
			map[now.r][now.c] -= amountOfSpread * cnt;
		}
		
		
	}
	private static void operate() {
		
		int top = cleaner;
		int bottom = cleaner + 1;
		
		// 위쪽은 반시계
		// 위 -> 아래
		for (int i = top-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 오 -> 왼
		for (int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		// 아래 -> 위
		for (int i = 0; i < top; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 왼 -> 오
		for (int i = C-1; i > 1; i--) {
			map[top][i] = map[top][i-1];
		}
		map[top][1] = 0;
		// 아래쪽은 시계
		// 아래 -> 위
		for (int i = bottom+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];	
		}
		// 오 -> 왼
		for (int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		// 위 -> 아래
		for (int i = R-1; i > bottom; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		// 왼 -> 오
		for (int i = C-1; i > 1; i--) {
			map[bottom][i] = map[bottom][i-1];
		}
		map[bottom][1] = 0;
	}






	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
// 1. 미세먼지 확산
	// 4방향 확산
	// 공기청정기 있거나, 칸이 없으면 확산 안일어남
	// 확산되는 양 A(r,c) / 5 소수점 버림
	// r,c에 남은 양은 A(r,c) - A(r,c)/5 * 확산된 방향의 개수

// 2. 공청 작동
	// 위쪽으론 반시계, 아래쪽으론 시계방향 순환
	// 바람이 불면 바람의 방향대로 한칸씩 이동
	// 공청에서 부는 바람은 미세먼지 없는 바람이고, 공청으로 들어간 미세먼지는 정화된다.