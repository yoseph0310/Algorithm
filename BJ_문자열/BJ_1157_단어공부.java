package BJ_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1157_단어공부 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		s = s.toUpperCase();
		
		int [] alphabet = new int[26];
		int [] Talphabet = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			int temp = s.charAt(i) - 'A';
			
			alphabet[temp] += 1;
			Talphabet[temp] += 1;
		}
		
		Arrays.sort(Talphabet);
		
		
		int max = 0;
		int count = 0;
		
		if ( Talphabet[25] == Talphabet[24]) {
			System.out.println("?");
		}
		else {
			for (int i = 0; i < alphabet.length; i++) {
				if ( max < alphabet[i]) {
					max = alphabet[i];
					count = i;
				}
			}
			count = count + 65;
			
			char answer = (char) count;
			System.out.println(answer);
		}
	}
}
