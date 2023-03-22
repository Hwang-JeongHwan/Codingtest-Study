package week10_TwoPointer2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G2_20442_ㅋㅋ루ㅋㅋ {
    static FastReader scan = new FastReader();
    static ArrayList<Integer> lk, rk;
    static void input(){
        String str = scan.next();
        int kCnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'K') kCnt++;
            else if(str.charAt(i) == 'R') lk.add(kCnt);
        }
        kCnt = 0;
        for(int i = str.length(); i >= 0; i--) kCnt++;

    }

    public static void main(String[] args) throws Exception {

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