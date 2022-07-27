package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Queue {
	// 그림 예시 출력
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	// 방문노드 처리
	static boolean[] visited = new boolean[9];
	// 큐 생성.
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		bfs(1);
	}
	
	static void bfs(int nodeIdx) {
		// 큐에 노드 삽입.
		queue.offer(nodeIdx);
		
		// 시작 노드 방문 처리.
		visited[nodeIdx] = true;
		
		// 큐가 빌때까지 반복.
		while(!queue.isEmpty()) {
			// 큐에서 하나 꺼냄.
			int root = queue.poll();
			System.out.print(root + "->");
			
			for(int node: graph[root]) {
				if(!visited[node]) {
					visited[node] = true;
					queue.offer(node);
				}
			}
			
		}
	
	}
}
