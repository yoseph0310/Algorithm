package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1932_정수삼각형 {

	static int N;
	static int arr[][];
	static int DP[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		DP = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			DP[N-1][i] = arr[N-1][i];
		}
		
		System.out.println(find(0,0));
		
		
	}
	
	static int find(int depth, int idx) {
		
		if ( depth == N-1 ) return DP[depth][idx];
		
		if ( DP[depth][idx] == 0) {
			DP[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + arr[depth][idx];
		}
		
		return DP[depth][idx];
	}
	
	
	static void print( int [][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
