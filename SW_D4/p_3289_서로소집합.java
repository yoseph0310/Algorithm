package SW_D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3289_서로소집합 {

	static int T, n, m, parent[];
	static StringBuilder sb = new StringBuilder();
	
	static void makeSet() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if ( parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if ( px < py ) parent[py] = px;
		else parent[px] = py;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			makeSet();
			
			sb = new StringBuilder();
			sb.append("#"+t+" ");
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if ( op == 1 ) {
					if ( findSet(a) == findSet(b) ) sb.append(1);
					else sb.append(0);
				} else if ( op == 0 ) {
					union(a,b);
				}
				
			}
			
			System.out.println(sb);
			
			
		}
		
	}
	
}
