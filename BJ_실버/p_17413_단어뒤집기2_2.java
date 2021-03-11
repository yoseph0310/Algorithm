package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_17413_단어뒤집기2_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if( s.charAt(i) == '<') {
				cnt++;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append('<');
			}
			else if( s.charAt(i) == '>') {
				cnt--;
				sb.append('>');
			}
			else if ( s.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			}
			else {
				if ( cnt == 0) {
					stack.push(s.charAt(i));
				}
				else {
					sb.append(s.charAt(i));
				}
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
