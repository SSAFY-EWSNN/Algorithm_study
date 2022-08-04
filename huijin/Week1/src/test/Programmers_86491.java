package test;

//프로그래머스 최소 직사각형
public class Programmers_86491 {
	public int solution(int[][] sizes) {
        int answer = 0;
        //int row=0; int col = 0;
        
        //세로, 가로 중 하나는 무조건 모든 값들의 최대값
        int max=0;
        int min_max=0; //둘 중 최솟값들 중 최댓값 (?)
        int min=0;
        
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>max) max=sizes[i][0];
            if(sizes[i][1]>max) max=sizes[i][1];
            min = Math.min(sizes[i][0],sizes[i][1]);
            
            if(min>min_max)min_max=min;
        }
        
        return min_max*max;
    }
}
