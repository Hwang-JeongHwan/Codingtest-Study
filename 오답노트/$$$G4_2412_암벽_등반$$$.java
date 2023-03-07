package 오답노트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class $$$G4_2412_암벽_등반$$$ {
    static FastReader scan = new FastReader();
    static int n, T;
    static Point[] arr;
    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void input(){
        n = scan.nextInt();
        T = scan.nextInt();
        arr = new Point[n];
        int x, y = 0;
        for(int i = 0; i < n; i++){
            x = scan.nextInt();
            y = scan.nextInt();
            arr[i] = new Point(x, y);
        }
    }
    static int determination(int a, int b){
        int count = 0;
        for(Point check : arr){
            if(Math.abs(a - check.x) <= 2 && Math.abs(b - check.y) <= 2){
                count++;
                a = check.x;
                b = check.y;

            }
            if(b == T){
                break;
            }
        }
        if(count > 0){
            return count;
        }
        else{
            return -1;
        }
    }
    static void solution(){
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
            else {
                return o1.y - o2.y;
            }
        });
        for(Point check : arr){
            System.out.println("x : " + check.x + " y : " + check.y);
        }
        System.out.println(determination(0, 0));
        // Math.abs(a - check.x) <= 2 && Math.abs(b - check.y) <= 2인것중에 최대값으로 이동

    }
    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    this.st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
