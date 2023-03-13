package week9_TwoPointer;

import java.io.*;
import java.util.*;

public class G4_16472_고냥이 {
    static FastReader scan = new FastReader();
    static int n, len, kind;
    static String s;
    static int[] count;
    static void input(){
        n = scan.nextInt();
        s = scan.next();
        len = s.length();
        count = new int[26];

    }
    static void add(char x){// x라는 알파벳 추가
        count[x - 'a']++;
        if(count[x - 'a'] == 1){ // 0이었다가 1이되면 종류가 늘어남
            kind++;
        }
    }
    static void erase(char x){// x라는 알파벳 제거
        count[x - 'a']--;
        if(count[x - 'a'] == 0){ // 1이었다가 0이 되면 종류가 줄어듬
            kind--;
        }
    }
    static void solution(){
        int left = 0, result = 0;
        for(int right = 0; right < len; right++){
            // right번째 문자를 오른쪽에 추가
            add(s.charAt(right));

            // 불가능하면 가능할 때까지 left를 이동

//            while(true){
//                for(int i = 0; i < 26; i++) {
//                    if (count[i] != 0) {
//                        kind++;
//                    }
//                }
//                if(kind <= n){
//                    break;
//                }
//                // left번째 문자를 제거하고 left증가
//                erase(s.charAt(left));
//                left++;
//
//            }
            while(kind > n){
                erase(s.charAt(left));
                left++;
            }
            result = Math.max(result, right - left + 1);


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

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
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
