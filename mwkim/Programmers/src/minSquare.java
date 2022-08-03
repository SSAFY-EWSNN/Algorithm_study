class Solution {
    public static int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i = 0; i < sizes.length; i++){
            //swap
            if(sizes[i][1] > sizes[i][0]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            } 
        }
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < sizes.length; i++){
            wMax = Math.max(wMax, sizes[i][0]);
            hMax = Math.max(hMax, sizes[i][1]);
        }
        
        answer = wMax*hMax;
        
        return answer;
    }
  
    public static void main(String[] args){
        int sizes[][][] = {{{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                           {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                           {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}};
        for(int i = 0; i < sizes.length; i++){
          System.out.println(solution(sizes[i]));
        }
    }
}
