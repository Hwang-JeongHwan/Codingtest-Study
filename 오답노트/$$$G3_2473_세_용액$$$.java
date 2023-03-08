package 오답노트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2473
public class $$$G3_2473_세_용액$$$ {
    static FastReader scan = new FastReader();
    static int n;
    static long[]arr;
    static long[] pick = new long[3];
    static long max = 3000000000L;
    static void input(){
        n = scan.nextInt();
        arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextLong();
        }


    }
    static void solution(){
        for(int i = 0; i < n - 2; i++){
            determination(i);
        }
        Arrays.sort(pick);
        for(int i = 0; i < 3; i++){
            System.out.print(pick[i] + " ");
        }
    }
    static void determination(int index) {
        Arrays.sort(arr);

        int left = index+1;
        int right = arr.length-1;

        while(left < right) {

            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(sum);

            // 두 용액 갱신
            if(absSum < max) {
                pick[0] = arr[left];
                pick[1] = arr[right];
                pick[2] = arr[index];
                max = absSum;
            }

            if(sum > 0)
                right--;
            else
                left++;
        }


    }

    public static void main(String[] args) {
        input();
        solution();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
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
    }
}

