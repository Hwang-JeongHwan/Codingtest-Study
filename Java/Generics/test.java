package book_study;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
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
//        try{
//            int arr[] = new int[3];
//            arr[3] = 30;
//            System.out.println("OK");
//        }
//        catch(NullPointerException e){
//            e.printStackTrace();
//        }
//        Deque<Integer> deque = new LinkedList<>();
//        deque.add(1);
//        deque.addLast(2);
//        deque.add(3);
//        System.out.println(deque.pollFirst());
//        System.out.println(deque.pollFirst());

//        char c = 'A';
//        System.out.println((char)(c + 1));
//        Integer i = new Integer(10);
//        int i2 = i;
//        System.out.println(i);
//        System.out.println(i2);
//        int i3 = 50;
//        Integer i4 = Integer.valueOf(i3);
//        System.out.println(i4);

        ArrayList originArr = new ArrayList();
        originArr.add("abc");
        originArr.add(1);

        String str = (String)originArr.get(0);
        int i = (int)originArr.get(1);
        System.out.println(str + " " + i);
    }
}
