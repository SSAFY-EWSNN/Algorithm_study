package bruteforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1983 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/Users/seulgi/SSAFY/study/algorithmStudy/seulgi/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            String[] line1 = br.readLine().split(" ");
            int N = Integer.parseInt(line1[0]);
            int K = Integer.parseInt(line1[1]);
            double[] score = new double[N];
            double kScore;

            for(int i=0; i<N; i++){
                String[] scoreLine = br.readLine().split(" ");
                int midExam = Integer.parseInt(scoreLine[0]);
                int finalExam = Integer.parseInt(scoreLine[1]);
                int project = Integer.parseInt(scoreLine[2]);

                score[i] = (midExam*0.35 + finalExam * 0.45 + project * 0.2);
            }
            kScore = score[K-1];
            Arrays.sort(score);

            int kIdx = 0;
            for (int i=0; i<N; i++){
                if(score[i] == kScore){
                    kIdx = i;
                    break;
                }
            }
            int res = kIdx/(N/10);
            System.out.println("#"+tc+" "+grade[res]);
        }
    }
}