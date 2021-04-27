package BJ_골드.p_1922_네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_1922_네트워크연결 {
	
	static class Edge implements Comparable<Edge>{
		int e, v, cost;
		
		public Edge(int e, int v, int cost) {
			this.e = e;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if ( this.cost < o.cost) {
				return -1;
			} else if ( this.cost == o.cost) {
				return 0;
			} else {
				return 1;				
			}
		}
		
	}
	static int N, M, ans;
	static ArrayList<Edge> list;
	static int parents[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
	}

}
