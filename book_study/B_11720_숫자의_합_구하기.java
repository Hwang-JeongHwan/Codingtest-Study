package book_study;

import java.io.*;
import java.util.*;


public class B_11720_숫자의_합_구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] c = s.toCharArray();
        int result = 0;
        for(int i = 0; i < n; i ++){
//            result += c[i] - '0';
            result += s.charAt(i) - '0';
        }
        System.out.println(result);
    }
}
