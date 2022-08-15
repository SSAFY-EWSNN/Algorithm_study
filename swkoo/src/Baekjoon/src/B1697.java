package Baekjoon.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1697 {
    // 백준 숨바꼭질

    static int N,K;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int n = 100000;
        visited = new int[n+1];

        q = new ArrayDeque<>();
        
        sb.append(bfs(N));
        System.out.println(sb.toString());
    }

    static int bfs(int start) {
        q.offer(start);
        visited[start] = 1;
        while(!q.isEmpty()){
            int n = q.poll();
            if(n == K) {
                return visited[n]-1; // 문제는 0초 부터 시작이지만 1초 부터 시작했기 때문에 -1
            }

            if(n-1>=0 && visited[n-1] ==0) {
                visited[n-1] = visited[n]+1;
                q.offer(n-1);
            }

            if(n+1<=100000 && visited[n+1] == 0) {
                visited[n+1] = visited[n]+1;
                q.offer(n+1);
            }

            if(n*2 <= 100000 && visited[n*2] == 0) {
                visited[n*2] = visited[n]+1;
                q.offer(n*2);
            }
        }
        return -1;
    }
}
