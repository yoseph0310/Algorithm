package BJ_골드.p_14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_14500_테트로미노 {
	
	static int N, M; // 세로 가로
	static int map[][];
	static boolean visit[][];
	
	static int max_num = 0;
	static int max = 0;
	
	static int dr [] = {-1,1,0,0};
	static int dc [] = {0,0,-1,1};
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print(map);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ( map[i][j] > max_num ) max_num = map[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i,j, 0, 0);
				another(i,j);
			}
		}
//		dfs(0,0,map[0][0],0);
		System.out.println(max);

	}
	
	static void dfs( int r, int c, int cnt, int size) {
		
		if (size == 4) {
			max = Math.max(max, cnt);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if ( isBoundary(nr,nc) && !visit[nr][nc]) {
				visit[nr][nc] = true;
				dfs(nr,nc, cnt+map[nr][nc], size+1);
				visit[nr][nc] = false;
			}
		}
		
	}
	
	static void another(int r, int c) {
		int wing = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[r][c];
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if ( wing <= 2) return;
			if ( !isBoundary(nr,nc)) {
				wing--;
				continue;
			}
			min = Math.min(min, map[nr][nc]);
			sum += map[nr][nc];
			
		}
		if ( wing == 4) {
			sum -= min;
		}
		max = Math.max(max,sum);
	}
	
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
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

// 정사각형은 서로 겹치면 안된다.
// 도형은 모두 연결되어 있어야 한다.
// 정사각형의 변끼리 연결되어야 한다. 꼭짓점과 꼭짓점만 맞닿아있으면 안된다.

// 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하라.
// 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓는다. 회전, 대칭 가능