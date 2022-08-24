package Baekjoon_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] output;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과 출력을 위한 스트링빌더 생성.
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
	
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
	}
	static void comb(int cnt, int start) {
		
	}
}
