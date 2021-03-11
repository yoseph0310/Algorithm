package BJ_실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p_17413_단어뒤집기2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		int check = 0;
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < s.length(); i++) {
//			System.out.print(s.charAt(i));
			if (s.charAt(i) == '<') {
				check+=1;
				while(!stack.isEmpty()) { // 여태 만난 문자나 공백 넣기
					sb.append(stack.pop());
				}
				sb.append('<');
			}
			else if ( s.charAt(i) == '>') {
				check-=1;
				sb.append('>');
			}
			else if ( s.charAt(i) == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			}
			else {
				if ( check == 0) {		// 태그 밖
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
// 공백 기준으로 뒤집고
// '>'  '<' 사이 뒤집고
// 