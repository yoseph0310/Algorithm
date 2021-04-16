package JO.p_2577_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p_2577_회전초밥2 {
	
	static int N, d, k, c;
	static int dish[];
	static int kind[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());				// 접시의수
		d = Integer.parseInt(st.nextToken());				// 초밥의 가짓수
		k = Integer.parseInt(st.nextToken());				// 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken());				// 쿠폰 번호 
		
		dish = new int[N];
		kind = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(slide());
	}
	
	static int slide() {
		int total = 0, max = 0;
		for (int i = 0; i < k; i++) {
			if ( kind[dish[i]] == 0) total++;
			kind[dish[i]]++;
		}
		max = total;
		
		for (int i = 1; i < N; i++) {
			if (max <= total) {
				if(kind[c] == 0)
					max = total + 1;
				else
					max = total;
				
			}
			
			kind[dish[i-1]]--;
			if(kind[dish[i-1]] == 0 ) total--;
			
			if(kind[dish[(i+k-1)%N]]==0) total++;
			kind[dish[(i+k-1)%N]]++;
		}
		return max;
	}
}
