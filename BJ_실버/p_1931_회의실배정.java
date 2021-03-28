package BJ_실버.p_1931_회의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p_1931_회의실배정 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int time [][] = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());	// 시작 
			time[i][1] = Integer.parseInt(st.nextToken()); 	// 종료
		}
		
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if ( o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int prev_end_time = 0;
		
		for (int i = 0; i < N; i++) {
			if ( prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
