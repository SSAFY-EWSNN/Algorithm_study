package com.programmers.BruteForce;

import java.util.ArrayList;

public class Programmers_42840 {
	public int[] solution(int[] answers) {
        int array[][] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] answer = new int[3];
        for (int i=0; i<answers.length; i++) {
            if (array[0][i%array[0].length] == answers[i]) answer[0]++;
            if (array[1][i%array[1].length] == answers[i]) answer[1]++;
            if (array[2][i%array[2].length] == answers[i]) answer[2]++;
        }

        int maxAnswer = Math.max(answer[0], Math.max(answer[1], answer[2]));

        ArrayList<Integer> list = new ArrayList<>();
        if(maxAnswer == answer[0]) list.add(1);
        if(maxAnswer == answer[1]) list.add(2);
        if(maxAnswer == answer[2]) list.add(3);

        int[] ans = new int[list.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
