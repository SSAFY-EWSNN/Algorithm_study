package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

//이모티콘
public class BOJ_14226 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		

		System.out.println(bfs(S));
	}
	
	public static int bfs(int n) {
		int answer=0;
		boolean[][] visited = new boolean[5000][5000];
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {1,0,0}); //현재 이모티곤 개수, 클립보드의 개수, 걸린 시간
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
			
			if(visited[a[0]][a[1]])continue;
			
			visited[a[0]][a[1]]=true;
			
			if(a[0]==n) {
				answer=a[2];
				break;
			}
			
			if(a[0]>=1) {
				queue.add(new int[] {a[0],a[0],a[2]+1});
				queue.add(new int[] {a[0]-1,a[1],a[2]+1});
			}
			
			if(a[1]>0) {
				queue.add(new int[] {a[0]+a[1],a[1],a[2]+1});
			}
		}
		
		return answer;
	}
}
