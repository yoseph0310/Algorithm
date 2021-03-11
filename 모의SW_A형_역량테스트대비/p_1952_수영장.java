package 모의SW_A형_역량테스트대비;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1952_수영장 {
	
	static int T, min;
	static int[] pay;
	static int[] plan;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("p_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			pay = new int[4];			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				pay[i] = Integer.parseInt(st.nextToken());
//				System.out.print(pay[i]+ " ");
			}
//			System.out.println();
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
//				System.out.print(plan[i]+ " ");
			}
//			System.out.println();
			
			min = Integer.MAX_VALUE;
			dfs(0,0);

			min = Math.min(min, pay[3]);
			System.out.println("#"+t+" "+min);
		}
	}
	
	static void dfs(int cnt, int sum) {
		
		if ( cnt >= 12 ) {
			min = Math.min(min, sum);
			return;
		}
		
		if ( plan[cnt] == 0) {
			dfs(cnt+1, sum);
		}
		else {
			dfs(cnt + 1, sum + (plan[cnt]*pay[0]));
			dfs(cnt + 1, sum + pay[1]);
			dfs(cnt + 3, sum + pay[2]);
		}
		
	}

}

// DFS

// i월까지 j이용권으로 수영장에 다니는 최소비용 d[i]를 구한다.
// (1)i-1 월의 최소비용 + min(1일권 * 이용일, 1개월 권)i>=1
// (2)i-2 월의 최소비용 + 3개월 권 i>=3
// 각 달에 (1)(2) 중 작은 값을 선택한다.
// 12월까지 비용을 정하면 1년 이용권과 비교해 작은 쪽을 택한다.