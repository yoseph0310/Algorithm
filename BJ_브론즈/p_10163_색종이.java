package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10163_색종이 {
	
	static int [][] map = new int[101][101];
	static int [] arr = new int[4]; // 색종이 정보
	
	static int N; // 색종이 장수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			for (int i = r1; i < r1+r2; i++) {
				for (int j = c1; j < c1+c2; j++) {
					map[i][j] = n;
				}
			}
//			
//			
//			
//			for (int i = r1; i < r1+r2; i++) {
//				for (int j = c1; j < c1+c2; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		}
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 101; k++) {
					if ( map[j][k] == i) cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
		
	}

}
