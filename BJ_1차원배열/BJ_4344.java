package BJ_1차원배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4344 {

	static int C, snum;	// 테케 , 학생수
	static int[] score; // 학생의 점수
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		C = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= C; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			snum = Integer.parseInt(st.nextToken());
			score = new int[snum];
			
			double sum = 0, avg = 0, res = 0;
			double cnt = 0;
			
			for (int i = 0; i < snum; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
				avg = sum/snum;
			}
			
			for (int i = 0; i < snum; i++) {
				if ( score[i] > avg) {
					cnt++;
				}
			}
			 
			res = (cnt/snum)*100;
			
			System.out.printf("%.3f%%",res);
			System.out.println();
			
			
		}
	}

}
