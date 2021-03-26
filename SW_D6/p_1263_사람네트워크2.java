package SW_D6;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1263_사람네트워크2 {
	
	static final int INF = 9999999;
	static int T, N, min;
	static int input[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			input = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int v = Integer.parseInt(st.nextToken());
					input[i][j] = v;
					if ( input[i][j] == 0 && i!=j) {
						input[i][j] = INF;
					}
				}
			}
//			print(input);
			
			// FLOYD
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if ( i == k ) continue;
					for (int j = 0; j < N; j++) {
						if ( i == j || j == k) continue;
						input[i][j] = Math.min(input[i][j], input[i][k]+input[k][j]);
						
					}
				}
			}
//			print(input);
			
			for (int i = 0; i < N; i++) {
				int dist = 0;
				for (int j = 0; j < N; j++) {
					dist += input[i][j];
				}
				min = Math.min(min, dist);
			}
			System.out.println("#"+t+" "+min);
		}

	}// main
	
	static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

}
