package SW_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1284_수도요금경쟁 {

	static int T, ans; // 테케, 정답, 
	static int P; // A사 리터당 요금
	static int Q; // B사 기본요금
	static int R; // 이하인 경우 Q만큼 청구
	static int S; // R리터 초과시 B사 기본요금
	static int W; // 종민 월간 사용량
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// A, B 사 한달 사용량 각각 계산
			
			// A
			int aPay = W * P;
						
			// B
			int bPay = R >= W ? Q : Q + (W-R)*S;
			ans = Math.min(aPay, bPay);
			
			
			System.out.println("#"+t+" "+ans);
		}
	}

}
// 종민 월간 사용량 : W 리터

// A 사 : 리터당 P원
// B 사 : Q + 
		//  C = (W가 R이하면) 0 
		//      ( 아니면 ) 리터당 S원


