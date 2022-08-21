import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<int[][]> list = new ArrayList<>();
        int[][] arr = {{1,2,3},{4,5,6}};
        list.add(arr);
        list.get(0)[0][0] = 200;
        for(int i=0; i<10; i++) {
            list.get(0)[0][0] += 1;
        }
        System.out.println(list.get(0)[0][0]);
    }
}
