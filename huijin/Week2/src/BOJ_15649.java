import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649 {
	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	private static boolean[] visited;
	private static int[] numbers;
	private static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력받기
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr =new int[N]; //1~N까지 저장하는 배열
		visited = new boolean[N]; //방문했는지 여부 확인
		numbers = new int[M]; //수열 저장값
		for(int i=1;i<=N;i++)arr[i-1]=i; //1~N 까지 배열에 넣어주기
		
		//순열 구하는 함수 호출
		perm(0);
		
		//출력
		System.out.println(sb);
	}
	static void perm(int now) {
		//M까지 수열을 뽑으면, 수열을 저장한 numbers 배열을 출력한다.
		if(now==M) {
			for(int a:numbers)sb.append(a+" ");
			sb.append("\n");
			return;
		}
		//아직 M까지 수열을 다 못뽑았다면 다음에 들어갈 수 있는 수 넣어주기
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				numbers[now]=arr[i];
				perm(now+1);
				visited[i]=false; //다시 돌아오기
			}
		}
	}
}
