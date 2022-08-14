package Baekjoon_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Egg{
    int S;
    int W;
    Egg(int S, int W){
        this.S = S;
        this.W = W;
    }
}
public class Main {
    static Egg[] eggs;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        eggs = new Egg[N];

        for(int i = 0; i < N; i++) {
            String[] SW = in.readLine().split(" ");
            int S = Integer.parseInt(SW[0]);
            int W = Integer.parseInt(SW[1]);
            eggs[i] = new Egg(S, W);
        }
        comb(0, 0);

        System.out.println(max);
    }
    public static void comb(int idx, int cnt){
        if(idx == N) {
            max = Math.max(max, cnt);
            return;
        }

        // 모든 계란 탐색이 끝나지 않았으면 소스코드의 아랫부분을 진행한다.
        // 체력이 적거나, cnt 가 1개있으면 다음 진행
        Egg ea = eggs[idx];
        if(ea.S <= 0 || cnt == N-1) {
            comb(idx+1, cnt);
            return;
        }

        int now_cnt = cnt;
        for(int i = 0; i < N; i++) {
            // 현재 쥐고 있는 계란이랑 동일하면 continue;
            if(i == idx) continue;
            Egg eb = eggs[i];
            // 다음 쥘 계란이 깨져있으면 continue;
            if(eb.S <= 0) continue;

            ea.S -= eb.W;
            eb.S -= ea.W;

            if(ea.S <= 0) {
                cnt++;
            }

            if(eb.S <= 0) {
                cnt++;
            }

            comb(idx+1, cnt);

            // 반복문을 실행하기 위해서 다시 정보를 복구해준다.
            cnt = now_cnt;
            ea.S += eb.W;
            eb.S += ea.W;
        }

    }

}
