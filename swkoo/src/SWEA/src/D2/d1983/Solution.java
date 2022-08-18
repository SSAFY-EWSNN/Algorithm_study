package SWEA.src.D2.d1983;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	// 조교의 성적 매기기
	
	static ArrayList<Student> studentList = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input_1983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		

		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d ", tc);
			studentList.clear();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Student student = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
				student.setTotal();
				studentList.add(student);
			}
			
			Student target = studentList.get(K - 1);
			target.setTarget(true);
			

			
			studentList.sort(Comparator.comparing(Student::getTotal));
			Collections.reverse(studentList);
			
//			for(Student s:studentList) {
//				System.out.println(s.getTotal());
//			}
			int rankIndex = studentList.indexOf(target);
			int res = rankIndex/(N/10);

			System.out.println(grade[res]);

		}
	}

	static class Student {
		int mid;
		int last;
		int hw;
		double total;
		boolean isTarget;

		public Student(int mid, int last, int hw) {
			this.mid = mid;
			this.last = last;
			this.hw = hw;
			this.isTarget = false;
		}

		public void setTotal() {
			this.total = mid * 0.35 + last * 0.45 + hw * 0.2;
		}

		public boolean isTarget() {
			return isTarget;
		}

		public void setTarget(boolean isTarget) {
			this.isTarget = isTarget;
		}

		public double getTotal() {
			return total;
		}

		public int getMid() {
			return mid;
		}

		public int getLast() {
			return last;
		}

		public int getHw() {
			return hw;
		}

	}
}
