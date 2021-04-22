package 모의SW_A형_역량테스트대비.p_2115_벌꿀채취;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2115_벌꿀채취_2 {
	
	static int T, max, N, M, C;
	static int map[][];
	static int profit[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			profit = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			init();
			
			System.out.println("#"+t+" "+max);
		}
		
		
	} // main
	
	static void init() {
		
		makeProfit();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				comb(i, j+M, 1, profit[i][j]);
			}
		}
	}
	
	static void comb(int r, int c, int cnt, int sum) {
		if ( cnt == 2 ) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = r; i < N; i++) {
			for (int j = c; j <= N-M; j++) {
				comb(i, j+M, cnt+1, sum+profit[i][j]);
			}
			c = 0;
		}
	}
	
	static void makeProfit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				profitSubset(i, j, 0, 0, 0);
			}
		}
	}
	static void profitSubset(int i, int j, int cnt, int sum, int tSum) {
		if ( sum > C ) return;
		if ( cnt == M ) {
			profit[i][j-M] = Math.max(profit[i][j-M], tSum);
			return;
		}
		
		profitSubset(i, j+1, cnt+1, sum+map[i][j] , tSum+map[i][j]*map[i][j]);
		profitSubset(i, j+1, cnt+1, sum , tSum);
	}

}
