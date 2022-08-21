package Baekjoon.src.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B20361_일우는야바위꾼 {
    static int N,X,K;
    static boolean[] array;
    static List<int[]> tern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new boolean[N+1];
        tern = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            array[i] = false;
        }

        array[X] = true;

        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            tern.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        for(int i=0; i<K; i++) {
            int[] cur = tern.get(i);
            swap(cur[0], cur[1]);
        }

        for(int i=1; i<=N; i++) {
            if(array[i]) sb.append(i);
        }

        System.out.println(sb);

    }

    static void swap(int a, int b) {
        boolean temp = false;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
