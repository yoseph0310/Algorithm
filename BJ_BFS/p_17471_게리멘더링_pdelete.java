package BJ_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_17471_게리멘더링_pdelete {
	
	static int N;
	static int [] people, visit;
	static int [][] sector;
	static int min = Integer.MAX_VALUE;
	static int total = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		visit = new int[N];
		sector = new int[N][N];
		
		// 인구 수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total += people[i];
		}
		
		// 각 구역 연결 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				int L = Integer.parseInt(st.nextToken())-1;
				sector[i][L] = 1;		// i번째의 구역은 L이 받는 수의 구역과 연결된 것을 1로 마킹
			}
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 1, people[i]);
		}
		if ( min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	static void dfs(int x, int depth, int sum) {
		// 종료조건
		if ( min == 0 ) return;
		if ( depth == N ) return;
		if ( sum > total - sum) return;
		
		visit[x] = 1;
		
		if ( Math.abs((total - sum) - sum) < min && bfs()) {
			min = Math.min(min, Math.abs((total - sum) - sum));
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i] == 1) {
				for (int j = 0; j < N; j++) {
					if ( sector[i][j] == 1 && visit[i] == 0) dfs(j, depth+1, sum+people[j]);
				}				
			}
		}
		
		visit[x] = 0;
	}
	
	// 안고른 애들 중에서 모두 선거구에 포함되어야 한다. 
	static boolean bfs() {
		int [] v = new int[N];
		Queue<Integer> q = new LinkedList<>();
		int x = 0;
		
		for (int i = 0; i < N; i++) {
			v[i] = visit[i];
			if ( v[i] == 0 ) x = i;
		}
		q.add(x); // dfs 탐색에서 방문하지 않은 지역구의 번호를 queue에 넣는다.
		v[x] = 1; // 그리고 그곳을 1로 마킹
		
		// 지역구가 연결이 되어있고 방문하지 않은 곳인지 탐색
		while(!q.isEmpty()) {
			x = q.poll();
			for (int i = 0; i < N; i++) {
				if ( sector[x][i] == 1 && v[i] == 0) {
					q.add(i);
					v[i] = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if ( v[i] == 0 ) return false;
		}
		return true;
		
		
	}
	
}

// 선거구를 나눠 양쪽 선거구 인구수 합의 최소
// 선거구가 연결 되어있는지
