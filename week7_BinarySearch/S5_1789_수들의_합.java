package week7_BinarySearch;
import java.util.*;

public class S5_1789_수들의_합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long count = 1;
        while(s - count > count){
            s -= count;
            count++;
        }
        System.out.println(count);



    }

}
