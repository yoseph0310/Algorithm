package SW_D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p_1251_하나로 {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double cost;
		
		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.cost-o.cost);
		}	
	}
	
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if ( parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void union(int a, int b) {
//		if ( a < b) {
//			parents[b] = parents[a];
//		} else {
//			parents[a] = parents[b];
//		}
		int pa = findSet(a);
		int pb = findSet(b);
		
		if ( pa < pb ) parents[pb] = parents[pa];
		else parents[pa] = parents[pb];
	}

	static int T, N;
	static int parents[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());		// 섬의 개수
			
			double xPos [] = new double[N];				// 섬 x좌표
			double yPos [] = new double[N];				// 섬 y좌표 
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xPos[i] = Double.parseDouble(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yPos[i] = Double.parseDouble(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());			// 환경 부담 세율 실수 E
			
			parents = new int[N];
			make();
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					double xDis = (xPos[i] - xPos[j]) * (xPos[i] - xPos[j]);
					double yDis = (yPos[i] - yPos[j]) * (yPos[i] - yPos[j]);
					double dis = xDis + yDis;
					pq.offer(new Edge(i,j, dis));
				}
			}
			
			
			double cost = 0;
			while(!pq.isEmpty()) {
				Edge Ed = pq.poll();
				int from = findSet(Ed.from);
				int to = findSet(Ed.to);
				if ( from == to ) continue;
				union(from,to);
				cost += E * Ed.cost;
				
			}
			bw.write("#"+t+" "+Math.round(cost)+"\n");	
		}
		bw.close();
		br.close();
		
	}

}
