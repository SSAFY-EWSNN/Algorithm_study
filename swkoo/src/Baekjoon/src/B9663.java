package Baekjoon.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9663 {
	// 백준 9663 N-Queen

	static int ans = 0;
	static int N = 0;
	static int[] x; // (x,y) => int[x]=y

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		x = new int[N];
		
		nQueen(0);
		
		sb.append(ans);
		System.out.println(sb.toString());
	}

	/**
	 * (0,0) (0,1) (0,2) (0,3) (0,4)
	 * (1,0) (1,1) (1,2) (1,3) (1,4) 
	 * (2,0) (2,1) (2,2) (2,3) (2,4) 
	 * (3,0) (3,1) (3,2) (3,3) (3,4) 
	 * (4,0) (4,1) (4,2) (4,3) (4,4)
	 */

	static void nQueen(int xIndex) {
		
		// [기저조건] 맨 오른쪽까지 검사가 통과 되면 ans 증가
		if (xIndex == N) {
			ans++;
			return;
		}

		// i 가 증가함에 따라 1번째줄, 2번째줄, 3번째줄 ... 검사
		// xIndex는 x좌표(가로(열))을 의미 i는 y좌표(세로(행))을 의미
		for (int i = 0; i < N; i++) {
			x[xIndex] = i;
			
			boolean flag = true;
			
			for (int j = 0; j < xIndex; j++) {
				if(x[xIndex] == x[j]) {
					flag = false;
					break;
				}
				
				// 열(x좌표)의 차 = 행(y좌표)의 차 => 대각선에 위치
				if(Math.abs(xIndex-j) == Math.abs(x[xIndex]-x[j])) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				nQueen(xIndex+1); // 동일위치, 대각선 검사 통과 하면 다음 열 검사 (오른쪽 가로로 한칸 이동)
			}

		}

	}

}
