package 모의SW_A형_역량테스트대비.p_1249;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 다익스트라
// 밀집 그래프일 때보다 희소그래프일 때 pq를 사용하는 것이 더빠르다.
public class p_1249_보급로_Djik_PQ {

	static int N, INF = Integer.MAX_VALUE;
	static int map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1249.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char ch[] = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}

			System.out.println("#" + t + " " + dijkstra(0, 0));
		}
	}

	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}

		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		}); // 정점 r,c, 출발지부터 복구시간[2]

		minTime[startR][startC] = 0;
		queue.offer(new int[] { startR, startC, minTime[startR][startC] });

		int r = 0, c = 0, cost = 0, nr, nc;
		int[] current;
		
		while (true) {
			// 방문하지 않은 정점 중 출발지에서 자신으로오는 비용이 최소인 정점 선택
			current = queue.poll();
			
			r = current[0];
			c = current[1];
			cost = current[2];

			visited[r][c] = true;
			if (r == N - 1 && c == N - 1)
				return cost;

			// 선택된 정점기준으로 방문하지 않은 나머지 정점들 자신과의 경유시의 비용과
			// 최소 비용 비교하여 최소값 업데이트

			// 현재 정점 위치 기준으로 4방의 인접정점을 처리
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
						&& minTime[nr][nc] > cost + map[nr][nc]) {
					minTime[nr][nc] = cost + map[nr][nc];
					queue.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}

		}
	}

}