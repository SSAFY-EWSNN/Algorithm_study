package dfs;

public class DFS_Recursive {
	// 방문한 노드를 체크할 때 사용.
	static boolean[] visited = new boolean[9];

	// 예시를 2차원으로 변환
	// 이해하기 쉽게 1번부터 idx 시작.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, 
			{2}, {4,5}, {1,2}};
	
	public static void main(String[] args) {
		dfs(1);
	}
	
	static void dfs(int nodeIndex) {
		// 루트 노드를 방문처리.
		visited[nodeIndex] = true;
		
		// 방문 노드 출력
		System.out.print(nodeIndex + "->");
		
		// 인접한 노드를 루트 인덱스로.
		for(int node : graph[nodeIndex]) {
			// 노드를 방문한 적 없을 때.
			if(!visited[node]) {
				// 해당 노드를 루트 노드로 방문.
				dfs(node);
			}
		}
		
	}
}
