package 모의SW_A형_역량테스트대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_17281_야구 {
	
	static int N;
	static int [][] rst;
	static boolean [] visit;
	static int [] player;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		rst = new int[N][10];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				rst[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[10];
		player = new int[10];
		player[4] = 1;
		max = -1;
		perm(1);
		System.out.println(max);

	}
	
	static void perm(int len) {
		if ( len == 4) {
			perm(len+1);
			return;
		}
		
		if ( len == 10 ) {
			int score = playGame();
			max = Math.max(max, score);
			return;
		}
		
		for (int i = 2; i < 10; i++) {
			if ( visit[i] ) continue;
			
			player[len] = i;
			visit[i] = true;
			perm(len+1);
			visit[i] = false;
		}
	}
	
	static int playGame() {
		int score = 0;
		int outCnt;
		boolean [] base = new boolean[4];
		int hitter = 1;
		
		for (int i = 0; i < N; i++) {
			outCnt = 0;
			Arrays.fill(base, false);
			
			while(true) {
				int now = rst[i][player[hitter]];
				if ( hitter == 9 ) hitter = 1;
				else hitter++;
				
				if ( now == 1 ) {
					
					if ( base[3] ) {
						score++;
						base[3] = false;
					}
					for (int r = 2; r >= 1; r--) {
						if ( base[r] ) {
							base[r] = false;
							base[r+1] = true;
						}
					}
					base[1] = true;
					
				} else if ( now == 2 ){
					
					if ( base[3] ) {
						score++;
						base[3] = false;
					}
					if ( base[2] ) {
						score++;
						base[2] = false;
					}
					if ( base[1] ) {
						base[1] = false;
						base[3] = true;
					}
					base[2] = true;
					
				} else if ( now  == 3 ){
					
					for (int r = 1; r <= 3; r++) {
						if ( base[r] ) {
							score++;
							base[r] = false;
						}
					}
					base[3] = true;
					
				} else if ( now == 4 ) {
					for (int r = 1; r <= 3; r++) {
						if ( base[r] ) {
							score++;
							base[r] = false;
						}
					}
					score++;
				} else if ( now == 0 ) {
					outCnt++;
					if ( outCnt == 3 ) {
						break;
					}
				}
			}
			
		}
		return score;
	}
	
}
