package BJ_실버.p_15649_N과M_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_15649_N과M_1 {
	
	static int N, M;
	static int arr[];
	static boolean selected[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		selected = new boolean[N];

		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if ( depth == M ) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ( selected[i] ) continue;
			
			selected[i] = true;
			arr[depth] = i+1;
			dfs(depth+1);
			selected[i] = false;
			
		}
	}

}
