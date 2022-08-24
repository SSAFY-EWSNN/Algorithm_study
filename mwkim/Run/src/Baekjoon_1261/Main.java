package Baekjoon_1261;

import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
	int r;
	int c;
	int breaks;
	public Point(int r, int c, int breaks) {
		this.r = r;
		this.c = c;
		this.breaks = breaks;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.breaks - o.breaks;
	}
	
}
public class Main {
	static int N, M;
	static int map[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
	static final int BLANK = 0;
	static final int WALL = 1;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
		}
		int ans = bfs(0,0);
		System.out.println(ans);
		
	}
	
	static int bfs(int r, int c) {
		boolean visited[][] = new boolean[N][M];
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		q.offer(new Point(0,0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N-1 && p.c == M-1) {
				return p.breaks;
			}
			
			for(int d = 0; d < 4; d++) {
				int nextR = p.r + dr[d];
				int nextC = p.c + dc[d];
				
				if(range(nextR, nextC)) {
					if(!visited[nextR][nextC] && map[nextR][nextC] == 0) {
						visited[nextR][nextC] = true;
						q.offer(new Point(nextR, nextC, p.breaks));
					}
					else if(!visited[nextR][nextC] && map[nextR][nextC] == 1) {
						visited[nextR][nextC] = true;
						q.offer(new Point(nextR, nextC, p.breaks+1));
					}
				}
			}
		}
		
		return 0;
	}
	
	static boolean range(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
