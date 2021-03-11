package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_13300_방배정2 {
	
	static int[][] student;
	static int N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());	// 학생수
		K = Integer.parseInt(st.nextToken());	// 방 제한 인원
		// 1~6, 여(0) 남(1)
		student = new int[2][7];
		int room = 0;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken()); // 성별
			int grade = Integer.parseInt(st.nextToken()); // 학년
			
			if ( sex == 0 ) student[0][grade]++;
			else student[1][grade]++;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				if ( student[i][j] == 0 )continue;
				
				room += student[i][j] / K ;
				if ( student[i][j] % K != 0 ) {
					room++;
				}
				
			}
		}
		System.out.println(room);
		
	}
}
