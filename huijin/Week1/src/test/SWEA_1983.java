package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//조교의 성적매기기
public class SWEA_1983 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		String[] str;
		String[] name = {"D0","C-","C0","C+","B-","B0","B+","A-","A0","A+"};

		for(int t=1;t<=T;t++) {
			int answer=0;
			str=br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			
			int k = Integer.parseInt(str[1]); //k번째 학생의 학점 출력
			int[]student = new int[n];
			
			
			//학생의 중간, 기말, 과제 점수
			for(int i=0;i<n;i++) {
				str=br.readLine().split(" ");
				//학생의 최종점수
				student[i] =(Integer.parseInt(str[0])*35+Integer.parseInt(str[1])*45 +Integer.parseInt(str[2])*20);
			}
		
			int k_score=student[k-1]; //k번째 학생의 점수
			
			Arrays.sort(student);
			
			// 학생수/10 = 2이면 2명씩 한 점수
			// 0,1 / 2,3 / 4,5 .. 씩 받을 수 있다.
			
			for(int i=n-1;i>=0;i--) {
				if(student[i]==k_score) {
					answer=i;
					break;
				}
			}
			System.out.println("#"+t+" "+name[answer/(n/10)]);
			
		}
	}

}
