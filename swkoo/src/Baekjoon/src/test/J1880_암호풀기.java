package Baekjoon.src.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class J1880_암호풀기 {
    public static void main(String[] args) throws IOException {

        //System.setIn(Files.newInputStream(Paths.get("swkoo/src/Baekjoon/src/test/input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] key = br.readLine().toCharArray();

        // a = 97, A = 65

        char[] str = br.readLine().toCharArray();
        for (char c : str) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }
            if (c < 97) {
                c += 32;
                sb.append((char) (key[c - 97] - 32));
                continue;
            }
            sb.append((key[c - 97]));

        }
        System.out.println(sb);
    }
}
