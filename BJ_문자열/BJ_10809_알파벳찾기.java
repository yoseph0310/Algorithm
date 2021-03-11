package BJ_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10809_알파벳찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int [] arr = new int[26];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if ( arr[c-'a'] == -1)
				arr[c-'a'] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

}
