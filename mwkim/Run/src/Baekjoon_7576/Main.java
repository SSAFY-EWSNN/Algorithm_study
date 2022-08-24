package Baekjoon_7576;

import java.io.*;
import java.util.*;

class Point{
	int r;
	int c;
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}
public class Main {
	static int[][] tomato;
	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int cnt = 0;
	
	static final int WELLDONE = 1;
	static final int LAIR = 0;
	static final int BLANK = -1;
	
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과 출력을 위한 스트링빌더 생성.
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	
		tomato = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(0 <= nr && nr < N && 0 <= nc && nc < M) {
					if(tomato[nr][nc] == LAIR) {
						tomato[nr][nc] = tomato[r][c] + 1;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) {
					return -1;
				}
				result = Math.max(result, tomato[i][j]);
			}
		}
		return result - 1;
	}
}
