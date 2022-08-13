package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2251 {
	private static int A,B,C;
	private static boolean[] C_water;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		A = Integer.parseInt(str[0]);
		B = Integer.parseInt(str[1]);
		C = Integer.parseInt(str[2]);
		
		C_water = new boolean[C+1];
		
		//B, C 물에 대해서만 체크

		bfs(0,0,C);
		//C에만 물이 있다. (가득)
		//다른 물통으로 옮길 때 가득 차거나 물통이 빌 때까지 물을 부을 수 있다.
		//첫번째 물통이 비어있을 때, 세번째 물통에 담겨있을 수 있는 물의 양 모두 구하기
		
		for(int i=0;i<C+1;i++) {
			if(C_water[i])sb.append(i+" ");
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(int a, int b, int c) {
		int a1=0;int b1=0; int c1=0;
		//b,c 물 양에 대해 방문했는지 확인 (b,c 가정해지면 a도 자동으로 정해진다)
		boolean[][] visited = new boolean[B+1][C+1];
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		//0 : A, 1 : B, 2 : C 
		
		queue.add(new int[] {a,b,c});
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			if(p[0]==0) {
				C_water[p[2]]=true;
			}
			
			//a가 비어있지 않을 때, b, c한테 물주기
			if(p[0]!=0) {
				//b한테 물주기
				
				a1=(p[0]+p[1]<=B)?0:p[0]+p[1]-B;
				b1=(p[0]+p[1]<=B)?p[0]+p[1]:B;
				
				if(!visited[b1][p[2]]) {
					visited[b1][p[2]]=true;
					queue.add(new int[] {a1,b1,p[2]});
				}
				
				//c한테 물주기
				a1=(p[0]+p[2]<=C)?0:p[0]+p[2]-C;
				c1=(p[0]+p[2]<=C)?p[2]+p[0]:C;
				
				if(!visited[p[1]][c1]) {
					visited[p[1]][c1]=true;
					queue.add(new int[] {a1,p[1],c1});
				}
			}
			
			//b가 비어있지 않을 때, a, c 한테 물주기
			if(p[1]!=0) {
				//b가 a한테 물주기
				a1=(p[1]+p[0]<=A)?p[1]+p[0]:A;
				b1=(p[1]+p[0]<=A)?0:p[1]+p[0]-A;
				
				if(!visited[b1][p[2]]) {
					visited[b1][p[2]]=true;
					queue.add(new int[] {a1,b1,p[2]});
				}
				
				
				//b가 c한테 물주기
				b1=(p[1]+p[2]<=C)?0:p[1]+p[2]-C;
				c1=(p[1]+p[2]<=C)?p[2]+p[1]:C;

				if(!visited[b1][c1]) {
					visited[b1][c1]=true;
					queue.add(new int[] {p[0],b1,c1});
				}
			}
			
			//c가 비어있지 않을 때, a,b 한테 물주기
			if(p[2]!=0) {
				//c가 a한테 물주기
				a1=(p[2]+p[0]<=A)?(p[0]+p[2]):A;
				c1=(p[2]+p[0]<=A)?0:p[0]+p[2]-A;
				
				if(!visited[p[1]][c1]) {
					visited[p[1]][c1]=true;
					queue.add(new int[] {a1,p[1],c1});
				}
				
				//c가 b한테 물주기
				b1=(p[2]+p[1]<=B)?(p[1]+p[2]):B;
				c1=(p[2]+p[1]<=B)?0:p[2]+p[1]-B;
				
				if(!visited[b1][c1]) {
					visited[b1][c1]=true;
					queue.add(new int[] {p[0],b1,c1});
				}
				
			}
			
		}
	}
}
