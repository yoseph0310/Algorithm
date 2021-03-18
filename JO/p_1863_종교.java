package JO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1863_종교 {
	
	static int n, m;
	static int [] parent;
	
	static void makeSet() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if ( parent[x] == x ) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if ( px < py) parent[py] = px;
		else parent[px] = py;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 사람 수
		m = Integer.parseInt(st.nextToken());	// 쌍의 수
		
		parent = new int[n+1];
		makeSet();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
					
		}
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			if ( i == parent[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
