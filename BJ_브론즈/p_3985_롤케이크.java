package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_3985_롤케이크 {
	
	static int L, N, P, K; // 롤케이크의 길이, 방청객의 수, 적어낸 수 PK
	static int [] rollCake; // 롤케잌
	static int [] person_e, person_r;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		L = Integer.parseInt(br.readLine());	// 롤케잌
		N = Integer.parseInt(br.readLine());	// 방청객수
		
		rollCake = new int[L+1];
		person_e = new int[N+1];
		person_r = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 기대되는 양
			person_e[i] = K-P+1;
			
			// P부터 K까지 케이크 차지
			for (int j = P; j <= K; j++) {
				if ( rollCake[j] == 0) {
					rollCake[j] = i;
				}
			}
			
			
		}
//		print(rollCake);
		
		// 실제 받은 케이크;
		for (int i = 1; i <= L; i++) {
			if ( rollCake[i] != 0) {
				++person_r[rollCake[i]]; 
			}
		}
		
		int max_e = 0, idx_e = 0;
		int max_r = 0, idx_r = 0;
		
		for (int i = 1; i <= N; i++) {
			if ( person_e[i] > max_e) {
				max_e = person_e[i];
				idx_e = i;
			}
			if ( person_r[i] > max_r) {
				max_r = person_r[i];
				idx_r = i;
			}
		}
		
		System.out.println(idx_e);
		System.out.println(idx_r);
		
	}// main
	public static void print(int[]arr) {
		for (int i = 0; i < L; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}// class
// 가장많이 받을 것으로 기대되는 사람 인덱스 출력 -> K-P
// 실제로 가장 많이 받은 사람. check 배열에서 가장 숫자가 높은 인덱스 출력