package SW_D4;

import java.util.*;
import java.io.*;

public class s_1238 {
	
	static int max_num, max_depth;
	static int L, S;
	static boolean [][] graph;
	static Queue<Node> q = new LinkedList<Node>();
	static boolean [] visit;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("p_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			
			graph = new boolean[101][101];
			visit = new boolean[101];
			max_num = Integer.MIN_VALUE;
			max_depth = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to] = true;
			}
			
			
			
			bfs();
			System.out.println("#"+t+" "+max_num);
		}
	}
	static void bfs() {
		visit[S] = true;
		q.offer(new Node(S, 0));
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			// 실행 시킬 코드
			if ( current.d > max_depth) {
				max_depth = current.d;
				max_num = current.n;
			} else if ( current.d == max_depth ) {
				max_num = Math.max(max_num, current.n);
			}
			
			// 다음 노드 탐색
			for (int i = 1; i <= 100; i++) {
				if ( graph[current.n][i] && !visit[i] ) {
					visit[i] = true;
					q.offer(new Node(i, current.d+1));
				}
			}
		}
	}
	
	static class Node{
		int n;
		int d;
		
		public Node(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}
	
}



















