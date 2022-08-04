package com.programmers.BruteForce;

class Programmers_8649 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int temp;
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0]>sizes[i][1]){
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int max1 = 0;
        int max2 = 0;
        for(int i=0; i<sizes.length; i++) {
            if (sizes[i][0] > max1) {
                max1 = sizes[i][0];
            }
        }
        for(int i=0; i<sizes.length; i++) {
            if (sizes[i][1] > max2) {
                max2 = sizes[i][1];
            }
        }
        
        return max1 * max2;
    }
}