package Baekjoon.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15652 {
	// N과 M(4) 중복조합
	static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		
		dupComb(0,1);
		
		System.out.println(sb.toString());
	}
	
	private static void dupComb(int count, int start) {
		if(count == M) {
			for(int a:numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i =start; i<=N; i++) {
			numbers[count] = i;
			dupComb(count+1, i);
		}
	}
}
