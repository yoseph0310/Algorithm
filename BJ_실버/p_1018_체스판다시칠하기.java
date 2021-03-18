package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_1018_체스판다시칠하기 {
	
	static int M, N;
	static char [][] map;
	static char [][] check;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		check = new char[2][8];
		
		check[0] = "WBWBWBWB".toCharArray();
		check[1] = "BWBWBWBW".toCharArray();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
			
		}
		
//		print(map);
		
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				min = Math.min(min, solution(i,j));
			}
		}
		System.out.println(min);
		
		
		
	}
	
	static int solution(int r, int c) {
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 2; i++) {
			int cnt = 0;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					
					if ( map[r + j][c + k] != check[(i+j) %2][k]) {
						cnt++;
					}
					
				}
				
			}
			min = Math.min(min, cnt);
		}
		
		return min;
		
	}

	static void print(char [][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	

}
