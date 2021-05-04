package Programmers;

import java.util.*;

public class 게임맵최단거리 {
    
    static class Point{
        int r; int c; int cost;
        
        public Point(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,-1,0,1};
    static boolean visited[][];
    static int n, m;
    
    static boolean isBoundary(int r, int c){
        return r >= 0 && c >= 0 && r < n && c < m;
    }
    
    static int bfs(int r, int c, int[][] maps){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,1));
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            if ( cur.r == n - 1 && cur.c == m - 1) {
                return cur.cost;
            }
            
            for(int d = 0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if ( isBoundary(nr,nc) && !visited[nr][nc] && maps[nr][nc] == 1){
                    q.add(new Point(nr, nc, cur.cost+1));
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        return bfs(0,0,maps);
    }
}
