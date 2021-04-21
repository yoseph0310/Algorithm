package BJ_골드.p_2548_키순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_2548_키순서 {

	static int N, M, tCnt, sCnt, ans;
	static int adj[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생들의 수
		M = Integer.parseInt(st.nextToken()); // 학생들 키를 비교한 횟수

		adj = new int[N + 1][M + 1];

		int r, c;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken()); // 작은 학생
			c = Integer.parseInt(st.nextToken()); // 큰 학생

			adj[r][c] = 1; // 행은 그 학생보다 큰 학생, 열은 그 학생보다 작은 학생을 뜻함.
		}
		ans = 0;

		for (int i = 1; i <= N; i++) {
			tCnt = sCnt = 0;

			tBfs(i);
			sBfs(i);

			if (tCnt + sCnt == N - 1)
				ans++;
		}
		System.out.println(ans);

	}// main

	static void tBfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N + 1];

		q.add(num);
		visited[num] = true;

		while (!q.isEmpty()) {
			int c = q.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[c][i] == 1 & !visited[i]) {
					q.add(i);
					visited[i] = true;
					tCnt++;
				}
			}
		}

	}

	static void sBfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N + 1];

		q.add(num);
		visited[num] = true;

		while (!q.isEmpty()) {
			int c = q.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[i][c] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					sCnt++;
				}
			}
		}
	}

}

// 