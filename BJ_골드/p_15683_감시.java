package BJ_골드.p_15683_감시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_15683_감시 {
	
	static int N, M, min = 0;
	static List<int[]> list = new ArrayList<>();
	static int dr[] = {-1,0,1,0}, dc[] = {0,1,0,-1};
	static int[][] stat = {
			{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1},	// 1
			{1,0,1,0},{0,1,0,1},						// 2
			{1,1,0,0},{0,1,1,0},{0,0,1,1},{1,0,0,1},	// 3
			{1,1,1,0},{0,1,1,1},{1,0,1,1},{1,1,0,1},	// 4
			{1,1,1,1}									// 5
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) min++;
				if ( 0 < map[i][j] && map[i][j] < 6) list.add(new int[] {i,j});
 			}
		}
		
		bfs(map, min);
		System.out.println(min);
		

	}
	
	static void bfs(int[][]map, int n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n,map));
		
		for (int i = 0; i < list.size(); i++) {
			int len = q.size();
			
			for (int t = 0; t < len; t++) {
				Node m = q.poll();
				int num = m.num;
				int r = list.get(i)[0];
				int c = list.get(i)[1];
				
				if(map[r][c] == 1) {
					q.add(cctv(m.map, r, c, num, stat[0]));
					q.add(cctv(m.map, r, c, num, stat[1]));
					q.add(cctv(m.map, r, c, num, stat[2]));
					q.add(cctv(m.map, r, c, num, stat[3]));
				}
				if(map[r][c] == 2) {
					q.add(cctv(m.map, r, c, num, stat[4]));
					q.add(cctv(m.map, r, c, num, stat[5]));
				}
				if(map[r][c] == 3) {
					q.add(cctv(m.map, r, c, num, stat[6]));
					q.add(cctv(m.map, r, c, num, stat[7]));
					q.add(cctv(m.map, r, c, num, stat[8]));
					q.add(cctv(m.map, r, c, num, stat[9]));
				}
				if(map[r][c] == 4) {
					q.add(cctv(m.map, r, c, num, stat[10]));
					q.add(cctv(m.map, r, c, num, stat[11]));
					q.add(cctv(m.map, r, c, num, stat[12]));
					q.add(cctv(m.map, r, c, num, stat[13]));
				}
				if(map[r][c] == 5) {
					q.add(cctv(m.map, r, c, num, stat[14]));
				}
			}
		}
	}
	
	static Node cctv(int[][]map, int r, int c, int num, int[] status) {
		int[][] result = copy(map);
		
		for (int i = 0; i < 4; i++) {
			if ( status[i] == 0) continue;
			int nr = r, nc = c;
			while(true) {
				nr = nr + dr[i];
				nc = nc + dc[i];
				
				if (!isBoundary(nr,nc)) break;
				if (result[nr][nc] == 6) break;
				
				if ( result[nr][nc] == 0 ) {
					result[nr][nc] = 8;	// 감시구역
					num--;
				}
				
			}
		}
		if ( min > num ) min = num;
		return new Node(num, result);
	}
	
	static int[][] copy(int[][]map){
		int [][] result = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, result[i], 0, M);
		}
		return result;
	}
	
	static boolean isBoundary(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M; 
	}
	
	static class Node{
		int num;
		int [][] map;
		
		public Node(int num, int [][] map) {
			this.num = num;
			this.map = map;
		}
	}
}
// 