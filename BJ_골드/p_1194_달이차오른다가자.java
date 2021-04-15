package BJ_골드.p_1194_달이차오른다가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1194_달이차오른다가자 {
	
	static class Point{
		int r, c, key;
		
		public Point(int r, int c, int key) {
			this.r = r;
			this.c = c;
			this.key = key;
		}
	}
	
	static int N, M, sr, sc;
	static char map[][];
	static Queue<Point> q;
	static boolean visited[][][];
	
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,-1,0,1};
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][101];
		q = new LinkedList<>();
		
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i] = str.toCharArray();
				
				if (map[i][j] == '0') {
					sr = i;
					sc = j;
				}
			}
		}
	
//		print(map);
		q.add(new Point(sr,sc, 0));
		visited[sr][sc][0] = true;
		map[sr][sc] = '.';
		bfs();
		
		
	} // main
	static void bfs() {
		int distance = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				int cr = cur.r, cc = cur.c;
				
				if ( map[cr][cc] == '1') {
					System.out.println(distance);
					return;
				}
				
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					int key = cur.key;
					
					if ( !isBoundary(nr, nc) || map[nr][nc] == '#' || visited[nr][nc][key]) continue;
					
					// 빈 공간 - 다음이 목적지
					if (map[nr][nc] == '1') {
						q.add(new Point(nr, nc, key));
						visited[nr][nc][key] = true;
						continue;
					}
					
					// 빈 공간 - 말그대로 빈공간 빠끄
					if ( map[nr][nc] == '.') {
						q.add(new Point(nr, nc, key));
						visited[nr][nc][key] = true;
					}
					
					// 소문자 ( 열쇠 )
					if(Character.isLowerCase(map[nr][nc])) {
						key |= 1 << map[nr][nc] - 'a';
						q.add(new Point(nr, nc, key));
						visited[nr][nc][key] = true;
					}
					
					// 대문자 ( 문 )
					if(Character.isUpperCase(map[nr][nc])) {
						if ( (key & 1 << map[nr][nc] - 'A') != 0) {
							q.add(new Point(nr, nc, key));
							visited[nr][nc][key] = true;							
						}
					}
				}
				
				
			}
			distance++;
		}
		System.out.println("-1");
	}
	
	
	static void print(char[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
