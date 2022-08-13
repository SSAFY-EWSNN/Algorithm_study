package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_1697 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		System.out.println(bfs(N,K));
		
	}
	public static int bfs(int n, int k) {
		int answer=-1;
		//int[2] 를 큐에 넣을 것임. {현재 위치, 현재까지 걸린 시간}
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[] visited= new boolean[100001];
		
		visited[n]=true; //n 위치는 true로
		queue.add(new int[] {n,0}); //시작점 큐에 넣어주기
		
		while(!queue.isEmpty()) {
			int[] a=queue.poll();
			
			//목표지점에 도달하면 break
			if(a[0]==k) {
				answer=a[1];
				break;
			}
			
			if(a[0]-1>=0 && !visited[a[0]-1]) {
				visited[a[0]-1]=true;
				queue.add(new int[] {a[0]-1,a[1]+1});
			}
			if(a[0]+1<visited.length && !visited[a[0]+1]) {
				visited[a[0]+1]=true;
				queue.add(new int[] {a[0]+1,a[1]+1});
			}
			if(a[0]*2<visited.length && !visited[a[0]*2]) {
				visited[a[0]*2]=true;
				queue.add(new int[] {a[0]*2,a[1]+1});
			}
		}
		return answer;
	}
}
