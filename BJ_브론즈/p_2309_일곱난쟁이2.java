package BJ_브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_2309_일곱난쟁이2 {
	
	static int [] dwarf = new int[9];
	static int sum, num1, num2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum+=dwarf[i];
		}
//		System.out.println(sum);
		for (int i = 0; i < dwarf.length-1; i++) {
			for (int j = i; j < dwarf.length; j++) {
				if ( sum - dwarf[i] - dwarf[j] == 100 && i != j) {
					num1 = dwarf[i];
					num2 = dwarf[j];
//					System.out.println(i+" "+j+" "+sum);
					break;
				}
			}
			
		}
		
		Arrays.sort(dwarf);
		for (int i = 0; i < dwarf.length; i++) {
			if ( dwarf[i] == num1 || dwarf[i] == num2) continue;
			System.out.println(dwarf[i]);
		}
		
	}
	
}
