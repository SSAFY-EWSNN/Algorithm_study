package Baekjoon_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final String vowels = "aeiou";
    static int L, C;
    static char output[];
    static boolean visited[];
    static char[] chars;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] LC = in.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);

        output = new char[C];
        visited = new boolean[C];
        chars = new char[C];

        String[] chs = in.readLine().split(" ");
        for(int i = 0; i < chs.length; i++){
            chars[i] = chs[i].charAt(0);
        }

        Arrays.sort(chars);

        comb(0, L);

        System.out.print(sb);
    }
    public static void comb(int cnt, int r){
        if(r == 0) {
            String res = "";
            int v = 0;
            int c = 0;
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    res += output[i];
                }
            }
            for(int i = 0; i < res.length(); i++){
                switch(res.charAt(i)){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        v++;
                        break;
                    default:
                        c++;
                        break;
                }
            }
            if(v >= 1 && c >= 2){
                sb.append(res).append("\n");
            }
        }
        // 유도조건
        for(int i = cnt; i < C; i++){
            visited[i] = true;
            output[i] = chars[i];
            comb(i+1, r-1);
            visited[i] = false;
        }
    }
}
