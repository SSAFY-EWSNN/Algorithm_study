package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] kg = new int [N];
        int[] cm = new int [N];

        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            kg[i] = Integer.parseInt(line[0]);
            cm[i] = Integer.parseInt(line[1]);
        }
        for(int i=0; i<N; i++){
            int res = 1;
            for(int j=0; j<N; j++){
                if(i==j) continue;
                else if(kg[i]<kg[j] && cm[i]<cm[j]){
                    res ++;
                }
            }
            System.out.print(res+" ");
        }
    }
}
