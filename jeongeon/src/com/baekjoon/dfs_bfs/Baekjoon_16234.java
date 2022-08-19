package com.baekjoon.dfs_bfs;
//baekjoon 16234 인구이동

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_16234 {
	static int N, L, R;
	static int arr[][];
	static Queue<Point> q = new LinkedList<>();
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String split[] = br.readLine().split(" ");
		N = Integer.parseInt(split[0]); //NxN크기의 땅
		L = Integer.parseInt(split[1]); //L명이상
		R = Integer.parseInt(split[2]); //R명이상
		 
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			split = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		bfs();
	}
	private static void bfs() {
		q.add(new Point(0,0));
		visited[0][0] = true;
		
		int dx[] = {0, -1, 0, 1};
		int dy[] = {1, 0, -1, 0};
		
		//int sum = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int sum = 0;
			Point cur = q.poll();
			sum += arr[cur.x][cur.y];
			cnt++;
			
			for(int d=0; d<4; d++) {
				int testX = cur.x + dx[d];
				int testY = cur.y + dy[d];
				
				if(testX<0 || testX>=N || testY<0 || testY>=N) continue;
				
				int diff = Math.abs(arr[cur.x][cur.y] - arr[testX][testY]);
				if(!visited[testX][testY] && L<=diff && diff>=L) {
					q.add(new Point(testX, testY));
					visited[testX][testY] = true;
				}
			}

		}
		
	}
	
	
}
