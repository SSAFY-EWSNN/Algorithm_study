import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static int[] output;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = in.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[] output = new int[N];
		int[] arr = new int[N];
		visited = new boolean[N];

		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		permultation(arr, output, visited, 0, N, M);
		System.out.println(sb);
	}

	public static void permultation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		// depth는 현재 몇개 뽑았는지
		if(depth == r) {
			//출력
			for(int i = 0; i < r; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permultation(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

}
