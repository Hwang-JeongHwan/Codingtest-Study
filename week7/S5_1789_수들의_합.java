package week7;
import java.util.*;
import java.io.*;
public class S5_1789_수들의_합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        int i = 0;
        long sum = 0;

        while(sum < s) {
            i++;
            sum += i;
        }
        if(sum > s) {
            System.out.println(i-1);
        }else {
            System.out.println(i);
        }


    }

}
