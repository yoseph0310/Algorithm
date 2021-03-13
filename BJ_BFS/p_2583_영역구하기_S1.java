package BJ_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2583_영역구하기_S1 {
	
	static int M, N, K;
	static int count;
	static int [][] map;
	static boolean [][] visit;
	static int [] sum;
	
	static int ans;
	
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,-1,0,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());	// 세로
		N = Integer.parseInt(st.nextToken());	// 가로
		K = Integer.parseInt(st.nextToken());	// K개의 직사각형
		
		map = new int[N][M];
		visit = new boolean[N][M];
		sum = new int[N*M];
		count = 0;
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					map[i][j] = 1;
				}
			}
		}
		
//		print(map);
//		int c = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ( map[i][j] == 0 && !visit[i][j] ) {
					bfs(i,j, count);
					count++;
//					c++;
				}
			}
			
		}
		
		System.out.println(count);
		Arrays.sort(sum, 0, count);
		for (int i = 0; i < count; i++) {
			System.out.print(sum[i] + " ");
		}
		
		
	}
	static void bfs(int r, int c, int count ) {
		Queue<rect> q = new LinkedList<>();
		
		rect rect1 = new rect(r,c);
		
		q.add(rect1);
		
		while(!q.isEmpty()) {
			rect rect2 = q.poll();
			visit[rect2.r][rect2.c] = true;
			sum[count]++;
			
			for (int i = 0; i < 4; i++) {
				int nr = rect2.r + dr[i];
				int nc = rect2.c + dc[i];
				
				if ( isBoundary(nr, nc) && !visit[nr][nc] && map[nr][nc] == 0) {
					rect rect3 = new rect(nr, nc);
					q.add(rect3);
					visit[rect3.r][rect3.c] = true;
				}
			}
			
		}
		
		
		
	}
	
	static boolean isBoundary(int r, int c ) {
		return ( r < N && c < M && r >= 0 && c >= 0);
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

class rect{
	int r;
	int c;
	
	public rect(int r, int c ) {
		this.r = r;
		this.c = c;
	}
}

// arr[i][2] - arr[i][0] = i번째 사각형의 세로 길이
// arr[i][3] - arr[i][1] = i번째 사각형의 가로 길이
