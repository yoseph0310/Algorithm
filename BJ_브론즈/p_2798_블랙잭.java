package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2798_블랙잭 {

	static int N, M; // N장의 카드, 최대 제한 수
	static int [] card;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		System.out.println(N+" "+M);
		
		card = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		//
		int sum = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					sum = card[i] + card[j] + card[k];
					if ( sum <= M ) {
						max = Math.max(sum, max);
					}
				}
			}
		}
		System.out.println(max);
		
		
//		for (int i = 0; i < N; i++) {
//			System.out.print(card[i]+" ");
//		}
	}

}

// 카드의 합  < 21 ( 이 범위 안에서 카드의 합 max)
// 각 카드에는 양의 정수가 쓰여있다.
// N장의 카드를 숫자가 보이게 놓는다.
// 숫자 M을 외친다.
// N장의 카드 중에 3장의 카드를 고른다.
// 이 3장의 카드의 합이 M을 넘지 않으면서 M과 최대한 가까워야함