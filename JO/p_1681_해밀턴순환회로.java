package JO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1681_해밀턴순환회로 {
	
	static int N;
	static int [][] graph;
	static boolean [] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit[0] = true;
		dfs(0,0,0);
		System.out.println(min);
	}
	
	static void dfs(int now, int select, int cost) {
		
		if ( select == N-1) {
			if ( graph[now][0] == 0) {
				return;
			}
			cost += graph[now][0];
			min = Math.min(cost, min);
			return;
		}
		if (cost>min)	// 이미 찾은 최소보다 크면 더 찾을 필요가 없다. (가지치기)
			return;
		
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			if ( graph[now][i] == 0) continue;
			
			visit[i] = true;
			dfs(i, select+1, cost+graph[now][i]);
			visit[i] = false;
			
		}
		
		
		
	}
}
