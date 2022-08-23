import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int weight;
	static int K;
	static int N;
	static int[] exercise;
	static int[] output;
	static int count = 0;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과 출력을 위한 스트링빌더 생성.
		StringBuilder sb = new StringBuilder();
		
		String[] NK = in.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		
		exercise = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			exercise[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		output = new int[N];
		perm(0);
		System.out.println(count);
	}
	public static void perm(int cnt) {
		if(cnt == N) {
			weight = 500;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					weight += output[i] - K;
					if(weight < 500) {
						return;
					}
				}
			}
			if(weight >= 500) {
				count++;
			}
			return;
		}
		// 유도 조건
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			output[cnt] = exercise[i];
			perm(cnt+1);
			visited[i] = false;
			
		}
	}
}
