package BJ_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p_10026_적록색약_G5 {
	
	static int N;
	static char [][] map;
	static boolean [][] visited;
	static int[]dr = {-1,1,0,0};
	static int[]dc = {0,0,-1,1};
	
	static int cnt_a = 0;
	static int cnt_s = 0;
	
	static Queue<dot> q = new LinkedList<dot>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
//		print(map);
		
		for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfs(new dot(i,j));
                    cnt_a++;
                }
            }
        }
		
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ( map[i][j] == 'R') {
					map[i][j] = 'G';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(new dot(i,j));
					cnt_s++;
				}
			}
		}
		
		
		System.out.println(cnt_a+" "+cnt_s);
	}
	
	static void bfs(dot d) {
		
		char color = map[d.r][d.c];
		visited[d.r][d.c] = true;
		
		q.add(d);
		
		while(!q.isEmpty()) {
			dot t = q.poll();
			int r = t.r;
			int c = t.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if ( nr >=0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == color && !visited[nr][nc]) {
					q.add(new dot(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}

		
	}
}// main

class dot{
	int r;
	int c;
	
	public dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

