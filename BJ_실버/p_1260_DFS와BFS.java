package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1260_DFS와BFS {
	
	static int N,M,V;
	static boolean [][] graph;
	static boolean [] visit;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		// 정점
		M = Integer.parseInt(st.nextToken());		// 간선 개수
		V = Integer.parseInt(st.nextToken());		// 시작할 정점 번호
		
		graph = new boolean[1001][1001];
		visit = new boolean[1001];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from][to] = graph[to][from] = true;
		}
		
		dfs(V);
		
		visit = new boolean[1001];
		System.out.println();
		bfs();
	}


	private static void dfs(int num) {
		visit[num] = true;
		System.out.print(num + " ");
		
		for (int i = 1; i <= N; i++) {
			if ( graph[num][i] && !visit[i] ) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visit[V] = true;
		System.out.print(V+ " ");
		
		while(!q.isEmpty()) {
			
			int temp = q.poll();
			
			for (int i = 1; i <= N; i++) {	
				if ( graph[temp][i] && !visit[i]) {
					q.add(i);
					visit[i] = true;
					System.out.print(i+" ");
				}
			}
		}
		
		
		
		
	}

}
