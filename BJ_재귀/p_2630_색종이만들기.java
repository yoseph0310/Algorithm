package BJ_재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2630_색종이만들기 {

	static int N;
	static int [][] map;
	static int [] cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		cnt = new int[2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		for (int n : cnt) {
			System.out.println(n);
		}
	}
	
	static void divide(int r, int c, int n) {
		
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if ( map[i][j] != map[r][c]) {
					divide(r,c,n/2);
					divide(r,c+n/2,n/2);
					divide(r+n/2,c,n/2);
					divide(r+n/2,c+n/2,n/2);
					
					return;
				}
			}
		}
		
		cnt[map[r][c]]++;
	}

}
