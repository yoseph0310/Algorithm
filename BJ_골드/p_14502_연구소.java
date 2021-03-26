package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p_14502_연구소 {
	
	static int N, M;
	static int map [][];
	static int cmap [][];
	static int max = 0;
	static List<Point> virusList = new ArrayList<>();

	static int dr [] = {-1,1,0,0};
	static int dc [] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cmap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if ( map[i][j] == 2) virusList.add(new Point(i,j));
			}
		}
		
		// 벽 세우기 
		setWall(0,0);
		
		
		System.out.println(max);
		

	}
	
	
	static void setWall(int start, int wallCnt) {
		
		if ( wallCnt == 3 ) {
			copyMap();
			
			for (Point v : virusList) {				
				spreadVirus(v.r, v.c);
			}
			
			max = Math.max(max, getSafeArea());
			return;
		}
		
		for (int i = start; i < N*M; i++) {
			int r = i/M;
			int c = i%M;
			
			if ( map[r][c] == 0) {
				map[r][c] = 1;
				setWall(start+1, wallCnt + 1);
				map[r][c] = 0;
			}
		}
		
		
	}
	
	static int getSafeArea(){
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ( cmap[i][j] == 0) safe++;
			}
		}
		return safe;
	}
	static void spreadVirus(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if ( isBoundary(nr,nc) && cmap[nr][nc] == 0) {
				cmap[nr][nc] = 2;
				spreadVirus(nr,nc);
			}
		}
	}
	static boolean isBoundary(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cmap[i][j] = map[i][j];
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
		System.out.println("--------------");
	}

}

// map 에서 벽을 조합적으로 세워본다.
// 바이러스를 퍼트린다.
// 안전영역을 cnt하고 그중 최대값을 찾는다.

// map 초기화 부분 -> 클론 map을 하나 만들던가 초기화 방법을 고안