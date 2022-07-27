package Baekjoon_1051;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int maxDistance = 0;
		int maxSquare = N > M ? M : N;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int x = 0; x < N - 1; x++) {
			for(int y = 0; y < M - 1; y++) {
				for(int d = 1; d < maxSquare; d++) {
					if(isRange(x, y, N, M, d) && map[x][y] == map[x+d][y] && map[x][y] == map[x][y+d] &&
					   map[x+d][y] == map[x+d][y+d] && map[x][y+d] == map[x+d][y+d]) {
						maxDistance = Math.max(d, maxDistance);
					}
				}
			}
		}
		
		maxDistance++;
		bw.write(String.valueOf(maxDistance * maxDistance));
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	static boolean isRange(int x, int y, int n, int m, int d) {
		return 0 <= x && 0 <= y && 0 <= x+d && 0 <= y+d && x < n && y < m && x+d < n && y+d < m;
	}
}
