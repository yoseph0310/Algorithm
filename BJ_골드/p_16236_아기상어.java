package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_16236_아기상어 {
	
	static int N, sr, sc, size, cnt, time; // 상어 좌표 sr,sc / 상어크기 / 먹은횟수 / 시간
	static int [][] map;
	static ArrayList<Info> fishes; 
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	static class Info{
		int r;
		int c;
		int dist;
		
		public Info(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static boolean isBoundary(int r, int c) {
		return r < 0 || r>=N || c < 0 || c >= N;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		size = 2;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if ( num == 9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				}
			}
		}
		
		while( true ) {
			fishes = new ArrayList<Info>();
			Queue<Info> q = new LinkedList<Info>();
			boolean [][] visit = new boolean[N][N];
			q.offer(new Info(sr, sc, 0));
			visit[sr][sc] = true;
			
			while(!q.isEmpty()) {
				Info shark = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = shark.r + dr[d];
					int nc = shark.c + dc[d];
					
					if ( isBoundary(nr, nc)) continue;
					if ( visit[nr][nc]) continue;
					
					if ( 1 <= map[nr][nc] && map[nr][nc] < size ) {
						q.offer(new Info(nr, nc, shark.dist+1));
						fishes.add(new Info(nr, nc, shark.dist+1));
						visit[nr][nc] = true;
					}
					else if ( map[nr][nc] == size || map[nr][nc] == 0) {
						q.offer(new Info(nr, nc, shark.dist+1));
						visit[nr][nc] = true;
					}
				}
				
			}
			
			if ( fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Info targetFish = fishes.get(0);
			for (int i = 1; i < fishes.size(); i++) {
				if ( fishes.get(i).dist < targetFish.dist) {
					targetFish = fishes.get(i);
				}
				
				if ( targetFish.dist == fishes.get(i).dist) {
					if ( targetFish.r > fishes.get(i).r) {
						targetFish = fishes.get(i);
					}
					
				}
			}
			
			time += targetFish.dist;
			cnt++;
			map[targetFish.r][targetFish.c] = 0;
			
			if ( cnt == size ) {
				size++;
				cnt = 0;
			}
			
			sr = targetFish.r;
			sc = targetFish.c;
			
		}
		
		
	} // main
	

	

}	// class
