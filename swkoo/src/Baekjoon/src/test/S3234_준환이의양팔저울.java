package Baekjoon.src.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3234_준환이의양팔저울 {

    static int[] weight;
    static int[] numbers;
    static boolean[] visited;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("swkoo/src/Baekjoon/src/simulation/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            weight = new int[N];
            visited = new boolean[N];
            numbers = new int[N];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            perm(0);
            sb.append("#").append(tc).append(" ");
            sb.append(ans).append("\n");
        }

        System.out.println(sb);

    }

    static void perm(int count) {
        if(count == N) {
//            System.out.println(Arrays.toString(numbers));
            subset(0,0,0);
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            numbers[count] = weight[i];
            perm(count+1);
            visited[i] = false;
        }
    }

    static void subset(int index, int left, int right) {
        if(index==N) {
            ans++;
            return;
        }

        if(left >= numbers[index]+right) {
            subset(index+1, left, right+numbers[index]);
        }

        subset(index+1, left+numbers[index], right);


    }

}
