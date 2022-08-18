package Programmers.src.exhaustive_search;

public class P86491 {

	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes));
		
		
		
	}
	
	 static int solution(int[][] sizes) {
	        int answer = 0;
	        for(int i =0; i<sizes.length;i++) {
	        	for(int j =0; j<1; j++) {
	        		if(sizes[i][j] < sizes[i][j+1]) {
	        			int temp = sizes[i][j];
	        			sizes[i][j] = sizes[i][j+1];
	        			sizes[i][j+1] = temp;
	        		}
	        	}
	        }
	        
	        int maxW = 0;
	        int maxH = 0;
	        
	        for(int i =0; i<sizes.length;i++) {
	        	for(int j=0; j<2; j++) {
	        		if(j==0) maxW = Math.max(maxW, sizes[i][j]);
	        		else maxH = Math.max(maxH, sizes[i][j]);
	        	}
	        }
	        
	        answer = maxH * maxW;
	        
	        return answer;
	    }
	

}
