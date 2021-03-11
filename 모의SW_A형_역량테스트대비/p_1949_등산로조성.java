package 모의SW_A형_역량테스트대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1949_등산로조성 {
	
	static int T, N, K;
	static int max;
	static int max_height;
	static int [] dr= {0,1,0,-1};
	static int [] dc= {1,0,-1,0};
	
	static int [][] map;
	static boolean [][] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("p_1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			max = max_height = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max_height = Math.max(max_height, map[i][j]);
				}
			}
			
			// 입력 확인
//			print(map);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ( map[i][j] == max_height) {
						dfs(i, j, 1, false);
					}
				}	
			}
			
			
			
			System.out.println("#"+t+" "+max);
		}

	}
	
	static void dfs(int r, int c, int length, boolean used) {
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if ( isBoundary(nr, nc) && !visited[nr][nc] ) {
				if ( map[nr][nc] < map[r][c]) {
					dfs(nr, nc, length + 1, used);
				} else {
					if (!used) {
						for (int j = 1; j <= K; j++) {
							if ( map[nr][nc] - j < map[r][c]) {
								map[nr][nc] -= j;
								dfs(nr, nc, length + 1, true);
								map[nr][nc] += j;
							}
						}
					}
				}
			}
		}

		visited[r][c] = false;
		max = Math.max(max, length);
	}
	
	static boolean isBoundary(int r, int c ) {
		return ( r >= 0 && c >= 0 && r < N && c < N);
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
// DFS

// 가장 높은 봉우리 높이 h를 찾는다
// 높이가 h인 모든 칸에서 시작해본다
// 현재 칸에 인접한 낮은 칸으로 이동
// 낮지 않은 칸은, 높이 차이가 K보다 작고 깎는 횟수가 남아있으면 이동한다.
	// 이미 등산로에 포함된 칸을 깎지 않도록 한다.
	// 깎은 칸 방향 탐색 후 다른 방향을 탐색할 때 원래높이 복원
// 각 칸에 들어갈 때 마다, 가장 긴 등산로와 비교해 최대 길이를 갱신