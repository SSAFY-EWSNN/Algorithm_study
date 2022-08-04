
//프로그래머스 소수찾기. 순열 조합 + 소수 찾기
public class Programmers_42839 {
	static boolean check[] = new boolean[10000000];
    static int num = 0;
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited;
        char[] out;
        
        for(int i=1;i<=numbers.length();i++){
            visited = new boolean[numbers.length()];
            out = new char[i];
            permutation(numbers, out, visited, 0, i);
            
        }
        return num;
    }
    
    public void permutation(String numbers, char[] out, boolean[] visited, int depth, int r){
        if(depth == r){
            //소수인지 체크
            
            String str = new String(out);
            
            int c = Integer.parseInt(str);
            
            if(sosu(c) && check[c]==false){
                num++;    
                check[c]=true;
            }
            return;    
        }
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                if(depth==0&&numbers.charAt(i)=='0')continue;
                
                visited[i]=true;
                out[depth]=numbers.charAt(i);
                permutation(numbers,out,visited, depth+1,r);
                visited[i]=false; //다시 다음 순열을 찾기 위해 false
            }
        }
        
    }
    
    public boolean sosu(int num){
        if(num<2)return false;
        if(num==2)return true;
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }

        return true;
    }
    

}
