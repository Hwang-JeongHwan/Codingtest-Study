package book_study;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

public class test {
    public static void main(String[] args) {
//
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(5);
//        arr.add(5);
//        arr.add(5);
//        System.out.println(arr.toString());
//        for(int i : arr){
//            System.out.println(i);
//        }
//        for(int i = 2; i >= 0; i--){
//            System.out.println(i);
//        }
        try{
            int arr[] = new int[3];
            arr[3] = 30;
            System.out.println("OK");
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
