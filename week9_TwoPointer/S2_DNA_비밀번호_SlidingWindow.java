package week9_TwoPointer;
import java.io.*;
import java.util.*;
public class S2_DNA_비밀번호_SlidingWindow {
    static FastReader scan = new FastReader();
    static int S, P, count;
    static String str;
    static int[] checkArr;
    static int[] myArr;
    static char[] arr;
    static void input(){
        S = scan.nextInt();
        P = scan.nextInt();
        checkArr = new int[4];
        myArr = new int[4];
        arr = new char[S];
        arr = scan.next().toCharArray();
        for(int i = 0; i < 4; i++){
            checkArr[i] = scan.nextInt();
            if(checkArr[i] == 0){
                count++;
            }
        }
    }
    private static void addCount(char c){
        switch(c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]){
                    count++;
                }
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]){
                    count++;
                }
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]){
                    count++;
                }
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]){
                    count++;
                }
                break;

        }
    }
    static void eraseCount(char c){
        switch(c){
            case 'A':
                if(myArr[0] == checkArr[0]){
                    count--;
                }
                myArr[0]--;

                break;
            case 'C':
                if(myArr[1] == checkArr[1]){
                    count--;
                }
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]){
                    count--;
                }
                myArr[2]--;

                break;
            case 'T':
                if(myArr[3] == checkArr[3]){
                    count--;
                }
                myArr[3]--;

                break;

        }

    }
    static void solution(){
        int result = 0, left = 0;
        for(int i = 0; i < P; i++){ // 부분 문자열 처음 받을때 셋팅
            addCount(arr[i]);
        }
        if(count == 4){
            result++;
        }
        // 슬라이딩 윈도우, 처음 P - 1 만큼 반복한 후 P부터 시작
        for(int right = P; right < S; right++){
            left = right - P;
            addCount(arr[right]);
            eraseCount(arr[left]);
            if(count == 4){
                result++;
            }
        }
        System.out.println(result);
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
    }
}
