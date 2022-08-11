package Baekjoon_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int K = 0;
	static int[] S;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			// 한 줄을 읽는다.
			String[] nextLine = in.readLine().split(" ");
			// 한 줄을 읽은 것 중 제일 앞에 있는 것이 K.
			K = Integer.parseInt(nextLine[0]);
			// 만약 K가 0이라면 문제 종료.
			if(K == 0) {
				break;
			}
			
			// 그 다음 S배열의 크기 K로 선언.
			S = new int[K];
			// 조합을 위해 생성한다.
			visited = new boolean[K];
			sb = new StringBuilder();
			
			// S배열의 크기 K만큼 내용 받음.
			for(int i = 1; i <= K; i++) {
				S[i-1] = Integer.parseInt(nextLine[i]);
			}
			// 조합. (순서가 상관없는 케이스.)
			comb(visited, 0, K, 6);
			System.out.println(sb);
		}
	}
	
	//////////////////////////////
	// visited : 배열 방문 여부.    //
	// start : 현재 탐색중인 인덱스     //
	// n, r : nCr               //
	//////////////////////////////
	
	public static void comb(boolean[] visited, int start, int n, int r) {
		// 더 이상 뽑을 내용이 없을 때.
		if(r == 0) {
			// 방문한 i들을 모두 출력.
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					sb.append(S[i]+" ");
				}
			}
			sb.append("\n");
			return;
		}
		
		// 0번 인덱스 부터 탐색 시작.
		for(int i = start; i < n; i++) {
			// 0번 인덱스를 true로.
			visited[i] = true;
			// 그 다음 숫자 뽑음.
			comb(visited, i+1, n, r-1);
			// 끝나면 visited는 false 처리.
			visited[i] = false;
		}
	}
}
