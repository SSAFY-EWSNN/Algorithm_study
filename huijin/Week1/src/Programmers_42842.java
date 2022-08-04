
//카펫. 직사각형의 테두리 1줄은 갈색이고 , 중앙은 노란색으로 칠해져 있음.
//노란색과 갈색의 개수만 주어졌을 때, 카펫의 가로,세로 길이를 구해라
public class Programmers_42842 {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        //테두리 1줄 -> 갈색. 가운데 -> 노란색
        
        for(int i=2;i<=Math.sqrt(total);i++){
            if(total % i == 0){
                int row = i;
                int col = total/i;
                
                //갈색 개수 구하기
                int b_cnt = (row)*2 + (col-2)*2;
                
                if(brown==b_cnt){
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
            
            
        }
        
        
        return answer;
    }

}
