package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6603 {
    static int N;
    static int[] S;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        //숫자 K 입력
        //k만큼 숫자 배열S에 입력
        //반복하며 출력
        //0입력시 종료
        //s에 입력된 숫자 중 6개를 뽑아 만들 수 있는 값을 나열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N==0)
                break;

            visited = new boolean[N];
            S = new int[N];

            for(int i=0; i<N; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0, 0);
            System.out.println();
        }

    }
    public static void lotto(int idx, int cnt){
        if(cnt == 6){
            for(int i=0; i<S.length; i++){
                if(visited[i]){ //로또번호를 뽑은거만 출력
                    System.out.print(S[i]+ " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i=idx; i<N; i++){
            if(visited[i])
                continue;
            visited[i] = true; //로또 번호를 뽑았다면
            lotto(i+1, cnt+1);
            visited[i] = false;
        }
    }
}
