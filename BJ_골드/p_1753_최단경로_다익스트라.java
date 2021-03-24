package BJ_골드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1753_최단경로_다익스트라 {
	
	static LinkedList<Node> list[];
	static int [] dist;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		visit = new boolean[V+1];
		list = new LinkedList[V+1];
		dist = new int[V+1];
		
		Arrays.fill(dist, -1);
		
		for (int i = 1; i <= V; i++) {
			list[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			list[V1].add(new Node(V2, W));
		}
		
		dijkstra(start);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == -1 ? "INF" : dist[i]).append("\n");
		}
		System.out.print(sb.toString());
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if ( !visit[now.number]) {
				visit[now.number] = true;
				for (Node next : list[now.number]) {
					if ( dist[next.number] == -1 || dist[next.number] > dist[now.number] + next.weight) {
						dist[next.number] = dist[now.number] + next.weight;
						pq.offer(new Node(next.number, dist[next.number]));
					}
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int number, weight;
		
		public Node (int n, int w){
			this.number = n;
			this.weight = w;
		}

		@Override
		public int compareTo(Node n) {
			return weight - n.weight;
		}
	}
}
