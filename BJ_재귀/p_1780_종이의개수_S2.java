package BJ_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p_1780_종이의개수_S2 {
	
	static int N;
	static int [][] map;
	static int[] cnt_arr;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt_arr = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print(map);
		
		cut(0,0,N);
		
		for (int n : cnt_arr) {
			System.out.println(n);
		}

	}
	
	static boolean check(int r, int c, int N) {
		int num = map[r][c];
		for (int i = r; i < r+N; i++) {
			for (int j = c; j < c+N; j++) {
				if ( num != map[i][j] ) return false;
			}
		}
		
		return true;
	}
	
	static void cut(int r, int c, int N) {
		
		if ( check(r,c,N) ) {
			cnt_arr[map[r][c]+1]++;
		}
		else {
			int size = N/3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cut( r+size*i, c+size*j, size);
				}
			}
		}
		
		
	}

}
