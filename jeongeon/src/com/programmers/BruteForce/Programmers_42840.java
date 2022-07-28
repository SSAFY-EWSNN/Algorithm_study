package com.programmers.BruteForce;

public class Programmers_42840 {
	public int[] solution(int[] answers) {
        int[] answer = {};
        int array[][] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int ans1 = 0, ans2=0, ans3=0;
        for (int i=0; i<(answers.length); i++) {
            if (array[0][i%array[0].length] == answers[i]) ans1++;
            else if (array[1][i%array[1].length] == answers[i]) ans2++;
            else if (array[2][i%array[2].length] == answers[i]) ans3++;
        }
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        return answer;
    }
}
