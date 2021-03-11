package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class p_2309_일곱난쟁이3 {
	
	static int [] dwarf = new int[9];
	static int [] rDwarf = new int[7];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int d1 = 0;
		int d2 = 0;
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}

		Arrays.sort(dwarf);

		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {
				if ( sum - dwarf[i] - dwarf[j] == 100 && i != j ) {
					d1 = dwarf[i];
					d2 = dwarf[j];
					break;
				}
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if ( dwarf[i] == d1 || dwarf[i] == d2) continue;
			System.out.println(dwarf[i]);
		}
		
	}
}
