package Baekjoon.src.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569_토마토2 {
	static int N, M, H;
	static int[] dirX = { -1, 1, 0, 0, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1, 0, 0 };
	static int[] dirZ = { 0, 0, 0, 0, -1, 1 };
	static int[][][] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<T> q = new LinkedList<T>();
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[h][i][j] == 1) {
						q.offer(new T(h,i,j));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			T poll = q.poll();
			
			for(int d=0; d<6; d++) {
				int dx = poll.x+dirX[d];
				int dy = poll.y+dirY[d];
				int dz = poll.z+dirZ[d];
				
				if(dx<0 || dx>=N || dy<0 || dy>= M || dz<0 || dz>=H) continue;
				if(arr[dz][dx][dy] != 0) continue;
				
				arr[dz][dx][dy] = arr[poll.z][poll.x][poll.y] + 1;
				q.add(new T(dz,dx,dy));
			}
		}
		
		int max = 0;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[h][i][j] == 0) {
						ans = -1;
						return;
					}
					
					max = Math.max(arr[h][i][j], max);
					
				}
			}
		}
		
		ans = max-1;
		
	}
	
	static class T {
		int x,y,z;

		public T(int z, int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}

}
