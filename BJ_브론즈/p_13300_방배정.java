package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p_13300_방배정 {
	
	static int N, K; // 총 학생수, 방에 배정할 최대 인원수
	static int [][] student;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		N = Integer.parseInt(st.nextToken());	// 총 학생수
		K = Integer.parseInt(st.nextToken());	// 방 최대 인원수
		int room = 0;
		
		// 1~6학년, 남녀 구분
		student = new int[7][2];				
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			if ( sex == 0 ) student[grade][0]++; // 여 -> [학년][0] ++
			else student[grade][1]++; // 남 -> [학년][1] ++
			
		}
		
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if ( student[i][j] == 0) continue; // i학년 학생이 없는 경우
				
				room += student[i][j] / K; // 방 계산
				if ( student[i][j] % K != 0 ) room++;
			}
		}
//		print(student);
		
		System.out.println(room);
		
	}
	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}


// 1~6 학년
// 남 녀
// 방 안에는 같은 학년
// 한 방에 한명도 가능

// 남학생이면 -> 학년을 체크하고 -> 한방에 K명씩 들어갈때 cnt
// 여학생도 -> 학년을 체크하고 -> 한방에 K명씩 들어갈때 cnt