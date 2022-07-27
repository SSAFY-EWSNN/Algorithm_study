package dfs;

import java.util.Stack;

public class DFS_Stack {
	// 방문처리에 사용 할 배열 선언.
	static boolean[] visited = new boolean[9];
	
	// 예시를 2차원으로 표현.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, 
			{2}, {4,5}, {1,2}};
	
	// DFS를 사용할 스택.
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		// 시작 노드를 스택에 삽입.
		stack.push(1);
		
		// 시작 노드를 방문처리.
		visited[1] = true;
		
		// 스택이 비어있지 않으면 계속 반복.
		while(!stack.isEmpty()) {
			
			// 스택에서 하나를 꺼냄.
			int nodeIdx = stack.pop();
			
			// 방문 노드 출력.
			System.out.print(nodeIdx + "->");
			
			// 꺼낸 노드와 인접한 노드 찾기.
			for(int linkedNode : graph[nodeIdx]) {
				// 해당 노드를 방문 안했다면.
				if(!visited[linkedNode]) {
					stack.push(linkedNode);
					visited[linkedNode] = true;
				}
			}
		}
	}
}
