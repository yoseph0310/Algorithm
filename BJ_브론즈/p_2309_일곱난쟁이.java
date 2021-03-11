package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_2309_일곱난쟁이 {
	
	static int [] dwarf = new int[9];
	static int [] R_dwarf = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		
		comb(0,0,0);
	}
	
	static void comb(int cnt, int dIdx, int sum) {
		
		if ( cnt == 7 ) {
			if ( sum == 100) {
				Arrays.sort(R_dwarf);
				for (int i = 0; i < R_dwarf.length; i++) {
					System.out.println(R_dwarf[i]);
				}
			}
			return;
		}
		
		if ( dIdx == 9 ) {
			return;
		}
		
		R_dwarf[cnt] = dwarf[dIdx];
		comb(cnt+1, dIdx+1, sum+dwarf[dIdx]);
		comb(cnt, dIdx+1, sum);
		
	}
}
