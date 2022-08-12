package Baekjoon_15757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과 출력을 위한 스트링빌더 생성.
		StringBuilder sb = new StringBuilder();
		String[] vals = in.readLine().split(" ");

		String val1 = vals[0];
		String val2 = vals[1];

		while(val1.length() != val2.length()) {
			if(val1.length() > val2.length()) {
				val2 = "0"+val2;
			} else {
				val1 = "0"+val1;
			}
		}

		int lastIdx = val1.length();

		int up = 0;
		int[] resArr = new int[lastIdx+1];

		for(int idx = lastIdx-1; idx >= 0; idx--) {
			int v = Character.getNumericValue(val1.charAt(idx)) + Character.getNumericValue(val2.charAt(idx)) + up;
			up = v / 10;
			resArr[idx+1] = v % 10;
		}
		if(up >= 1) {
			System.out.print(up);
		}

		for(int i = 1; i < lastIdx+1; i++) {
		
			System.out.print(resArr[i]);
		}
	}
}
