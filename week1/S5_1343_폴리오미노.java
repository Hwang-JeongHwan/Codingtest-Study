package week1;
import java.util.*;
import java.io.*;
public class S5_1343_폴리오미노 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String a = "AAAA";
        String b = "BB";
        s = s.replaceAll("XXXX",a); // 파이썬에서 replace랑 같음
        // System.out.println(first);
        s = s.replaceAll("XX",b);
        // System.out.println(s);
        if(s.contains("X")){ // 파이썬에서 s in 'X'랑 같음 
            System.out.println(-1);
        }
        else{
            System.out.println(s);
        }
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // String ax = st.nextToken();
        // int x = Integer.parseInt(st.nextToken());
        // System.out.printf("%s %d\n", ax, x);
        // st = new StringTokenizer(br.readLine());
        // String bx = st.nextToken();
        // String cx = st.nextToken();
        // System.out.printf("%s %s\n",bx, cx);
        // System.out.println(cx);
        
    }
    
}
