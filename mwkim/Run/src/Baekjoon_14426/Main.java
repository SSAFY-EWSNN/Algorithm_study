package Baekjoon_14426;

import java.io.*;
import java.util.*;

public class Main {
	static int visited[] = new int[2001];
	static int cnt = 0;
	static int S;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(in.readLine());
		bfs();
		
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		visited[1] = cnt;
		q.offer(1);
		
		int clipboard = 0;
		
		while(!q.isEmpty()) {
			
		}
		
	}
}
