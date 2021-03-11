package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10163_색종이2 {

	static int [][] map = new int[101][101];
	static int[] arr = new int[4];	// 색종이 정보
	static int N, cnt;	// 색종이 갯수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		// 색종이 하나 당 정보를 받아들이고 map 에 찍기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = arr[0]; j < arr[0]+arr[2]; j++) {
				for (int k = arr[1]; k < arr[1]+arr[3]; k++) {
					map[j][k] = i;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			
			cnt = 0;
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 101; k++) {
					if(map[j][k] == i ) cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
	}

}
