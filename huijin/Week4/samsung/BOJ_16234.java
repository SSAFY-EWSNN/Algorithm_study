package samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

//인구 이동
public class BOJ_16234 {
	private static int[] dir_x = {-1,0,1,0};
	private static int[] dir_y = {0,-1,0,1};
	private static int[][] map;
	private static int N, L, R;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<N;j++)map[i][j]=Integer.parseInt(str[j]);
		}
		
		boolean flag = true;
		while(flag) {			
			visited= new boolean[N][N];
			
			flag = false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						flag = flag|bfs(i,j);
					}
				}
			}
			if(flag)answer+=1;
		}
		
		System.out.println(answer);
	}
	
	public static boolean bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		Queue<int[]> total = new ArrayDeque<int[]>();
		int sum=0;
		
		
		queue.add(new int[] {x,y});
		total.add(new int[] {x,y});
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			int[] a = queue.poll();
						
			sum+=map[a[0]][a[1]];
			
			for(int i=0;i<4;i++) {
				int dx = a[0]+dir_x[i];
				int dy = a[1]+dir_y[i];
				
				if(dx<0||dx>=N||dy<0||dy>=N)continue;
				if(visited[dx][dy])continue; //이미 방문했으면 다음
				
				int c = Math.abs(map[a[0]][a[1]]-map[dx][dy]);
				if(c>=L && c<=R) {
					queue.add(new int[] {dx,dy});
					total.add(new int[] {dx,dy});
					visited[dx][dy]=true;
				}
			}
		}
		
		if(total.size()==1)return false;
		
		int avg = sum / total.size();

		while(!total.isEmpty()) {
			int[] a = total.poll();
			
			map[a[0]][a[1]]=avg;
		}
		return true;
	}
}
