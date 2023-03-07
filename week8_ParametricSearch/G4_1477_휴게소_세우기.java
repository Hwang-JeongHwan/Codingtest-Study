package week8_ParametricSearch;
// https://www.acmicpc.net/problem/1477
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1477_휴게소_세우기 {
    static class Node{
        int before;
        int now;
        int value;
        public Node(int before, int now, int value){
            this.before = before;
            this.now = now;
            this.value = value;
        }
    }
    static FastReader scan = new FastReader();
    static int[] arr;
    static int n, m, l;
    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        l = scan.nextInt();
        arr = new int [n + 2];
        for(int i = 1; i <= n; i++){
            arr[i] = scan.nextInt();
        }
        arr[n + 1] = l;

    }
    static boolean determination(int distance){
        // distance일때 몇개의 휴게소를 지을 수 있는지 확인
        int total = 0;
        for(int i = 1; i <= n + 1; i++){
            total += (arr[i] - arr[i - 1] - 1) / distance;
        }
        return total > m;
    }
    static void solution(){
        Arrays.sort(arr);
        int left = 1, right = l - 1, mid = 0, result = 0;
        while(left <= right){
            mid = (left + right) / 2;
            System.out.println("before left : " + left + " right : " + right + " mid : " + mid);
            if(determination(mid)){
                // m개 보다 많이 지을수 있으면 mid값을 증가 시키기 위해 left를 옮김
                left = mid + 1;
            }
            else{
                // m개 보다 많이 지을수 없으면 mid값을 감소시키기 위해 right를 옮김
                right = mid - 1;
            }
            System.out.println("after  left : " + left + " right : " + right + " mid : " + mid);
       }
        // 새로운 휴게소의 최소 간격이 되도록 이분탐색을 수행 ==> 최대값의 최소값 ==> left 출력
        System.out.println(left);
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
                try{
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
        long nextLong(){
            return Long.parseLong(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}

/*
before left : 1 right : 999 mid : 500
after  left : 1 right : 499 mid : 500
before left : 1 right : 499 mid : 250
after  left : 251 right : 499 mid : 250
before left : 251 right : 499 mid : 375
after  left : 251 right : 374 mid : 375
before left : 251 right : 374 mid : 312
after  left : 251 right : 311 mid : 312
before left : 251 right : 311 mid : 281
after  left : 251 right : 280 mid : 281
before left : 251 right : 280 mid : 265
after  left : 251 right : 264 mid : 265
before left : 251 right : 264 mid : 257
after  left : 251 right : 256 mid : 257
before left : 251 right : 256 mid : 253
after  left : 251 right : 252 mid : 253
before left : 251 right : 252 mid : 251
after  left : 251 right : 250 mid : 251


before left : 1 right : 999 mid : 500
after  left : 1 right : 499 mid : 500
before left : 1 right : 499 mid : 250
after  left : 251 right : 499 mid : 250
before left : 251 right : 499 mid : 375
after  left : 251 right : 374 mid : 375
before left : 251 right : 374 mid : 312
after  left : 251 right : 311 mid : 312
before left : 251 right : 311 mid : 281
after  left : 282 right : 311 mid : 281
before left : 282 right : 311 mid : 296
after  left : 297 right : 311 mid : 296
before left : 297 right : 311 mid : 304
after  left : 297 right : 303 mid : 304
before left : 297 right : 303 mid : 300
after  left : 297 right : 299 mid : 300
before left : 297 right : 299 mid : 298
after  left : 299 right : 299 mid : 298
before left : 299 right : 299 mid : 299
after  left : 300 right : 299 mid : 299
 */