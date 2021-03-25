package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_9205_맥주마시면서걸어가기 {
	
	static final int INF = 9999999;
	static int T, N;
	static int map [][];
	static ArrayList<Point> List;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine()); 		// 맥주파는 편의점 개수
			
			List = new ArrayList<>();
			map = new int[N+2][N+2];
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					map[i][j] = INF;
				}
			}
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				List.add(new Point(r, c));
			}
//			print(map);
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if (i==j) continue;
					
					Point cur = List.get(i);
					Point next = List.get(j);
					
					int dist = Math.abs(cur.r-next.r) + Math.abs(cur.c-next.c);	// 두 좌표 사이 거리 : x좌표 차이 + y좌표 차이 (맨해튼 거리)
					if ( dist <= 1000) map[i][j] = 1;	// 20*50 = 1000 
				}
			}
//			print(map);
			f_w();
			if ( 0 < map[0][N+1] && map[0][N+1] < INF) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static void f_w() {
		for (int k = 0; k < N+2; k++) {	// 경(편의점)
			for (int i = 0; i < N+2; i++) {	// 출(집)
				if ( i==k ) continue;
				for (int j = 0; j < N+2; j++) {	// 도(페스티벌)
					if(i==j || k==j ) continue;
					if ( map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void print(int [][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
	}
}

// 한박스에 맥주 20개 , 50미터에 한병씩
// 두 좌표 사이 거리 : x좌표 차이 + y좌표 차이 (맨해튼 거리)
// 경(편의점) 출(집) 도(페스티벌)
