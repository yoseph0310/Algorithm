package BJ_골드.p_9019_DSLR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_9019_DSLR {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			String [] command = new String[10000];
			boolean [] visit = new boolean[10000];
			
			Queue<Integer> q = new LinkedList<>();
			
			visit[a] = true;
			q.add(a);
			Arrays.fill(command, "");
			
			while(!q.isEmpty() && !visit[b]) {
				int now = q.poll();
				int D = (2*now) % 10000;
				int S = (now == 0 ) ? 9999 : now-1;
				int L = (now%1000) * 10 + now/1000;
				int R = (now%10) * 1000 + now/10;
				
				if(!visit[D]) {
					q.add(D);
					visit[D] = true;
					command[D] = command[now]+"D";
				}
				if(!visit[S]) {
					q.add(S);
					visit[S] = true;
					command[S] = command[now]+"S";
				}
				if(!visit[L]) {
					q.add(L);
					visit[L] = true;
					command[L] = command[now]+"L";
				}
				if(!visit[R]) {
					q.add(R);
					visit[R] = true;
					command[R] = command[now]+"R";
				}
						
			}
			System.out.println(command[b]);
			
		}
	}
}
