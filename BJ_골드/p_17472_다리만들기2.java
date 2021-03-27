package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_17472_다리만들기2 {

	static int N,M,min;
	static int [][] map;
	
	// dfs
	static boolean visit[][];
	static int dr [] = {-1,1,0,0};
	static int dc [] = {0,0,-1,1};
	
	static boolean isBoundary(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
	
	// 크루스칼 
	static int V; 	// 정점 
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
	
	// UF
	static int [] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())*(-1);
			}
		}
		
		// dfs - 섬 번호를 라벨링
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ( map[i][j] == -1 && !visit[i][j]) {
					dfs(i, j, num);
					num++;
				}
			}
		}
		
		// 정점 
		V = num - 1;
		
		parent = new int[V+1];
		makeSet(V);
		
		// 간선 찾을거에요.
		hr();
		vr();
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if ( findSet(e.v1) == findSet(e.v2)) continue;
			
			union(e.v1, e.v2);
			min += e.cost;
			cnt++; 
			
			if ( cnt == V-1 ) break;
		}
		
		if ( cnt != V-1) min = -1;
		System.out.println(min == 0 ? -1 : min);
		
	}
	
	
	
	static void vr() {
		for (int i = 0; i < M; i++) {
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			for (int j = 0; j < N; j++) {
				curr = map[j][i];
				if ( prev == 0 && curr != 0 ) {	// 섬을 처음 만난것
					if ( v1 == 0 ) v1 = curr;	
					else {
						v2 = curr;
						if ( cost > 1) addEdge(v1, v2, cost);
						
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				} else if ( v1 != 0 && curr == 0){ // 바다 만남
					cost++;
				}
				
				prev = curr;
			}
		}
		
	}

	static void addEdge(int v1, int v2, int cost) {
		Iterator<Edge> itr = pq.iterator();
		boolean same = false;
		
		while(itr.hasNext()) {
			Edge e = itr.next();
			if ( e.v1 == v1 && e.v2 == v2) {
				same = true;
				if ( e.cost > cost) e.cost = cost;
			}
		}
		
		if ( !same ) pq.offer(new Edge(v1, v2, cost));
	}

	static void hr() {
		for (int i = 0; i < N; i++) {
			int prev = 0;
			int curr = 0;
			int v1 = 0;
			int v2 = 0;
			int cost = 0;
			
			for (int j = 0; j < M; j++) {
				curr = map[i][j];
				if ( prev == 0 && curr != 0 ) {	// 섬을 처음 만난것
					if ( v1 == 0 ) v1 = curr;	
					else {
						v2 = curr;
						if ( cost > 1) addEdge(v1, v2, cost);
						
						v1 = v2;
						v2 = 0;
						cost = 0;
					}
				} else if ( v1 != 0 && curr == 0){ // 바다 만남
					cost++;
				}
				
				prev = curr;
			}
		}
	}



	static void dfs(int r, int c, int num) {
		visit[r][c] = true;
		map[r][c] = num;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if ( isBoundary(nr, nc) || visit[nr][nc] ) continue;
			if ( map[nr][nc] == -1 ) dfs(nr, nc, num);
		}
	}
	
	static class Edge{
		int v1, v2, cost;
		
		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
	}
	
	static void makeSet(int num) {
		for (int i = 1; i <= num; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int a) {
		if ( parent[a] == a) return a;
		else return parent[a] = findSet(parent[a]);
	}
	
	static void union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		if ( pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
	}

	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+ "\t");
			}
			System.out.println();
		}
	}
}

// map에서 1 (섬) 을 찾는다 (dfs)
// 섬에서 출발해서 도착 가능 섬에 건설할 최소 다리 길이 (bfs)
// 모든 섬을 연결하는 다리길이  최소값 (MST)

// 섬과 바다의 정보를 받을 2차원 배열
// 탐색을 하면서 섬을 찾을건데, 완전탐색 -> 깊이우선탐색(dfs) 모든 섬을 찾아서 1~N 섬의 번호를 라벨링
// 