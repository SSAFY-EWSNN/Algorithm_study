package Baekjoon_24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N, M, cnt;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] NMnum = in.readLine().split(" ");
        N = Integer.parseInt(NMnum[0]);
        M = Integer.parseInt(NMnum[1]);
        int R = Integer.parseInt(NMnum[2]);

        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String[] UV = in.readLine().split(" ");
            int U = Integer.parseInt(UV[0]);
            int V = Integer.parseInt(UV[1]);
            graph.get(U).add(V);
            graph.get(V).add(U);
        }
        for(int i = 0; i < M; i++){
            Collections.sort(graph.get(i));
        }

        cnt = 1;

        visited = new int[N+1];
        dfs(R);
        for(int i=1;i<visited.length;i++){
            System.out.println(visited[i]);
        }
    }

    static void dfs(int x){
        visited[x] = cnt;
        for(int i=0;i<graph.get(x).size();i++){
            //연결된 노드
            int y = graph.get(x).get(i);
            //방문을 안했을 경우
            if(visited[y]==0){
                //순차 증가
                cnt++;
                //dfs 실행
                dfs(y);
            }
        }
    }
}
