package BJ_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_17471_게리멘더링 {
	
	static int min = Integer.MAX_VALUE; // 인구 차이의 최솟값
	static int N;	// 구역의 개수 N
	static int [] people; // 각 구역 당 인구
	static int [][] sector; // 각 구역 인접구역 정보
	
	static int[] visit;
	static int total = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		sector = new int[N][N];
		visit = new int[N];
		
		// 구역 당 인구 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total += people[i];
		}
		
		// 구역 당 인접구역 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				int L = Integer.parseInt(st.nextToken())-1;
				sector[i][L] = 1;	// 각 선거구가 연결된 곳을 1로 마킹
				sector[L][i] = 1;
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 1, people[i]);
		}
		if ( min == Integer.MAX_VALUE ) System.out.println(-1); 
		else System.out.println(min);
		
	}
	
	static void dfs(int x, int depth, int sum) {
		if ( min == 0 ) return;
		if ( depth == N ) return;
		if ( sum > total - sum ) return;
		
		visit[x] = 1;
		
		if (Math.abs((total - sum) - sum ) < min && bfs()) {
			min = Math.min(min, Math.abs((total - sum) - sum));
		}
		
		for (int i = 0; i < N; i++) {
			if ( visit[i] == 1 ) {
				for (int j = 0; j < N; j++) {
					if ( sector[i][j] == 1 && visit[j] == 0) dfs(j, depth + 1, sum + people[j]);
				}
			}
		}
		
		visit[x] = 0;
	}
	
	static boolean bfs() {
		
		int [] v = new int[N];
		Queue<Integer> q = new LinkedList<>();
		int x = 0;
		for (int i = 0; i < N; i++) {
			v[i] = visit[i];
			if ( v[i] == 0 ) x = i;
		}
		q.add(x);
		v[x] = 1;
		
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
