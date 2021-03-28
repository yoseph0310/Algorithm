package BJ_골드.p_1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1916_최소비용구하기 {
	
	static int N, M;
	static ArrayList<Point>[] List;
	static int dist[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		// 정점개수
		M = Integer.parseInt(br.readLine());		// 간선개수
		
		List = new ArrayList[N+1];
		dist = new int[N+1];
	
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 1; i <= N; i++) {
			List[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			List[v1].add(new Point(v2, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(dist[end]);
		
		
	}
	static void dijkstra(int start) {
		PriorityQueue<Point> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
		pq.add(new Point(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Point curr = pq.poll();
			if ( dist[curr.v] < curr.cost) continue;
			
			for (int i = 0; i < List[curr.v].size(); i++) {
				Point next = List[curr.v].get(i);
				
				if (dist[next.v] > dist[curr.v] + List[curr.v].get(i).cost) {
					dist[next.v] = dist[curr.v] + List[curr.v].get(i).cost;
					pq.add(new Point(next.v, dist[next.v]));
				}
			}
		}
	}

	static class Point  {
		int v, cost;
		
		public Point(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
}

// N개의 도시. 한 도시에 출발하여 다른 도시에 도착하는 M개의 버스
// A -> B까지  가는 드는 버스 비용 최소화
// A -> B까지 가는 최소비용 출력
