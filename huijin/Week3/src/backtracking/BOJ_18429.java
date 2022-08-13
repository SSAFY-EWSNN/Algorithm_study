package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


//근손실, 순열
public class BOJ_18429 {
	private static int N;
	private static int K;
	private static int[] arr;
	private static int[] numbers;
	private static boolean[] visited;
	private static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		str= br.readLine().split(" ");
		arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		numbers = new int[N];
		visited = new boolean[N];
		perm(0,500);
		System.out.println(answer);
	}
	
	public static void perm(int now, int weight) {
		if(now==N) {
			answer++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				int a = weight -K+arr[i];
				if(a>=500) {
					visited[i]=true;
					numbers[now]=arr[i];
					perm(now+1,a);
					visited[i]=false;		
				}
			}
		}
	}
}
